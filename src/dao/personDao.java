package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.*;

public class personDao {
    public static List<person> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBGet.getConnection();
            String sql = "select * from people";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<person> list = new ArrayList<>();
            person p;
            while(rs.next()) {
                p = new person();
                p.setName(rs.getString("name"));
                p.setPhone(rs.getString("phone"));
                p.setMail(rs.getString("mail"));
                list.add(p);
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBGet.closeResultSet(rs);
            DBGet.closePreparedStatement(ps);
            DBGet.closeConnection(conn);
        }
        return null;
    }

    //修改学生信息同步到数据库
    public static boolean insert(person p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBGet.getConnection();
            String sql = "insert into people values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setString(2,p.getPhone());
            ps.setString(3,p.getMail());
            int num = ps.executeUpdate();
            if(num > 0)
                return true;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBGet.closePreparedStatement(ps);
            DBGet.closeConnection(conn);
        }
        return false;
    }

    //修改学生信息同步到数据库
    public static boolean delete(person p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBGet.getConnection();
            String sql="delete from people where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            int num = ps.executeUpdate();
            if(num > 0)
                return true;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBGet.closePreparedStatement(ps);
            DBGet.closeConnection(conn);
        }
        return false;
    }
}