package com.javabean.jdbc.member.test;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javabean.jdbc.member.util.DbUtil;

/**
 * BdUtil Unit Test : Test Case
 * 
 * Test Case)
 * 1) DB Connection test
 * 2) DB Disconnect test
 * 
 * @author LimeParfait
 */

public class DbConnectionText 
{
    public static void main(String[] args) throws SQLException 
    {
        String msg = DbUtil.connect() != null ? "DB Connected" : "DB Connect failed";
        System.out.println("Connection State : " + msg);

        Connection con = DbUtil.connect(); 
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from member");

        String result = DbUtil.close(con, stmt, rs);
        System.out.println(result);
    }
}
