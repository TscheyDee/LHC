package INFRASTRUCTURE.EXPERIMENT.REPORT;

public class Final implements IReportState {

    public void promote(Report report){
        DocumentRepository.instance.addReportToList(report);
        System.out.println("document is now in repository");
    }

    public void print(){
        System.out.println("--- printing report based on business rules for status final");
    }

    public String toString(){
        return "Final";
    }
}
