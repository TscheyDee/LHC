import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement{
    instance;

    private HashMap<Integer, Employee> employeeMap;

    public void createEmployee(String name, EmployeeType type) {

        switch (type) {
            case SECURITY_OFFICER:
                Researcher researcher;
                break;

            case RESEARCHER:
                SecurityOfficer securityOfficer;
                break;

            case SCIENTIFIC_ASSISTANT:
                ScientificAssistant scientificAssistant;
                break;

            case HR_ASSISTANT:
                HRAssistant hrAssistant;
                break;

            case HR_CONSULTANT:
                HRConsultant hrConsultant;
                break;

            case HR_HOD:
                HRHoD hrHoD;
                break;

            default:
                System.out.println("---Invalid employee type parameter!");
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
