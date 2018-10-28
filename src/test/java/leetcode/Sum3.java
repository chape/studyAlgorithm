package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by ChaoChao on 10/07/2018.
 */
public class Sum3 {

    /**
     * 15. 3Sum
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     Note: The solution set must not contain duplicate triplets.
     For example, given array S = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     time : O(n^2);
     space : O(n);
     */

    @Test
    public void testThreeSum() {
        int[] nums = {-1, -1, -1, 0, 2,2};
        List<List<Integer>> lists = threeSum(nums);
        for (List ele : lists) {
            System.out.println(ele);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while (low < high) {
                if(nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while (low < high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high-1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if(nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int two = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int three = nums[k];
                    if (one + two + three == 0) {
                        List<Integer> sumEles = new ArrayList<>();
                        sumEles.add(one);
                        sumEles.add(two);
                        sumEles.add(three);
                        result.add(sumEles);
                        continue;
                    }
                }
            }
        }
        if (result.size() == 0) {
            return result;
        }
        Set<Integer> removeIndex = new HashSet<>();
        for (int i = 0; i < result.size() - 1; i++) {
            List<Integer> outer = result.get(i);
            List<Integer> sortOuter = sortList(outer);
            INNER:
            for (int j = i + 1; j < result.size(); j++) {
                List<Integer> inner = result.get(j);
                List<Integer> sortInner = sortList(inner);
                for (int k = 0; k < outer.size(); k++) {
                    if (sortInner.get(k) == sortOuter.get(k)) {
                        if (k == (outer.size() - 1)) {
                            removeIndex.add(j);
                        }
                    } else {
                        continue INNER;
                    }
                }
            }
        }
        List<List<Integer>> result1 = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (removeIndex.contains(i)) {
                continue;
            }
            result1.add(result.get(i));
        }
        return result1;
    }

    private List<Integer> sortList(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
