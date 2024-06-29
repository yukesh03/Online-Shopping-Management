import java.util.*;

// Enum for User Roles
enum UserRole {
    ADMIN,
    CUSTOMER,
    SUPPLIER
}

// User class representing each user
class User {
    private String userId;
    private String password;
    private UserRole role;

    public User(String userId, String password, UserRole role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}

// Main System class for Online Shopping Management
public class OnlineShoppingManagementSystem {
    private Map<String, User> userDatabase;
    private Map<String, List<String>> customerDetails;
    private Map<String, List<String>> productRecords;
    private Map<String, List<String>> supplierDetails;
    private List<String> salesDatabase;

    public OnlineShoppingManagementSystem() {
        // Initialize databases
        userDatabase = new HashMap<>();
        customerDetails = new HashMap<>();
        productRecords = new HashMap<>();
        supplierDetails = new HashMap<>();
 salesDatabase = new ArrayList<>();
    }

    // Method to add a new user to the system
    public void addUser(String userId, String password, UserRole role) {
        User newUser = new User(userId, password, role);
        userDatabase.put(userId, newUser);
    }

    // Method to authenticate user login
    public boolean authenticateUser(String userId, String password) {
        if (userDatabase.containsKey(userId)) {
            User user = userDatabase.get(userId);
            return user.getPassword().equals(password);
        }
        return false;
    }

    // Method to add customer details
    public void addCustomerDetails(String customerId, List<String> details) {
        customerDetails.put(customerId, details);
    }

    // Method to add product records
    public void addProductRecords(String productId, List<String> details) {
        productRecords.put(productId, details);
    }

    // Method to add supplier details
    public void addSupplierDetails(String supplierId, List<String> details) {
        supplierDetails.put(supplierId, details);
    }

    // Method to add sales record
    public void addSalesRecord(String salesRecord) {
        salesDatabase.add(salesRecord);
    }

    // Main method to run the system (example usage)
    public static void main(String[] args) {
        OnlineShoppingManagementSystem system = new OnlineShoppingManagementSystem();

        // Adding users (for demonstration)
        system.addUser("admin", "admin123", UserRole.ADMIN);
        system.addUser("customer1", "customer123", UserRole.CUSTOMER);
        system.addUser("supplier1", "supplier123", UserRole.SUPPLIER);

        // Authentication example
 String userId = "admin";
        String password = "admin123";
        if (system.authenticateUser(userId, password)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }

        // Adding sample data (customer details, product records, etc.)
        List<String> customerDetails1 = Arrays.asList("John Doe", "johndoe@example.com", "Address");
        system.addCustomerDetails("C001", customerDetails1);

        List<String> productDetails1 = Arrays.asList("Product A", "Category", "Description", "Price");
        system.addProductRecords("P001", productDetails1);

        List<String> supplierDetails1 = Arrays.asList("Supplier A", "supplierA@example.com", "Address");
        system.addSupplierDetails("S001", supplierDetails1);

        // Adding a sample sales record
        String salesRecord1 = "S001, C001, P001, Quantity: 2, Total Price: $100";
        system.addSalesRecord(salesRecord1);
    }
}

