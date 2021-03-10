package com.javabean.jdbc.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB Connect / Disconnect Utility
 * <br></br>
 * usage) 
 * DB Connect : DbUtil.connect();
 * DB Disconnect : DbUtil.close(con, pstmt, rs);
 * <br></br>
 * @author LimeParfait
 * @version 1.0
 */

public class DbUtil 
{
    /** DB Connection Info */
    /** JDBC Driver */
    static final String driver = "oracle.jdbc.driver.OracleDriver";

    /** JDBC URL */
    static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

    /** DB Account (ID) */
    static final String userID = "java";

    /** DB Account (PW) */
    static final String userPW = "java";

    public static Connection connect()
    {
        Connection con = null;

        // JDBC Driver setup
        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, userID, userPW);
            } catch (SQLException e) {
                System.err.println("DB Connection Fail");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver loading Fail");
            e.printStackTrace();
        }

        return con;
    }
    
    /**
     * DB Disconnect
     * <br></br>
     * usage) DbUtil.close(con, pstmt, rs);
     * usage) DbUtil.close(con, pstmt, null);
     * <br></br>
     * @param con       DB Connection object
     * @param pstmt     SQL Statement object
     * @param rs        SQL ResultSet object
     */
    public static String close(Connection con, Statement pstmt, ResultSet rs)
    {
        StringBuilder sb = new StringBuilder();

        try {
            if (rs != null)
            {
                rs.close();
                //System.out.println("ResultSet is closed");
                sb.append("ResultSet is closed");
                sb.append("\n");
            }
            if (pstmt != null)
            {
                pstmt.close();
                //System.out.println("Statement is closed");
                sb.append("Statement is closed");
                sb.append("\n");
            }
            if (con != null)
            {
                con.close();
                //System.out.println("Connection is closed");
                sb.append("Connection is closed");
                sb.append("\n");
            }
        } catch (SQLException e) {
            System.err.println("DB resource return failed");
            e.printStackTrace();
            sb.append("DB resource return failed");
            sb.append("\n");
        }

        return sb.toString();
    }
}
