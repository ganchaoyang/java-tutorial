package cn.itweknow.javatutorial.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建流
 * @author ganchaoyang
 * @date 2019/6/910:05
 */
public class CreateStream {

    public static void main(String[] args) {

        List<String> createStream = new ArrayList<String>();
        // 顺序流
        Stream<String> stream = createStream.stream();
        // 并行流
        Stream<String> parallelStream = createStream.parallelStream();
        // of()方法创建
        Stream<String> stringStream = Stream.of(
                createStream.toArray(new String[createStream.size()]));
    }

}
