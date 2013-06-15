package com.student.util;

public class MathUtil {

	/**
	 * 检查该字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
}
