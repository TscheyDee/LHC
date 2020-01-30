import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public enum CardManagement implements ICardManagement {
    instance;

    private HashMap<Integer, IDCard> idCardHashMap;
    private ReaderTouchpad touchpadReader;

    public boolean verifyIDCard(IDCard idCard){
        String enteredPIN = touchpadReader.enterPIN();
        String password = idCard.getChip().getPassword();

        return (enteredPIN == password);
    }

    public void createIDCardEmployee(Employee employee, IDCard idCard) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();

        idCard.setValidFrom(today);
        idCard.setValidUntil(nextYear);

        int iris[][] = new int[10][10];

        String password = "helloLHC2020";
        String encryptedPW = AES.encrypt(password, "secret");

        Chip chip1 = new Chip(encryptedPW, idCard);
        Chip chip2 = new Chip("", idCard);

        idCard = new IDCardEmployee(employee.getName(), new Date(),
                new Date(), iris, chip1, chip2);

        employee.setIdCard(idCard);
    }

    public void createIDCardVisitor(Visitor visitor, IDCard idCard, String password){
        idCard.setName(visitor.getName());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date nextYear = cal.getTime();

        idCard.setValidFrom(today);
        idCard.setValidUntil(nextYear);

        touchpadReader.getTouchpad().setInput(password);
        String newPassword = touchpadReader.getTouchpad().getInput();

        String encryptedPW = AES.encrypt(newPassword, "secret");
        idCard.setChip(new Chip(encryptedPW, idCard));

        visitor.setIdCard(idCard);
    }

    public void changePassword(IDCard idCard, String newPassword){
        if(verifyIDCard(idCard)){
            touchpadReader.getTouchpad().setInput(newPassword);
            idCard.getChip().setPassword( touchpadReader.getTouchpad().getInput());
        }
        else{
            System.out.println("---Invalid ID card verification!");
        }
    }

    public boolean verifyIris(IDCardEmployee idCard){
        int[][] scannedIris = touchpadReader.getScanner().getIris();
        int[][] cardIris = idCard.getIrisStructure();

        return (scannedIris == cardIris);
    }

    public void lockIDCard(IDCard idCard){
        idCard.setLocked(true);
    }

    public void clearIDCard(IDCard idCard){
        idCard.setLocked(false);
    }
}
