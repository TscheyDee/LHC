import java.util.HashMap;

public interface IEmployeeManagement extends IROEmployeeManagement {

    //public Employee createEmployee(String name, EmployeeType type);

    //public void assignIDCard(IDCardEmployee idCard, Employee employee);

    public HashMap<Integer, Employee> getEmployeeMap();

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap);
}
