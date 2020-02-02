import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public enum CardManagement implements ICardManagement {
    instance;

    private HashMap<Integer, IDCard> idCardHashMap;
    private ReaderTouchpad touchpadReader;
    private CryptogrpahyManagement cryptogrpahyManagement;


    public void createIDCard(Employee employee, int[][] iris, String fingerprint, IDCard idCard) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();

        String password = "helloLHC2020";
        String encryptedPW = encryptPassword(password);
        Chip chip1 = new Chip(encryptedPW, idCard);

        String newFingerprint = MD5CryptoUtilities.instance.generate(employee.getName());
        Chip chip2 = new Chip(newFingerprint, idCard);

        touchpadReader.getIrisScanner().scan(iris);
        int[][] newIris = touchpadReader.getIrisScanner().getIris();

        IDCardEmployee idCardEmployee = new IDCardEmployee(
                employee.getName(), today,
                nextYear, newIris, chip1, chip2);

        employee.setIdCardEmployee(idCardEmployee);
    }

    public void createIDCard(Visitor visitor, IDCard idCard, String password){
        idCard.setName(visitor.getName());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        Date nextYear = cal.getTime();

        touchpadReader.getTouchpad().setInput(password);
        String newPassword = touchpadReader.getTouchpad().getInput();

        //String encryptedPW = AES.encrypt(newPassword, "secret");
        String encryptedPW = encryptPassword(newPassword);
        idCard.setChip(new Chip(encryptedPW, idCard));

        IDCardVisitor idCardVisitor = new IDCardVisitor(
                visitor.getName(), today, nextYear, new Chip(encryptedPW, idCard));
        visitor.setIdCardVisitor(idCardVisitor);
    }

    public String encryptPassword(String password){
        return cryptogrpahyManagement.encrypt(password, cryptogrpahyManagement.getKey());
    }

    public String decryptPassword(String password){
        return cryptogrpahyManagement.decrypt(password, cryptogrpahyManagement.getKey());
    }

    public void changePassword(IDCard idCard, String oldPassword, String newPassword){
        if(verifyPassword(idCard, oldPassword)){
            touchpadReader.getTouchpad().setInput(newPassword);
            idCard.getChip().setPassword( touchpadReader.getTouchpad().getInput());
        }
        else{
            System.out.println("---Invalid ID card verification!");
        }
    }

    public boolean verifyPassword(IDCard idCard, String enteredPassword) {
        touchpadReader.getTouchpad().setInput(enteredPassword);
        String enteredPIN = touchpadReader.getTouchpad().getInput();
        String password = idCard.getChip().getPassword();
        password = decryptPassword(password);

        return (enteredPIN == password);
    }

    public boolean verifyFingerprint(IDCardEmployee idCard, String scannedFinerprint) {
        String cardFingerprint = idCard.getFingerprintChip().getPassword();
        scannedFinerprint = MD5CryptoUtilities.instance.generate(scannedFinerprint);

        return (scannedFinerprint == cardFingerprint);
    }

    public boolean verifyIris(IDCardEmployee idCard, int[][] scannedIris) {
        touchpadReader.getIrisScanner().scan(scannedIris);
        int[][] iris = touchpadReader.getIrisScanner().getIris();
        int[][] cardIris = idCard.getIrisStructure();

        return (iris == cardIris);
    }

    public void lockIDCard(IDCard idCard){
        idCard.setLocked(true);
    }

    public void clearIDCard(IDCard idCard){
        idCard.setLocked(false);
    }

    public boolean validDate(IDCard idCard){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();
        simpleDateFormat.format(today);

        Date until = idCard.getValidUntil();
        simpleDateFormat.format(until);

        if(today.compareTo(until) > 0) {
            System.out.println("Date 1 occurs after Date 2");
            return false;

        } else if(today.compareTo(until) < 0) {
            System.out.println("Date 1 occurs before Date 2");
            return true;

        } else { //if(today.compareTo(until) == 0) {
            System.out.println("Both dates are equal");
            return false;
        }
    }
}
