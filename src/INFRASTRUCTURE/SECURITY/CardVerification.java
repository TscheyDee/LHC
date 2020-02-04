package INFRASTRUCTURE.SECURITY;

import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.Visitor;
import INFRASTRUCTURE.MANAGEMENT.CardManagement;
import INFRASTRUCTURE.MANAGEMENT.IDCardEmployee;
import INFRASTRUCTURE.MANAGEMENT.IDCardVisitor;

public enum CardVerification {
    instance;

    public boolean verifyVisitor(Visitor visitor, String pw){
        IDCardVisitor idCard = visitor.getIdCardVisitor();

        if(CardManagement.instance.validDate(visitor.getIdCardVisitor()) && !idCard.isLocked()){
            return CardManagement.instance.verifyPassword(idCard, pw);
        }
        else{
            return false;
        }
    }

    public boolean verifyEmployee(Employee employee, String pw) {
        IDCardEmployee idCard = employee.getIdCardEmployee();

        if (CardManagement.instance.validDate(employee.getIdCardEmployee()) && !idCard.isLocked()) {
            boolean b1 = CardManagement.instance.verifyPassword(idCard, pw);
            boolean b2 = CardManagement.instance.verifyFingerprint(idCard, employee.getFingerprint());

            return (b1 && b2);
        } else {
            return false;
        }
    }

    public boolean verifyEmployeeFull(Employee employee, String pw){
        IDCardEmployee idCard = employee.getIdCardEmployee();

        if (CardManagement.instance.validDate(employee.getIdCardEmployee()) && !idCard.isLocked()) {
            boolean b1 = CardManagement.instance.verifyPassword(idCard, pw);
            boolean b3 = CardManagement.instance.verifyFingerprint(idCard, employee.getFingerprint());
            boolean b2 = CardManagement.instance.verifyIris(employee);

            return (b1 && b2 && b3);
        } else {
            return false;
        }
    }
}
