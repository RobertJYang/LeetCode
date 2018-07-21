package HashTable;

import java.awt.geom.AffineTransform;
import java.util.*;

import javax.print.attribute.standard.NumberUpSupported;

public class Q18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int length = nums.length;
		for(int i=0;i<length - 3;i++) {
			if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] >target) //nums[i]太大
				break;
			if(nums[i] + nums[length -1] + nums[length - 2] + nums[length - 3]<target)//nums[i]太小
				continue;
			if(i>0&&nums[i] == nums[i-1])
				continue;
			for(int j = i+1;j<nums.length - 2; j++) {
				if(nums[i] + nums[j] + nums[j+1] + nums[j+2] >target) //nums[i]太大
					break;
				if(nums[i] + nums[length -1] + nums[length - 2] + nums[j]<target)//nums[j]太小
					continue;
				if(j>i+1&&nums[j] == nums[j-1])
					continue;
				int low = j+1,high = length - 1;
				int target1 = target - nums[i]-nums[j]; 
				while(low < high) {
					if(nums[low]+nums[high] == target1){
						list.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
						low++;
						high--;
						while(low<high&&nums[low] == nums[low-1])
							low++;
						while(high>low&&nums[high]== nums[high+1])
							high -- ;
					}
					else if(nums[low]+nums[high] > target1)
						high -- ;
					else if(nums[low]+nums[high] < target1)
						low ++;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> list = new Q18().fourSum(nums, 0);
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<4;j++) {
				System.out.print(list.get(i).get(j)+",");
			}
			System.out.println(" ");
		}
	}
}
