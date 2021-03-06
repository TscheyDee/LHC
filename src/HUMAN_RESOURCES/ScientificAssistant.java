package HUMAN_RESOURCES;

import INFRASTRUCTURE.EXPERIMENT.REPORT.Report;

import java.util.Date;

public class ScientificAssistant extends Employee {

    private Date periodFrom;
    private Date periodUntil;

    public ScientificAssistant(String name){
        super(name);
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodUntil(){
        return periodUntil;
    }

    public void setPeriodUntil(Date periodUntil) {
        this.periodUntil = periodUntil;
    }

    public void signReport(Report report) {
        report.setSigned(true);
    }
}
