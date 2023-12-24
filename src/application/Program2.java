package application;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        try {
            System.out.println("=== TEST 1: department insert ===");
            Department newDepartment = new Department(null, "Gastronomy");
            departmentDao.insert(newDepartment);
            System.out.println("Inserted! new id = " + newDepartment.getId());
            
        } catch (DbException e) {
            System.out.println(e.getMessage());
        } finally {
            DB.closeConnection();
        }
    }
}
