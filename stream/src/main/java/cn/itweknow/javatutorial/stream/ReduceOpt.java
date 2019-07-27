package cn.itweknow.javatutorial.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author ganchaoyang
 * @date 2019/6/913:45
 */
public class ReduceOpt {

    public static void main(String[] args) {
        reduceFirstSign();
        reduceSecondSign();
        reduceThirdSign();
        answer();
        answerSecondImpl();
    }


    public static void reduceFirstSign() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> count = list.stream().reduce((a, b) -> (a + b));
        System.out.println(count.get());
    }

    public static void reduceSecondSign() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Integer count = list.stream().reduce(2, (a, b) -> (a * b));
        System.out.println(count);
    }

    public static void reduceThirdSign() {
        List<Integer> list = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        long count = list.stream().reduce(0L, (a, b) -> (a + b), (a,b) -> 0L);
        System.out.println(count);
    }

    public static void answer() {
        List<Student> students = initData();
        Double result = students.stream()
                .filter(one -> one.getScore() >= 60).map(o -> o.getScore())
                .reduce(0d, (a,b) -> (a + b));
        System.out.println(result);
    }

    public static void answerSecondImpl() {
        List<Student> students = initData();
        Double result = students.stream()
                .filter(one -> one.getScore() >= 60).mapToDouble(o -> o.getScore()).sum();
        System.out.println(result);
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
