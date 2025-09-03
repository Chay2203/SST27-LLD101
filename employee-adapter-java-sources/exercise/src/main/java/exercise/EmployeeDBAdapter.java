package exercise;

public class EmployeeDBAdapter implements Employee {
    private final EmployeeDB employeeDB;
    
    public EmployeeDBAdapter(EmployeeDB employeeDB) {
        this.employeeDB = employeeDB;
    }
    
    public String getId() {
        return String.valueOf(employeeDB.getId());
    }
    
    public String getFirstName() {
        return employeeDB.getFirstName();
    }
    
    public String getLastName() {
        return employeeDB.getSurname();
    }
    
    public String getEmail() {
        return employeeDB.getEmailAddress();
    }
}