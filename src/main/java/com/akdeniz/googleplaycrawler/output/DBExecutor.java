package com.akdeniz.googleplaycrawler.output;

import java.sql.*;

/**
 * Created by ryan on 10/26/14.
 */
public class DBExecutor {

    private String dbFile;
    private Connection conn;
    private Statement stmt;

    public DBExecutor(String dbFile)
    {
        this.dbFile = dbFile;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void CleanUp()
    {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet Query(String sql)
    {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean CreateTable(String tableName, String fields, boolean checkExists)
    {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            if (checkExists)
                sb.append("IF NOT EXISTS ");
            sb.append(tableName);
            sb.append("(");
            sb.append(fields);
            sb.append(");");
            String sql = sb.toString();
            stmt.executeUpdate(sql);
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getConn()
    {
        return conn;
    }

    public void Commit()
    {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement PrepareInsert(String statement)
    {
        try {
            return conn.prepareStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void InsertIntoTable(String statement)
    {
        try {
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
