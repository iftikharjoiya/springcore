package org.springcore;

import org.springcore.Dao.EmployeeDao;
import org.springcore.Models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao=(EmployeeDao) context.getBean("employeeDao");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while (go) {
            System.out.println("PRESS 1 TO ADD NEW EMPLOYEE.");
            System.out.println("PRESS 2 TO GET DETAIL OF SINGLE EMPLOYEE");
            System.out.println("PRESS 3 TO DISPLAY ALL EMPLOYEE");

            System.out.println("PRESS 4 TO DELETE A STUDENT");
            System.out.println("PRESS 5 TO UPDATE A STUDENT");
            System.out.println("PRESS 6 FOR EXIT");

        try {
            int input = Integer.parseInt(reader.readLine());
            switch (input) {
                case 1:
                    Employee employee = new Employee();
                    System.out.println("Enter Employee Id:");
                    int empId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Employee Name:");
                    String empName = reader.readLine();
                    System.out.println("Enter Employee Address:");
                    String empAddress = reader.readLine();
                    employee.setEmpId(empId);
                    employee.setEmpName(empName);
                    employee.setEmpAddress(empAddress);
                     dao.insertData(employee);
                    System.out.println("Data Inserted Successfully");

                    break;
                case 2:
                    //Display student
                    System.out.println("Enter Employee Id which want to see:");
                    int emp = Integer.parseInt(reader.readLine());
                    Employee employe = dao.getData(emp);
                    System.out.println(employe);
                    break;
                case 3:
                    //Display student
                    List<Employee> employee1 = dao.getAllEmployee();
                    for (Employee e : employee1
                    ) {
                        System.out.println(employee1);
                    }
                    break;
                case 4:
                    //Display student
                    System.out.println("Enter Employee Id which want to delete:");
                    int emp1 = Integer.parseInt(reader.readLine());
                    dao.getData(emp1);
                    System.out.println("Deleted SuccessFully");
                    break;
                case 5:
                    Employee employeeu = new Employee();
                    System.out.println("Enter Employee Id:");
                    int empId1 = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Employee Name:");
                    String empNam = reader.readLine();
                    System.out.println("Enter Employee Address:");
                    String empAddres = reader.readLine();
                    employeeu.setEmpId(empId1);
                    employeeu.setEmpName(empNam);
                    employeeu.setEmpAddress(empAddres);
                    dao.updateData(employeeu);
                    System.out.println("Data Updated Successfully");
                    break;
                case 6:
                    go = false;
                    break;
            }
            System.out.println("Thank You!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

    }
}
