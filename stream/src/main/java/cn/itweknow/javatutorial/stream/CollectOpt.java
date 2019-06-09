/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package cn.itweknow.javatutorial.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ganchaoyang
 * @date 2019/6/915:07
 */
public class CollectOpt {

    public static void main(String[] args) {
        list2Map();
    }


    public static void list2Map() {
        List<Student> students = initData();
        Map<String, Double> collect = students.stream()
                .collect(Collectors.toMap(one -> one.getName(), one -> one.getScore()));
        System.out.println(collect);
    }

    public static List<Student> initData() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 40, Arrays.asList("语文", "英语")));
        students.add(new Student("张三", 80, Arrays.asList("语文", "数学")));
        students.add(new Student("王五", 50, Arrays.asList("物理", "英语")));
        students.add(new Student("赵六", 70, Arrays.asList("语文", "化学")));
        students.add(new Student("孙七", 90, Arrays.asList("生物", "英语")));
        students.add(new Student("周八", 30, Arrays.asList("语文", "地理")));
        return students;
    }

}
