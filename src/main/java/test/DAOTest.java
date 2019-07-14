package test;

import dao.DAOFactory;
import dao.DBConnection;
import dao.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOTest {
    public static void main(String[] args){
        Connection connection=null;
        try {
            connection= DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(connection==null){
            System.out.println("conn is null");
            return;
        }

        Student student=new Student();
        try {
            student=DAOFactory.getStudentDAO(connection).findStudentById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(student.getName());

    }
}
