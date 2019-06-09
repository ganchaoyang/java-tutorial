package cn.itweknow.javatutorial.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ganchaoyang
 * @date 2019/6/915:52
 */
public class Parallel {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,2,5);
        Integer result = list.stream().parallel().reduce(2, (a, b) -> (a + b), (a, b) -> (a + b));
        System.out.println(result);
    }



}
