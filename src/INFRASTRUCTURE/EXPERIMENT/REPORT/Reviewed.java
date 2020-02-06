package INFRASTRUCTURE.EXPERIMENT.REPORT;

public class Reviewed implements IReportState {

    public void promote(Report report){
        System.out.println("promoting reviewed -> final");
        report.setReportState(new Final());
    }

    public void print(){
        System.out.println("--- printing report based on business rules for status reviewed");
    }

    public String toString(){
        return "Reviewed";
    }
}
