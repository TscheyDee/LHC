import java.util.Stack;

public enum SecurityCenter {
    instance;

    private Stack<IDCardEmployee> blankIDCards;
    private SecurityOfficer securityOfficer;
    private CardManagement cardManagement;

    public void addBlankIDCard() {
        IDCardEmployee idCard = new IDCardEmployee();
        blankIDCards.add(idCard);
    }

    public void createNewIDCard(Employee employee, int[][] iris, String fingerprint) {
        IDCardEmployee idCard = blankIDCards.pop();
        cardManagement.createIDCard(employee, iris, fingerprint, idCard);
    }

    public void lockIDCard(IDCardEmployee idCard){
        cardManagement.lockIDCard(idCard);
    }

    public void clearIDCard(IDCardEmployee idCard){
        cardManagement.clearIDCard(idCard);
    }
}
