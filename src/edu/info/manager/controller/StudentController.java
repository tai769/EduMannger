package info.manager.controller;

import info.manager.domain.Student;
import info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
     private    StudentService studentService = new StudentService();


    public void start() {
        Scanner sc = new Scanner(System.in);
        studentLoop: while(true){
        System.out.println("请输入您的选择：1 添加学生 2删除学生 3修改学生 4查看学生 5 退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break ;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
    public void addStudent(){
        Scanner sc =new Scanner(System.in);
        String id;
        while (true){
            System.out.println("请输入学生id");
           id = sc.next();
            boolean flag =studentService.isExists(id);
            if (flag == true){
                System.out.println("学号存在请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生name");
        String name = sc.next();
        System.out.println("请输入学生age");
        String age = sc.next();
        System.out.println("请输入学生birthday");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        boolean result = studentService.addStudent(stu);
        if (result = true){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

    }
    public void findAllStudent(){
        Student[] stus =studentService.findAllStudent();
        if (stus == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        for (int i = 0; i < stus.length; i++) {
            Student stu =stus[i];
            if (stu !=null){
                System.out.println(stu.getId()+"\t"+stu.getName()+ " \t\t" +stu.getAge()+"\t"+stu.getBirthday());
            }
        }
    }
}
