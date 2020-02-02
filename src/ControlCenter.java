import com.google.common.eventbus.EventBus;

import java.util.Date;

public enum ControlCenter {
    instance;

    private String roomID = "C01";
    private Workplace[] workplace = new Workplace[3];
    private ReaderTouchpad readerTouchpad;
    private CardManagement cardManagement;

    private EventBus eventBus;

    ControlCenter() {
        eventBus = new EventBus("ControlCenter");
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void startExperiment() {}

    public void startExperiment(ExperimentScope scope) {
        if (scope == ExperimentScope.ESFull) {
            // Beispielhaft
            // eventBus.post(new RunExperimentFull());
            // eventBus.post(new RunExperimentPartial());
            // eventBus.post(new Analyse());
        } else if (scope == ExperimentScope.ES20) {

        } else if (scope == ExperimentScope.ES10) {

        } else if (scope == ExperimentScope.ES5) {

        }
    }

    public boolean verifyEmployee(Employee employee, String pw,
                               int[][] iris, int[][] fingerprint){
        IDCardEmployee idCard = employee.getIdCardEmployee();

        if(cardManagement.validDate() && !idCard.isLocked()){
            boolean b1 = cardManagement.verifyPassword(idCard, pw);
            boolean b3 = cardManagement.verifyFingerprint(idCard, iris);
            boolean b2 = cardManagement.verifyIris(idCard, fingerprint);

            return (b1 && b2 && b3);
        }
        else{
            return false;
        }
    }

    public ReaderTouchpad getReaderTouchpad() {
        return readerTouchpad;
    }

    public void setReaderTouchpad(ReaderTouchpad readerTouchpad) {
        this.readerTouchpad = readerTouchpad;
    }
}
