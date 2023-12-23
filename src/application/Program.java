package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        Connection conn;

        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1, 8);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
