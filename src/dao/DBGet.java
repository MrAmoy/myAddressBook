package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBGet {
    static Connection getConnection() {
        Connection conn = null;
        try {
			/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test","sa","123456");*/
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "root", "123456");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    static void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    static void closePreparedStatement(PreparedStatement ps) {
        try {
            if(ps != null) {
                ps.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
