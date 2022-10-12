package com.programmers.level1.probelm_폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.put(num, 1);
        }
        
        if(map.size() > nums.length / 2){
            answer = nums.length / 2;
        }
        else{
            answer = map.size();
        }

        return answer;
    }
}
