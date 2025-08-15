package facadedesignpattern.employeefacade.src;

public class Client {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        Employee employee = employeeFacade.getEmployeeDetails(123);
        System.out.println(employee);
    }
}
