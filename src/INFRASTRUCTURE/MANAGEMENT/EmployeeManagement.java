package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.*;

import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement {
    instance;

    private HashMap<Integer, Employee> employeeMap;
    private CardManagement cardManagement;
    private int keyCount = 0;


    public void createEmployee(String name, EmployeeType type) {

        Employee employee;

        switch (type) {
            case SECURITY_OFFICER:
                employee = new Researcher(name);
                employeeMap.put(keyCount, employee);
                break;

            case RESEARCHER:
                employee = new SecurityOfficer(name);
                employeeMap.put(keyCount, employee);
                break;

            case SCIENTIFIC_ASSISTANT:
                employee = new ScientificAssistant(name);
                employeeMap.put(keyCount, employee);
                break;

            case HR_ASSISTANT:
                employee = new HRAssistant(name);
                employeeMap.put(keyCount, employee);
                break;

            case HR_CONSULTANT:
                employee = new HRConsultant(name);
                employeeMap.put(keyCount, employee);
                break;

            case HR_HOD:
                employee = new HRHoD(name);
                employeeMap.put(keyCount, employee);
                break;

            default:
                System.out.println("---Invalid employee type parameter!");
                break;
        }
        keyCount++;
    }

    public void assignIDCard(IDCardEmployee idCard, Employee employee) {
        employee.setIdCardEmployee(idCard);
    }

    public int getKeyCount() {
        return keyCount;
    }

    public HashMap<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void addEmployeeToMap(Employee employee){
        employeeMap.put(keyCount, employee);
        keyCount++;
    }

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
}
