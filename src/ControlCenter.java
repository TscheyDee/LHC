import com.google.common.eventbus.EventBus;

public enum ControlCenter {
    instance;

    private String roomID = "C01";
    private Workplace[] workplace = new Workplace[3];

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

}
