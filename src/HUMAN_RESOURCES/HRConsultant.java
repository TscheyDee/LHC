package HUMAN_RESOURCES;

import INFRASTRUCTURE.MANAGEMENT.EmployeeManagement;

public class HRConsultant extends Employee {

    public HRConsultant(String name){
        super(name);
    }

    public void addEmployeeToMap(Employee employee){
        EmployeeManagement.instance.addEmployeeToMap(employee);
    }
}
