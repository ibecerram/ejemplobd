package com.ibecerram;

import java.sql.*;

public class SQL
{
    private Connection connection = null;

    public SQL(String database, String user, String password) throws SQLException
    {
        this.connection = DriverManager.getConnection(database, user, password);
    }
    public void insertPerson(String first_name, String last_name, String date) throws SQLException
    {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO person VALUES(DEFAULT, '" + first_name + "', " + "'" + last_name + "', '" + date + "');";

        statement.execute(sql);
        System.out.println("Row inserted");

    }

    public void viewPersons() throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
        while(resultSet.next())
        {
            System.out.println(resultSet.getString("id") + " | " + resultSet.getString("first_name"));
        }
    }

    public void deletePersons(int id) throws SQLException
    {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM person WHERE id = " + id;
        statement.execute(sql);
    }

    public void updatePerson(int id, String first_name, String last_name) throws SQLException
    {
        Statement statement = connection.createStatement();
        String sql = "UPDATE person SET first_name = '" + first_name + "', last_name = '" + last_name + "' WHERE id = " + id;
        statement.execute(sql);
    }

    public void deleteAllPersons() throws SQLException
    {
        Statement statement = connection.createStatement();

        String sql = "TRUNCATE TABLE person";
        statement.execute(sql);

    }

    public void closeConnection() throws SQLException
    {
        connection.close();
    }


}
