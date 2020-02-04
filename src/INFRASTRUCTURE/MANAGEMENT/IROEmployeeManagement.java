package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;

import java.util.HashMap;

public interface IROEmployeeManagement {
    public HashMap<Integer, Employee> getEmployeeMap();
}
