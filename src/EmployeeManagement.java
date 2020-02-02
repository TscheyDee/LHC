import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement{
    instance;

    private HashMap<Integer, Employee> employeeMap;
    private CardManagement cardManagement;

    public Employee createEmployee(String name, EmployeeType type) {

        Employee employee;
        int[][] iris = new int[10][10];
        int[][] fingerprint = new int[10][10];

        switch (type) {
            case SECURITY_OFFICER:
                employee = new Researcher(name, iris, false,
                        false, false, null);
                return employee;

            case RESEARCHER:
                employee = new SecurityOfficer(name, iris, false,
                        false, false, null);
                return employee;

            case SCIENTIFIC_ASSISTANT:
                employee = new ScientificAssistant(name, iris, false,
                        false, false, null);
                return employee;

            case HR_ASSISTANT:
                employee = new HRAssistant(name, iris, false,
                        false, false, null);
                return employee;

            case HR_CONSULTANT:
                employee = new HRConsultant(name, iris, false,
                        false, false, null);
                return employee;

            case HR_HOD:
                employee = new HRHoD(name, iris, false,
                        false, false, null);
                return employee;

            default:
                System.out.println("---Invalid employee type parameter!");
                return null;
        }
    }

    public void assignIDCard(IDCardEmployee idCard, Employee employee) {
        employee.setIdCardEmployee(idCard);
    }

    public HashMap<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
}
