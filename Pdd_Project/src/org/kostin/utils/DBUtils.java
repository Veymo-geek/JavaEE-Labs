package org.kostin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kostin.beans.Accounts;
import org.kostin.beans.Pdd;
 
public class DBUtils {
 
    public static Accounts findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password from Accounts a " //
                + " where a.User_Name = ? and a.Password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            Accounts user = new Accounts();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static Accounts findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password from Accounts a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            Accounts user = new Accounts();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static List<Pdd> queryPdd(Connection conn) throws SQLException {
        String sql = "Select a.Offence_id a.Model, a.Driver_name, a.Offence_type, a.Fine from Pdd a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Pdd> list = new ArrayList<Pdd>();
        while (rs.next()) {
        	String offence_id = rs.getString("Offence_id");
            String model = rs.getString("Model");
            String driver_name = rs.getString("Driver_name");
            String offence_type = rs.getString("Offence_type");
            float fine = rs.getFloat("Fine");
            Pdd pdd = new Pdd();
            pdd.setOffence_id(offence_id);
            pdd.setModel(model);
            pdd.setDriver_name(driver_name);
            pdd.setOffence_type(offence_type);
            pdd.setFine(fine);
            list.add(pdd);
        }
        return list;
    }
 
    public static Pdd findPdd(Connection conn, String offence_id) throws SQLException {
        String sql = "Select a.Offence_id a.Model, a.Driver_name, a.Offence_type, a.Fine from Pdd a where a.Offence_id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, offence_id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String model = rs.getString("Model");
            String driver_name = rs.getString("Driver_name");
            String offence_type = rs.getString("Offence_type");
            float fine = rs.getFloat("Fine");
            Pdd pdd = new Pdd(offence_id, model, driver_name, offence_type, fine);
            return pdd;
        }
        return null;
    }
 
    public static void updatePdd(Connection conn, Pdd pdd) throws SQLException {
        String sql = "Update Pdd set Model=?, Driver_name=?, Offence_type=?, Fine=? where Offence_id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, pdd.getModel());
        pstm.setString(2, pdd.getDriver_name());
        pstm.setString(3, pdd.getOffence_type());
        pstm.setFloat(4, pdd.getFine());
        pstm.executeUpdate();
    }
 
    public static void insertPdd(Connection conn, Pdd pdd) throws SQLException {
        String sql = "Insert into Pdd(Offence_id, Model, Driver_name, Offence_type, Fine) values (?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, pdd.getOffence_id());
        pstm.setString(2, pdd.getModel());
        pstm.setString(3, pdd.getDriver_name());
        pstm.setString(4, pdd.getOffence_type());
        pstm.setFloat(5, pdd.getFine());
 
        pstm.executeUpdate();
    }
 
    public static void deletePdd(Connection conn, String offence_id) throws SQLException {
        String sql = "Delete From Pdd where Offence_id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, offence_id);
 
        pstm.executeUpdate();
    }
 
}
