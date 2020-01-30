import java.util.Calendar;
import java.util.Date;
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

    public void createNewIDCard(Employee employee, int[][] iris) {
        IDCard idCard = blankIDCards.pop();
        cardManagement.createIDCard(employee, iris, idCard);
    }

    public void lockIDCard(IDCardEmployee idCard){
        cardManagement.lockIDCard(idCard);
    }

    public void clearIDCard(IDCardEmployee idCard){
        cardManagement.clearIDCard(idCard);
    }
}
