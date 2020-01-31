public abstract class Employee extends Person {

    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;
    protected IDCardEmployee idCardEmployee;


    public Employee(int id, String name, int iris[][],
                    boolean isManager, boolean isMentor,
                    boolean hasBudgetResponsibility,
                    IDCardEmployee idCardEmployee){
        super(id, name, iris);
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
