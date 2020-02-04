package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.SecurityOfficer;

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

    public void createNewIDCard(Employee employee) {
        IDCardEmployee idCard = blankIDCards.pop();
        cardManagement.createIDCard(employee, employee.getIris(), employee.getFingerprint(), idCard);
    }

    public void lockIDCard(IDCardEmployee idCard){
        cardManagement.lockIDCard(idCard);
    }

    public void clearIDCard(IDCardEmployee idCard){
        cardManagement.clearIDCard(idCard);
    }
}
