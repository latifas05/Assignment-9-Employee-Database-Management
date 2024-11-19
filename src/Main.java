import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeData data = new EmployeeData();

        try {
            Employee newEmployee = new Employee("Alice Johnson", "Software Engineer", 85000, new Date());
            data.createEmployee(newEmployee);
            System.out.println("Employee created successfully!");
            int searchId = 1;
            Employee employeeById = data.getEmployeeById(searchId);
            if (employeeById != null) {
                System.out.println("\nRetrieved Employee by ID:");
                System.out.println(employeeById);
            } else {
                System.out.println("\nNo employee found with ID " + searchId);
            }

            // Retrieve and display all employees
            System.out.println("\nAll Employees in the Database:");
            List<Employee> allEmployees = data.getAllEmployees();
            for (Employee emp : allEmployees) {
                System.out.println(emp);
            }

            // Update an employee's details
            if (!allEmployees.isEmpty()) {
                Employee employeeToUpdate = allEmployees.get(0);
                employeeToUpdate.setName("Alice Smith");
                employeeToUpdate.setPosition("Senior Software Engineer");
                employeeToUpdate.setSalary(95000);
                data.updateEmployee(employeeToUpdate);
                System.out.println("\nEmployee updated successfully!");

                // Verify the update
                Employee updatedEmployee = data.getEmployeeById(employeeToUpdate.getId());
                System.out.println("\nUpdated Employee Details:");
                System.out.println(updatedEmployee);
            }

            // Delete an employee
            if (!allEmployees.isEmpty()) {
                int deleteId = allEmployees.get(0).getId(); // Delete the first employee in the list
                data.deleteEmployee(deleteId);
                System.out.println("\nEmployee with ID " + deleteId + " deleted successfully!");

                // Verify deletion
                Employee deletedEmployee = data.getEmployeeById(deleteId);
                if (deletedEmployee == null) {
                    System.out.println("\nEmployee with ID " + deleteId + " no longer exists in the database.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
