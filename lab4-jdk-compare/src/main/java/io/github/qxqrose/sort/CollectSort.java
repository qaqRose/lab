package io.github.qxqrose.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: QXQ
 * @time: 2021/7/3 15:02
 * @desc: TODO
 */
public class CollectSort {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(list);
    }
}
