package INFRASTRUCTURE.EXPERIMENT.REPORT;

import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.ScientificAssistant;
import INFRASTRUCTURE.EXPERIMENT.Experiment;

public class ReportEngine {

    public Report createReport(Experiment experiment){
        Report report = new Report();
        report.setExperiment(experiment);
        System.out.println(report);



        //new ScientificAssistant("").setReport(report);

        return report;
    }

    public void assignReport(Report report, Employee employee){

    }

    public void promoteReport(Report report){
        if (report.isSigned()){
            report.promote();
            report.setSigned(false);
        }
        else {
            System.out.println("--- Error: Signature not set - can't be promoted");
        }
    }

    public void setReportState(Report report, IReportState iReportState){
        report.setReportState(iReportState);
    }

    /*
    public void testReportState(){
        Report report = new Report();
        report.setReportState(new Draft());
        System.out.println(report);

        report.promote();
        System.out.println(report);

        System.out.println();

        report.promote();
        System.out.println(report);
    }*/
}
