package com.jdbc;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeApp {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        EmployeeDAO dao =
                new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter employee name: "
                    );

                    String name =
                            scanner.nextLine();

                    System.out.print(
                            "Enter email: "
                    );

                    String email =
                            scanner.nextLine();

                    System.out.print(
                            "Enter salary: "
                    );

                    double salary =
                            scanner.nextDouble();

                    scanner.nextLine();

                    System.out.print(
                            "Enter department: "
                    );

                    String department =
                            scanner.nextLine();

                    System.out.print(
                            "Enter joining date (YYYY-MM-DD): "
                    );

                    String date =
                            scanner.nextLine();

                    Employee employee =
                            new Employee(
                                    name,
                                    email,
                                    salary,
                                    department,
                                    Date.valueOf(date)
                            );

                    dao.addEmployee(employee);

                    break;


                case 2:

                    List<Employee> employees =
                            dao.getAllEmployees();

                    System.out.println(
                            "\n===== EMPLOYEE LIST ====="
                    );

                    for (Employee e : employees) {

                        System.out.println(e);
                    }

                    break;


                case 3:

                    System.out.print(
                            "Enter employee ID: "
                    );

                    int updateId =
                            scanner.nextInt();

                    System.out.print(
                            "Enter new salary: "
                    );

                    double newSalary =
                            scanner.nextDouble();

                    dao.updateEmployee(
                            updateId,
                            newSalary
                    );

                    break;


                case 4:

                    System.out.print(
                            "Enter employee ID: "
                    );

                    int deleteId =
                            scanner.nextInt();

                    dao.deleteEmployee(
                            deleteId
                    );

                    break;


                case 5:

                    System.out.println(
                            "Application closed."
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }
}