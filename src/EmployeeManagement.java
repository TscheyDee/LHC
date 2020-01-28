import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement{
    instance;

    private IrisScanner reader;
    private HashMap<Integer, Employee> employeeMap;

    public void createEmployee(String name, String type) {

        switch (type) {
            case "researcher":
                Researcher researcher;
                break;

            case "security":
                SecurityOfficer securityOfficer;
                break;

            case "scientific":
                ScientificAssistant scientificAssistant;
                break;

            default:
        }
    }

    public void assignIDCard(IDCardEmployee idCard, Employee employee) {
        employee.setIdCard(idCard);
    }

    public HashMap<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
}
