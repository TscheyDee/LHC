public interface IEmployeeManagement extends IROEmployeeManagement {

    public void createEmployee(String name, EmployeeType type);

    public void assignIDCard(IDCardEmployee idCard, Employee employee);
}
