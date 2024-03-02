package medium;

import java.util.Arrays;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/19 10:24
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置 test = new 在排序数组中查找元素的第一个和最后一个位置();
        System.out.println(Arrays.toString(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(test.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(test.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(test.searchRange2(new int[]{}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int midRes = nums[mid];
            if(target == midRes){
                int l = mid;
                int r = mid;
                while(l>= 0 && nums[l] == target){
                    l--;
                }
                while(r<= nums.length-1 && nums[r] == target){
                    r++;
                }
                res[0] = l+1;
                res[1] = r-1;
                break;
            }else if(midRes < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int[] res = new int[]{-1,-1};
        while(left < right){
            int mid = left+(right-left)/2;
            int midRes = nums[mid];
            if(target == midRes){
                int l = mid;
                int r = mid;
                while(l>= 0 &&nums[l] == target) {
                    l++;
                }
                while(r< nums.length-1 && nums[r] == target) {
                    r--;
                }
                res[0]= l+1;
                res[1] = r -1;
                break;
            }else if(target > midRes){
                left++;
            }else{
                right--;
            }
        }
        return res;

    }
}
