public class Researcher extends Employee {

    private boolean isSenior;
    private IRODetector detector;

    public Researcher(String name, int iris[][], boolean isManager,
                      boolean isMentor, boolean hasBudgetResponsibility,
                      IDCardEmployee idCardEmployee){
        super(name, iris, isManager, isMentor, hasBudgetResponsibility, idCardEmployee);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }
}
