package dao;

import dao.service.StudentService;
import dao.service.StudentServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceFactory {

    public static StudentService getStudentService(){
        Connection connection=null;
        try {
            connection=DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new StudentServiceImpl(connection);
    }
}
