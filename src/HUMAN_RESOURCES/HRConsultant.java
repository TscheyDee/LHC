package HUMAN_RESOURCES;

import INFRASTRUCTURE.MANAGEMENT.EmployeeManagement;

import java.util.HashMap;

public class HRConsultant extends Employee {

    public HRConsultant(String name){
        super(name);
    }

    public void addEmployeeToMap(Employee employee){
        EmployeeManagement.instance.addEmployeeToMap(employee);
    }
}
