import java.util.Date;
import java.util.Stack;

public enum SecurityCenter {
    instance;

    private Stack<IDCard> blankIDCards;
    private SecurityOfficer securityOfficer;
    private ReaderTouchpad touchpadReader;

    public void addBlankIDCard() {
        IDCard idCard = new IDCard();
        blankIDCards.add(idCard);
    }

    public void createNewIDCard(Employee employee) {
        IDCard idCard = blankIDCards.pop();

        Date date = new Date();
        idCard.setValidFrom(date);
        idCard.setValidUntil(date);

        int iris[][] = new int[10][10];

        String password = "helloLHC2020";
        String encryptedPW = AES.encrypt(password, "secret");

        Chip chip1 = new Chip(encryptedPW, idCard);
        Chip chip2 = new Chip("", idCard);

        idCard = new IDCardEmployee(employee.getName(), new Date(),
                new Date(), iris, chip1, chip2);

        employee.setIdCard(idCard);
    }

    public void lockIDCard(IDCardEmployee idCard){
        idCard.setLocked(true);
    }
}
