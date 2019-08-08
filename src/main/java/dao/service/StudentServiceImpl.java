package dao.service;

import dao.DAOFactory;
import dao.DBConnection;
import dao.Student;

import java.sql.Connection;


public class StudentServiceImpl implements StudentService {

    private Connection connection;

    public StudentServiceImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * @param student {@link Student}
     * @return 是否操作成功
     * @throws Exception
     */
    @Override
    public boolean insertStudent(Student student) throws Exception {
        boolean result = false;
        try {
            result = DAOFactory.getStudentDAO(connection).insertStudent(student);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    /**
     * @param id {@link Student}表中唯一id
     * @return {@link Student}
     * @throws Exception
     */
    @Override
    public Student findStudentById(int id) throws Exception {
        Student student=null;
        try {
           student= DAOFactory.getStudentDAO(connection).findStudentById(id);
        } catch (Exception e) {
            throw e;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return student;
    }

    /**
     * @param id {@link Student}表中唯一id
     * @return 是否成功
     * @throws Exception
     */
    @Override
    public boolean deleteStudentById(int id) throws Exception {
        boolean result=false;
        try {
            result=DAOFactory.getStudentDAO(connection).deleteStudentById(id);
        } catch (Exception e) {
            throw e;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
}
