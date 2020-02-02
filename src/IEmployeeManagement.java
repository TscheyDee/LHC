public interface IEmployeeManagement extends IROEmployeeManagement {

    public Employee createEmployee(String name, EmployeeType type);

    public void assignIDCard(IDCardEmployee idCard, Employee employee);
}
