/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * */

package leetcode2;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for(int i=0; i< num.length; i++){
			map.put(num[i], 1);
		}
		
		int max=0;
		for(int i=0; i< num.length; i++){
			int current=0;
			if(map.get(num[i])==1){
				map.put(num[i], 0);
				current++;
			}
			int index =num[i]-1;
			while(map.containsKey(index) && map.get(index) ==1){
				map.put(index, 0);
				index--;
				current++;
			}
			
			index =num[i]+1;
			while(map.containsKey(index) && map.get(index) ==1){
				map.put(index, 0);
				index++;
				current++;				
			}
			
			if(current>max)
				max=current;
			
		}
		
		return max;
	}

}
