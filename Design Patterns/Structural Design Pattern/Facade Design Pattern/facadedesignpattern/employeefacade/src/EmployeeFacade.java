package facadedesignpattern.employeefacade.src;

public class EmployeeFacade {
    EmployeeDAO employeeDAO;

    public EmployeeFacade() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void insert() {
        Employee employee = new Employee();
        employeeDAO.insert(employee);
    }

    public Employee getEmployeeDetails(int empId) {
        return employeeDAO.getEmployee(empId);
    }
}
