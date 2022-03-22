package info.manager.dao;

import info.manager.domain.Student;

public class StudentDao {

    private static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            stus[index] = stu;
            return true;
        }
    }


    public Student[] findAllStudent() {
        return stus;
    }
}

