public class Researcher extends Employee {

    private boolean isSenior;
    private IRODetector detector;

    public Researcher(int id, String name, int iris[][], boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean isSenior){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }
}
