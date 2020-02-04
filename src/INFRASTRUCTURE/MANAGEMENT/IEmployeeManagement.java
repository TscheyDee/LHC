package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;

import java.util.HashMap;

public interface IEmployeeManagement extends IROEmployeeManagement {

    //public HUMAN_RESOURCES.Employee createEmployee(String name, INFRASTRUCTURE.MANAGEMENT.EmployeeType type);

    //public void assignIDCard(INFRASTRUCTURE.MANAGEMENT.IDCardEmployee idCard, HUMAN_RESOURCES.Employee employee);

    public HashMap<Integer, Employee> getEmployeeMap();

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap);
}
