public class HRAssistant extends Employee {

    IROEmployeeManagement iroEmployeeManagement;

    public HRAssistant(String name){
        super(name);
    }

    public IROEmployeeManagement getIroEmployeeManagement() {
        return iroEmployeeManagement;
    }

    public void setIroEmployeeManagement(IROEmployeeManagement iroEmployeeManagement) {
        this.iroEmployeeManagement = iroEmployeeManagement;
    }
}
