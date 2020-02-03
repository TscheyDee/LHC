public class Researcher extends Employee {

    private boolean isSenior;
    private IRODetector detector;

    public Researcher(String name){
        super(name);
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public IRODetector getDetector() {
        return detector;
    }

    public void setDetector(IRODetector detector) {
        this.detector = detector;
    }
}
