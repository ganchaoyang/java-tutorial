package cn.itweknow.javatutorial.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ganchaoyang
 * @date 2019/6/910:32
 */
public class SimpleUse {

    public static void main(String[] args) {
        List<Student> students = initData();
        streamImpl(students);
        java7Impl(students);
    }

    public static void streamImpl(List<Student> students) {
        List<Student> filterStudent = students.stream()
                .filter(one -> one.getScore() < 60).collect(Collectors.toList());
        System.out.println(filterStudent);
    }

    public static void java7Impl(List<Student> students) {
        List<Student> filterStudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() < 60) {
                filterStudent.add(student);
            }
        }
        System.out.println(filterStudent);
    }

    public static List<Student> initData() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 60));
        students.add(new Student("李四", 80));
        students.add(new Student("王五", 50));
        students.add(new Student("赵六", 70));
        students.add(new Student("孙七", 90));
        students.add(new Student("周八", 30));
        return students;
    }

}


class Student {

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生分数
     */
    private double score;

    /**
     * 所学课程
     */
    List<String> course;

    public Student() {}

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, double score, List<String> course) {
        this.name = name;
        this.score = score;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
