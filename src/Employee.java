public abstract class Employee extends Person {

    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;
    protected IDCardEmployee idCardEmployee;


    public Employee(String name, boolean isManager, boolean isMentor,
                    boolean hasBudgetResponsibility,
                    IDCardEmployee idCardEmployee){
        super(name);
        this.isManager = isManager;
        this.isMentor = isMentor;
        this.hasBudgetResponsibility = hasBudgetResponsibility;
        this.idCardEmployee = idCardEmployee;
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

    public IDCardEmployee getIdCardEmployee() {
        return idCardEmployee;
    }

    public void setIdCardEmployee(IDCardEmployee idCardEmployee) {
        this.idCardEmployee = idCardEmployee;
    }
}
