package Homework3.Employee;

import java.util.Scanner;

public class Inputs {

    private static String employeeName;
    private static String employeeEmail;
    private static String employeePhone;
    private static String employeePosition;
    private static int employeeAge;

    public static void doInputs() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name = Validator.validateNameInput(scanner);

        System.out.print("Enter the email: ");
        String email = Validator.validateEmailInput(scanner);

        System.out.print("Enter the phone: ");
        String phone = Validator.validatePhoneInput(scanner);

        System.out.print("Enter the position: ");
        String position = Validator.validatePositionInput(scanner);

        System.out.print("Enter the age: ");
        int age = Validator.validateAgeInput(scanner);

        Employee employee = new Employee(name, email, phone, position, age);
        employeeName = employee.getName();
        employeeEmail = employee.getEmail();
        employeePhone = employee.getPhone();
        employeePosition = employee.getPosition();
        employeeAge = employee.getAge();
    }

    public static void getOutput() {
        System.out.println("\nEmployee's info\n" +
                "name: " + employeeName + "\n" +
                "email: " + employeeEmail + "\n" +
                "phone: " + employeePhone + "\n" +
                "position: " + employeePosition + "\n" +
                "age: " + employeeAge
        );
    }
}
