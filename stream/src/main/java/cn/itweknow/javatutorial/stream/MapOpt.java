package cn.itweknow.javatutorial.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ganchaoyang
 * @date 2019/6/914:28
 */
public class MapOpt {

    public static void main(String[] args) {
        useMap();
        useMapToDouble();
        useFlatMap();
    }

    public static void useMap() {
        List<Student> students = initData();
        double scoreCount = students.stream()
                .map(Student::getScore)
                .reduce(0.0, (a,b) -> (a + b));
        System.out.println(scoreCount);
    }


    public static void useMapToDouble() {
        List<Student> students = initData();
        double scoreCount = students.stream()
                .mapToDouble(Student::getScore)
                .sum();
        System.out.println(scoreCount);
    }


    public static void useFlatMap() {
        List<Student> students = initData();
        List<String> course = students.stream().flatMap(one -> one.getCourse().stream()).distinct()
                .collect(Collectors.toList());
        System.out.println(course);
    }

    public static List<Student> initData() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 20, Arrays.asList("语文", "英语")));
        students.add(new Student("李四", 80, Arrays.asList("语文", "数学")));
        students.add(new Student("王五", 50, Arrays.asList("物理", "英语")));
        students.add(new Student("赵六", 70, Arrays.asList("语文", "化学")));
        students.add(new Student("孙七", 90, Arrays.asList("生物", "英语")));
        students.add(new Student("周八", 30, Arrays.asList("语文", "地理")));
        return students;
    }


}
