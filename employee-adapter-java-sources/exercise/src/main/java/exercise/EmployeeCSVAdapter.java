package exercise;

public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV employeeCSV;
    
    public EmployeeCSVAdapter(EmployeeCSV employeeCSV) {
        this.employeeCSV = employeeCSV;
    }
    
    public String getId() {
        return employeeCSV.tokens()[0];
    }
    
    public String getFirstName() {
        return employeeCSV.tokens()[1];
    }
    
    public String getLastName() {
        return employeeCSV.tokens()[2];
    }
    
    public String getEmail() {
        return employeeCSV.tokens()[3];
    }
}