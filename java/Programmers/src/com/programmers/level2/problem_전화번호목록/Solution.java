package com.programmers.level2.problem_전화번호목록;

import java.util.*;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			String pre = phone_book[i];
			String post = phone_book[i + 1];
			if (pre.length() > post.length()) {
				continue;
			}

			if (pre.equals(post.substring(0, pre.length()))) {
				answer = false;
				break;
			}
		}

		return answer;
	}
}