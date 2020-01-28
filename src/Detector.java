import java.util.LinkedList;

public class Detector implements IDetector {

    private static String higgsBosonStrcuture = "higgs";
    private boolean isActivated;
    private LinkedList<Experiment> experimentList;
    private ReaderTouchpad touchpadReader;

    public Detector(boolean isActivated, LinkedList<Experiment> experimentList, IrisScanner reader){
        this.higgsBosonStrcuture = this.higgsBosonStrcuture;
        this.isActivated = isActivated;
        this.experimentList = experimentList;
        this.touchpadReader = touchpadReader;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public LinkedList<Experiment> getExperimentList() {
        return experimentList;
    }

    public ReaderTouchpad getTouchpadReader() {
        return touchpadReader;
    }

    public void setTouchpadReader(ReaderTouchpad touchpadReader) {
        this.touchpadReader = touchpadReader;
    }
}
