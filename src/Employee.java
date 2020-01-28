public abstract class Employee extends Person {

    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;


    public Employee(int id, String name, int iris[][], boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, iris);
        this.isManager = isMentor;
        this.isMentor = isMentor;
        this.hasBudgetResponsibility = hasBudgetResponsibility;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isMentor() {
        return isMentor;
    }

    public void setMentor(boolean mentor) {
        isMentor = mentor;
    }

    public boolean isHasBudgetResponsibility() {
        return hasBudgetResponsibility;
    }

    public void setHasBudgetResponsibility(boolean hasBudgetResponsibility) {
        this.hasBudgetResponsibility = hasBudgetResponsibility;
    }
}
