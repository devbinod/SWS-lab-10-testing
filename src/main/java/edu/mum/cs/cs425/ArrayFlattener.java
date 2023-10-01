package edu.mum.cs.cs425;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3}, {4, 5}};
        for (Object n : new ArrayFlattener().flattenArray(nums)) {
            System.out.println(n.toString());
        }
    }


    Object[] flattenArray(int[][] nums) {
        if (nums == null)
            return null;
        int elementCount = 0;
        List<Integer> lstNums = new ArrayList<Integer>();

        for (int[] arr : nums) {
            for (int i : arr) {
                lstNums.add(i);
            }
        }

        return lstNums.toArray();
    }


}
