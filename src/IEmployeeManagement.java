public interface IEmployeeManagement extends IROEmployeeManagement {

    public void createEmployee(String name, String type);

    public void assignIDCard(IDCardEmployee idCard, Employee employee);

}
