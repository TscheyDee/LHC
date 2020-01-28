import java.util.HashMap;

public class HRDepartment {

    IROEmployeeManagement iroEmployeeManagement;

    public HRDepartment(IROEmployeeManagement iroEmployeeManagement){
        this.iroEmployeeManagement = iroEmployeeManagement;
    }

    public IROEmployeeManagement getIroEmployeeManagement() {
        return iroEmployeeManagement;
    }

    public void setIroEmployeeManagement(IROEmployeeManagement iroEmployeeManagement) {
        this.iroEmployeeManagement = iroEmployeeManagement;
    }
}
