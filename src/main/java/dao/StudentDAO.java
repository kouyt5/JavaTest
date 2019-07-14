package dao;

public interface StudentDAO {

    /**
     * 通过id获取学生信息
     * @param id student ID
     * @return {@link Student}
     * @throws Exception
     */
    public Student findStudentById(int id) throws Exception;

    /**
     * 插入学生
     * @param student {@link Student}
     * @return 是否成功
     * @throws Exception
     */
    public boolean insertStudent(Student student) throws Exception;

    /**
     * 通过id删除学生信息
     * @param id student id
     * @return 是否成功
     * @throws Exception
     */
    public boolean deleteStudentById(int id) throws Exception;
}
