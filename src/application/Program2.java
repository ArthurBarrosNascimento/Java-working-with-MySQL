package application;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        try {
            System.out.println("=== TEST 1: department insert ===");
            Department newDepartment = new Department(null, "Gastronomy");
            departmentDao.insert(newDepartment);
            System.out.println("Inserted! new id = " + newDepartment.getId());

            System.out.println("\n=== TEST 2: department update ===");
            newDepartment = departmentDao.findById(2);
            newDepartment.setName("Dev");
            departmentDao.updade(newDepartment);
            System.out.println("Update completed!");

            System.out.println("\n=== TEST 3: department findById ===");
            newDepartment = departmentDao.findById(2);
            System.out.println(newDepartment);

            System.out.println("\n=== TEST 4: department findAll ===");
            List<Department> list = departmentDao.findAll();
            for (Department obj: list) {
                System.out.println(obj);
            }

            System.out.println("\n=== TEST 5: department delete ===");
            System.out.print("Enter id for delete test: ");
            int id = sc.nextInt();
            departmentDao.deleteById(id);
            System.out.println("Delete completed!");

        } catch (DbException e) {
            System.out.println(e.getMessage());
        } finally {
            DB.closeConnection();
        }
        sc.close();
    }
}
