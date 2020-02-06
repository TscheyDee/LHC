package INFRASTRUCTURE.EXPERIMENT.REPORT;

public class Draft implements IReportState {

    public void promote(Report report){
        System.out.println("promoting draft -> reviewed");
        report.setReportState(new Reviewed());
    }

    public void print(){
        System.out.println("--- printing report based on business rules for status draft");
    }

    public String toString(){
        return "Draft";
    }
}
