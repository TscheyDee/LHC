package APPLICATION;

import HUMAN_RESOURCES.HRAssistant;
import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.Researcher;
import HUMAN_RESOURCES.Visitor;
import INFRASTRUCTURE.MANAGEMENT.EmployeeManagement;
import INFRASTRUCTURE.MANAGEMENT.EmployeeType;
import INFRASTRUCTURE.MANAGEMENT.Reception;
import INFRASTRUCTURE.MANAGEMENT.SecurityCenter;
import INFRASTRUCTURE.SECURITY.CardVerification;
import INFRASTRUCTURE.TECHNOLOGY.*;

public class Application {

    public void main(String[] args){
        UseCase1();
        UseCase2();
        UseCase3();
        UseCase4();
        UseCase5();
        UseCase6();
        UseCase7();
    }

    private static void UseCase1(){
        EmployeeManagement.instance.createEmployee("Max Mustermann", EmployeeType.RESEARCHER);
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);
    }

    private static void UseCase2(){
        Visitor visitor = new Visitor("Max Mustermann");
        Reception.instance.createNewIDCard(visitor, "12345");
    }

    private static void UseCase3(){
        Visitor visitor = new Visitor("Max Mustermann");
        Reception.instance.createNewIDCard(visitor, "12345");

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new FingerprintScanner(), new Touchpad());
        readerTouchpad.insertCard(visitor.getIdCardVisitor(), new RFID());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyVisitor(visitor, "12345");
        System.out.println("---Verification: " + result);
    }

    private static void UseCase4(){
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new FingerprintScanner(), new Touchpad());
        readerTouchpad.insertCard(employee.getIdCardEmployee(), new Slot());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyEmployeeFull(employee, "helloLHC2020");
        System.out.println("---Verification: " + result);
    }

    private static void UseCase5(){
        Researcher researcher = new Researcher("Max Mustermann");
        researcher.getDetector().getExperimentList();
    }

    private static void UseCase6(){
        HRAssistant hrAssistant = new HRAssistant("Max Mustermann");
        hrAssistant.getIroEmployeeManagement().getEmployeeMap();
    }

    private static void UseCase7(){
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);
        SecurityCenter.instance.lockIDCard(employee.getIdCardEmployee());
        System.out.println("---Is INFRASTRUCTURE.MANAGEMENT.IDCard locked?: " + employee.getIdCardEmployee().isLocked());
    }
}
