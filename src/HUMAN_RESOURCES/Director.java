package HUMAN_RESOURCES;

import INFRASTRUCTURE.EXPERIMENT.REPORT.IDocumentDetectorListener;
import INFRASTRUCTURE.EXPERIMENT.REPORT.Report;

public class Director extends Employee implements IDocumentDetectorListener {

    private Report recenetReport;

    public Director(String name){
        super(name);
    }

    public void documentAdded(Report report){
        this.recenetReport = report;
        System.out.println("--- Director has received the document");
    }

    public Report getRecenetReport() {
        return recenetReport;
    }
}
