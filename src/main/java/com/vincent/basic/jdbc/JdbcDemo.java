package com.vincent.basic.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by renwu on 2017/7/20.
 */
public class JdbcDemo {

    private static final String USERNAME = "root";
    private static final String MM = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,MM);
            preparedStatement = connection.prepareStatement("select * from student where age = 44");
            resultSet = preparedStatement.executeQuery();
            if(resultSet != null){
                while (resultSet.next()){
                    Integer id = (Integer) resultSet.getObject("id");
                    String name = (String) resultSet.getObject("name");
                    String school = (String) resultSet.getObject("school");
                    Integer age = (Integer) resultSet.getObject("age");
                    System.out.println(id + name + school + age);
                }
            }
            Thread.sleep(10000);
            preparedStatement = connection.prepareStatement("select * from student /*where age = 44*/");
            resultSet = preparedStatement.executeQuery();
            if(resultSet != null){
                while (resultSet.next()){
                    Integer id = (Integer) resultSet.getObject("id");
                    String name = (String) resultSet.getObject("name");
                    String school = (String) resultSet.getObject("school");
                    Integer age = (Integer) resultSet.getObject("age");
                    System.out.println(id + name + school + age);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
