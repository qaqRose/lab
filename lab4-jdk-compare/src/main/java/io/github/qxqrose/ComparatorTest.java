package io.github.qxqrose;

/**
 * @author: QXQ
 * @time: 2021/7/3 14:38
 * @desc: TODO
 */
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * 2021/6/30
 */
public class ComparatorTest {


    @ToString
    static public class Student implements Comparator<Student>, Comparable<Student> {
        Integer age;
        String name;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int compare(Student o1, Student o2) {
//按 age 升序排序
            return o1.age.compareTo(o2.age);
//按 age 降序排序
// return o2.age.compareTo(o1.age);
        }

        @Override
        public int compareTo(Student o) {
// return o.age.compareTo(this.age);
//按 age 升序排序
            return this.age.compareTo(o.age);
//按 age 降序排序
// return o.age.compareTo(this.age);

        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("qiu", 12);
        Student s2 = new Student("xiao", 11);
        Student s3 = new Student("ming", 14);
        Student s4 = new Student("xie", 10);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

// Collections.sort(list);
        Collections.sort(list, s1);
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
