package test;

import dao.DAOFactory;
import dao.DBConnection;
import dao.ServiceFactory;
import dao.Student;
import dao.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class DAOTest {

    public static void main(String[] args) {
        DAOTest.dbMaxConnectionTest();
        DAOTest daoTest=new DAOTest();
    }

    public void insert() {
        Student student1 = new Student("陈", "男", 23);
        boolean result = false;
        try {
            result = ServiceFactory.getStudentService().insertStudent(student1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert " + result);
    }

    public void delete() {
        boolean result = false;
        try {
            result = ServiceFactory.getStudentService().deleteStudentById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("delete " + result);
    }

    public static void dbMaxConnectionTest() {
        ThreadPoolExecutor executor = ThreadTest.getInstance().getThreadPoolExexutor();
        Logger logger = LoggerFactory.getLogger(DAOTest.class);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Connection connection=DBConnection.getConnection();
                    logger.error(Thread.currentThread().getName());
                    if (connection==null){
                        logger.error("null");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            executor.execute(runnable);
        }
        executor.shutdown();
    }
    
}
