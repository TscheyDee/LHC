package INFRASTRUCTURE.EXPERIMENT.REPORT;

import INFRASTRUCTURE.EXPERIMENT.Experiment;

public class Report {

    private IReportState state;
    private Experiment experiment;
    private boolean isSigned;

    public Report(){
        this.isSigned = false;
        this.state = new Draft();
    }

    public void viewReport() {
        System.out.println("--- Report:");
        System.out.println(experiment.toString());
    }

    public void promote(){
        state.promote(this);
    }

    public String toString(){
        return "{ Report : state = " + " } ";
    }

    public IReportState getReportState() {
        return state;
    }

    public void setReportState(IReportState iReportState) {
        this.state = iReportState;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }
}
