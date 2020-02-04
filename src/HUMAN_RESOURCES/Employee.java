package HUMAN_RESOURCES;

import HUMAN_RESOURCES.Person;
import INFRASTRUCTURE.MANAGEMENT.IDCardEmployee;

public abstract class Employee extends Person {

    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;
    protected IDCardEmployee idCardEmployee;

    public Employee(String name){
        super(name);
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
