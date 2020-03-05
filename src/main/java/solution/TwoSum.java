package main.java.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author wyw
 * @date 2020/03/05
 */
public class TwoSum {

    /**
     * 遍历数组中元素
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] solution1(int nums[],int target){
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                   return  new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no such elements");
    }

    /**
     *使用哈希表
     * 将数组中元素遍历存在哈希表中
     * 在进行一次遍历，判断符合条件的另一个数是否存在于哈希表中，并且不是正在遍历的那个数
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int nums[],int target){
        Map<Integer,Integer> numMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for (int i = 0;i<nums.length;i++){
            int s = target-nums[i];
            if (numMap.containsKey(s) && numMap.get(s) != i){
                return new int[]{i,numMap.get(s)};
            }
        }
        throw new IllegalArgumentException("no such elements");
    }

    /**
     * 使用一次遍历
     * 依然是遍历数组中元素并且存放到哈希表中
     * 但是在遍历前先判断我们需要的那个数有没有在哈希表中存在，如果有，直接返回
     * @param nums
     * @param target
     * @return
     */
    public int[] solution3(int nums[],int target){
        Map<Integer,Integer> numMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            int s = target - nums[i];
            if (numMap.containsKey(s)){
                return new int[]{i,numMap.get(s)};
            }
            numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("no such elements");
    }
}
