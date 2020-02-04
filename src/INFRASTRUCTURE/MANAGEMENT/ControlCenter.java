package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;
import INFRASTRUCTURE.EXPERIMENT.ExperimentScope;
import INFRASTRUCTURE.SECURITY.CardVerification;
import LHC.Subscriber;
import INFRASTRUCTURE.TECHNOLOGY.ReaderTouchpad;
import INFRASTRUCTURE.Workplace;
import com.google.common.eventbus.EventBus;

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

    public boolean verifyEmployee(Employee employee, String pw){
        return CardVerification.instance.verifyEmployeeFull(employee, pw);
    }

    public ReaderTouchpad getReaderTouchpad() {
        return readerTouchpad;
    }

    public void setReaderTouchpad(ReaderTouchpad readerTouchpad) {
        this.readerTouchpad = readerTouchpad;
    }
}
