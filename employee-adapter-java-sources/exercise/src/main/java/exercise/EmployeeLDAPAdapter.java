package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP employeeLDAP;
    
    public EmployeeLDAPAdapter(EmployeeLDAP employeeLDAP) {
        this.employeeLDAP = employeeLDAP;
    }
    
    public String getId() {
        return employeeLDAP.get("uid");
    }
    
    public String getFirstName() {
        return employeeLDAP.get("givenName");
    }
    
    public String getLastName() {
        return employeeLDAP.get("sn");
    }
    
    public String getEmail() {
        return employeeLDAP.get("mail");
    }
}
