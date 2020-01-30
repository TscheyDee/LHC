import java.util.Date;
import java.util.Stack;

public enum Reception {
    instance ;

    private Stack<IDCardVisitor> blankIDCards;
    private Employee employee;
    private ReaderTouchpad touchpadReader;


    public void addBlankIDCard() {
        IDCardVisitor idCard = new IDCardVisitor();
        blankIDCards.add(idCard);
    }

    public void createNewIDCard(Visitor visitor, String password) {
        IDCardVisitor idCard = blankIDCards.pop();
        idCard.setName(visitor.getName());

        Date date = new Date();
        idCard.setValidFrom(date);
        //date = date.getDatumHeute() + wie lange haltbar
        idCard.setValidUntil(date);

        String newPassword = touchpadReader.getTouchpad().setInput(password);
        String encryptedPW = AES.encrypt(newPassword, "secret");
        idCard.setChip(new Chip(encryptedPW, idCard));

        visitor.setIdCard(idCard);
    }
}

