package io.github.qxqrose.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: QXQ
 * @time: 2021/7/3 15:03
 * @desc: TODO
 */
public class ArraySort {

    public static void main(String[] args) {

        Integer[] array = new Integer[] {
                1,2,3,4,5
        };
        Arrays.sort(array, Comparator.reverseOrder());

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }

    }
}
