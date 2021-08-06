package com.ibecerram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String database = "jdbc:mysql://localhost:3306/pruebasdb";
        String user = "user";
        String password = "user";

        try
        {
            SQL sql = new SQL(database, user, password);
            sql.insertPerson("Isaac", "Becerra", "2001-01-01");
            sql.insertPerson("Maria", "Jose", "2001-01-02");
            sql.insertPerson("Person 3", "No last_name", "2001-01-03");

            sql.viewPersons();
            System.out.println("\n---------------------");

            sql.deletePersons(1);
            sql.updatePerson(3, "Pedro", "Rodriguez");

            sql.viewPersons();
            sql.deleteAllPersons();
            sql.closeConnection();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
