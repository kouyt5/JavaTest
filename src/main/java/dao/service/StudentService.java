package dao.service;

import dao.Student;

import java.sql.SQLException;

public interface StudentService {

    /**
     *
     * @param student {@link Student}
     * @return 是否操作成功
     * @throws Exception
     */
    public boolean insertStudent(Student student) throws Exception;

    /**
     *
     * @param id {@link Student}表中唯一id
     * @return {@link Student}
     * @throws Exception
     */
    public Student findStudentById(int id) throws Exception;

    /**
     *
     * @param id {@link Student}表中唯一id
     * @return 是否成功
     * @throws Exception
     */
    public boolean deleteStudentById(int id) throws Exception;

}
