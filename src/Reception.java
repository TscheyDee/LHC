import java.util.Stack;

public enum Reception {
    instance ;

    private Stack<IDCardVisitor> blankIDCards;
    private Employee employee;
    private CardManagement cardManagement;


    public void addBlankIDCard() {
        IDCardVisitor idCard = new IDCardVisitor();
        blankIDCards.add(idCard);
    }

    public void createNewIDCard(Visitor visitor, String password) {
        IDCardVisitor idCard = blankIDCards.pop();
        cardManagement.createIDCard(visitor, idCard, password);
    }

    public void lockIDCard(IDCardVisitor idCard){
        cardManagement.lockIDCard(idCard);
    }

    public void clearIDCard(IDCardVisitor idCard){
        cardManagement.clearIDCard(idCard);
    }
}
