package info.manager.service;

import info.manager.dao.StudentDao;
import info.manager.domain.Student;

public class StudentService {
    private   StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }
    public boolean isExists(String id) {
        Student[] stubs = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < stubs.length; i++) {
            Student student = stubs[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
       Student[] allStudent =studentDao.findAllStudent();
       boolean flag =false;
        for (int i = 0; i < allStudent.length; i++) {
                Student stu =allStudent[i];
                if (stu != null){
                    flag =true;
                    break;
                }
        }
        if (flag == true){
            return allStudent;
        }else {
            return null;
        }
               
    }
}
