import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public enum CardManagement implements ICardManagement {
    instance;

    private HashMap<Integer, IDCard> idCardHashMap;
    private ReaderTouchpad touchpadReader;
    private CryptogrpahyManagement cryptogrpahyManagement;


    public void createIDCard(Employee employee, int[][] iris, IDCard idCard) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();

        idCard.setValidFrom(today);
        idCard.setValidUntil(nextYear);

        String password = "helloLHC2020";
        String encryptedPW = encryptPassword(password);

        Chip chip1 = new Chip(encryptedPW, idCard);
        Chip chip2 = new Chip("", idCard);

        touchpadReader.getScanner().scanIris(iris);
        int[][] newIris = touchpadReader.getScanner().getIris();

        idCard = new IDCardEmployee(employee.getName(), new Date(),
                new Date(), newIris, chip1, chip2);

        employee.setIdCard(idCard);
    }

    public void createIDCard(Visitor visitor, IDCard idCard, String password){
        idCard.setName(visitor.getName());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date nextYear = cal.getTime();

        idCard.setValidFrom(today);
        idCard.setValidUntil(nextYear);

        touchpadReader.getTouchpad().setInput(password);
        String newPassword = touchpadReader.getTouchpad().getInput();

        //String encryptedPW = AES.encrypt(newPassword, "secret");
        String encryptedPW = encryptPassword(newPassword);
        idCard.setChip(new Chip(encryptedPW, idCard));

        visitor.setIdCard(idCard);
    }

    public String encryptPassword(String password){
        return cryptogrpahyManagement.encrypt(password, cryptogrpahyManagement.getKey());
    }

    public String decryptPassword(String password){
        return cryptogrpahyManagement.decrypt(password, cryptogrpahyManagement.getKey());
    }

    public void changePassword(IDCard idCard, String oldPassword, String newPassword){
        if(verifyIDCard(idCard, oldPassword)){
            touchpadReader.getTouchpad().setInput(newPassword);
            idCard.getChip().setPassword( touchpadReader.getTouchpad().getInput());
        }
        else{
            System.out.println("---Invalid ID card verification!");
        }
    }

    public boolean verifyIDCard(IDCard idCard, String enteredPassword) {
        touchpadReader.getTouchpad().setInput(enteredPassword);
        String enteredPIN = touchpadReader.getTouchpad().getInput();
        String password = idCard.getChip().getPassword();
        password = encryptPassword(password);

        return (enteredPIN == password);
    }

    public boolean verifyIris(IDCardEmployee idCard, int[][] scannedIris) {
        touchpadReader.getScanner().scanIris(scannedIris);
        int[][] iris = touchpadReader.getScanner().getIris();
        int[][] cardIris = idCard.getIrisStructure();

        return (iris == cardIris);
    }

    public void lockIDCard(IDCard idCard){
        idCard.setLocked(true);
    }

    public void clearIDCard(IDCard idCard){
        idCard.setLocked(false);
    }
}
