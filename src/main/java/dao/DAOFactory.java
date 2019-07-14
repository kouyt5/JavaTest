package dao;

import java.sql.Connection;

public class DAOFactory {

    public static StudentDAO getStudentDAO(Connection connection){
        return new StudentDAOImpl(connection);
    }
}
