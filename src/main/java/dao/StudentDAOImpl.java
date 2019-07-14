package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author chen
 * @date 2019/7/11
 */
public class StudentDAOImpl implements StudentDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public StudentDAOImpl(Connection connection){
        this.connection=connection;
    }

    /**
     * 通过id获取学生信息
     *
     * @param id student ID
     * @return {@link Student}
     * @throws Exception
     */
    public Student findStudentById(int id) throws Exception {
        Student student=null;
        String sql="select * from student where id = ?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            String name=resultSet.getString(2);
            int age=resultSet.getInt(3);
            String sex=resultSet.getString(4);
            student=new Student(id,name,sex,age);
        }
        return student;
    }

    /**
     * 插入学生
     *
     * @param student {@link Student}
     * @return 是否成功
     * @throws Exception
     */
    public boolean insertStudent(Student student) throws Exception {
        return false;
    }

    /**
     * 通过id删除学生信息
     *
     * @param id student id
     * @return 是否成功
     * @throws Exception
     */
    public boolean deleteStudentById(int id) throws Exception {
        return false;
    }
}
