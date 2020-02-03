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

    public static void UseCase1(){
        EmployeeManagement.instance.createEmployee("Max Mustermann", EmployeeType.RESEARCHER);
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);
    }

    public static void UseCase2(){
        Visitor visitor = new Visitor("Max Mustermann");
        Reception.instance.createNewIDCard(visitor, "12345");
    }

    public static void UseCase3(){
        Visitor visitor = new Visitor("Max Mustermann");
        Reception.instance.createNewIDCard(visitor, "12345");

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new FingerprintScanner(), new Touchpad());
        readerTouchpad.insertCard(visitor.getIdCardVisitor(), new RFID());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyVisitor(visitor, "12345");
        System.out.println("---Verification: " + result);
    }

    public static void UseCase4(){
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new FingerprintScanner(), new Touchpad());
        readerTouchpad.insertCard(employee.getIdCardEmployee(), new Slot());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyEmployeeFull(employee, "helloLHC2020");
        System.out.println("---Verification: " + result);
    }

    public static void UseCase5(){
        Researcher researcher = new Researcher("Max Mustermann");
        researcher.getDetector().getExperimentList();
    }

    public static void UseCase6(){
        HRAssistant hrAssistant = new HRAssistant("Max Mustermann");
        hrAssistant.getIroEmployeeManagement().getEmployeeMap();
    }

    public static void UseCase7(){
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);
        SecurityCenter.instance.lockIDCard(employee.getIdCardEmployee());
        System.out.println("---Is IDCard locked?: " + employee.getIdCardEmployee().isLocked());
    }
}
