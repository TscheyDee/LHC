package INFRASTRUCTURE.EXPERIMENT.REPORT;

import HUMAN_RESOURCES.Director;

import java.util.Stack;

public enum DocumentRepository {
    instance;

    private Stack<Report> reports;
    private DocumentDetector documentDetector;

    DocumentRepository(){
        this.reports = new Stack<>();
    }

    public void addReportToList(Report report){
        this.reports.add(report);
        System.out.println("--- Document has been added to the repository");
        documentDetector.sendMessage(report);
}

    public Stack<Report> getReports() {
        return reports;
    }

    public void addDirectorToListeners(Director director) {
        this.documentDetector.addListenerToList(director);
    }

    public void setDocumentDetector(DocumentDetector documentDetector) {
        this.documentDetector = documentDetector;
    }

    public DocumentDetector getDocumentDetector() {
        return documentDetector;
    }
}
