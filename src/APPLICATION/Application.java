package APPLICATION;

import HUMAN_RESOURCES.*;
import INFRASTRUCTURE.EXPERIMENT.Experiment;
import INFRASTRUCTURE.EXPERIMENT.REPORT.DocumentDetector;
import INFRASTRUCTURE.EXPERIMENT.REPORT.DocumentRepository;
import INFRASTRUCTURE.EXPERIMENT.REPORT.Report;
import INFRASTRUCTURE.EXPERIMENT.REPORT.ReportEngine;
import INFRASTRUCTURE.MANAGEMENT.*;
import INFRASTRUCTURE.SECURITY.CardVerification;
import INFRASTRUCTURE.TECHNOLOGY.*;
import LHC.Detector;
import LHC.ProtonTrap;
import LHC.ProtonTrapID;
import LHC.Ring;

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

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new Touchpad());
        readerTouchpad.insertCard(visitor.getIdCardVisitor(), new RFID());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyVisitor(visitor, "12345");
        System.out.println("---Verification: " + result);
    }

    private static void UseCase4(){
        Employee employee = EmployeeManagement.instance.getEmployeeMap().get(0);
        SecurityCenter.instance.createNewIDCard(employee);

        ReaderTouchpad readerTouchpad = new ReaderTouchpad(new IrisScanner(), new Touchpad());
        readerTouchpad.insertCard(employee.getIdCardEmployee(), new Slot());

        //missing connection between card reader & card verification

        boolean result = CardVerification.instance.verifyEmployeeFull(employee, "helloLHC2020");
        System.out.println("---Verification: " + result);
    }

    private static void UseCase5(){
        Researcher researcher = new Researcher("Max Mustermann");
        researcher.getDetector().viewExperiments();
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

    public static void eventBusTest() {
        System.out.println("\n---------- eventBusTest() ----------");
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);

        Detector detector = new Detector();

        Ring ring = new Ring();
        ring.setProtonTraps(protonTrap1, protonTrap2);
        ring.setDetector(detector);

        ControlCenter controlCenter = ControlCenter.instance;

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        //controlCenter.startExperiment(ExperimentScope.ESFull);
        controlCenter.startExperiment();

        // Test output
        //detector.viewExperiments();
    }

    public static void TestReportEngine(){
        DocumentDetector documentDetector = new DocumentDetector();
        ReportEngine reportEngine = new ReportEngine();

        Director director = new Director("Carlo");
        ScientificAssistant scientificAssistant = new ScientificAssistant("Max");
        Researcher researcher = new Researcher("Matthew");

        DocumentRepository.instance.addDirectorToListeners(director);
        DocumentRepository.instance.setDocumentDetector(documentDetector);


        Report report = reportEngine.createReport(new Experiment());

        scientificAssistant.signReport(report);
        reportEngine.promoteReport(report);

        researcher.signReport(report);
        reportEngine.promoteReport(report);
    }
}
