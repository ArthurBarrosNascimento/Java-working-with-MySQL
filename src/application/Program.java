package application;

import db.DB;
import db.DbException;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");

        Seller seller = new Seller(31, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

        System.out.println(seller);
    }
}
