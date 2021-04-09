package com.study.util.hashids;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caesar {
	public static void main(String[] args) {
		String str = "1111111111112333333333331241241255555555555555123";
		int key = 2;
		String text = encript(key, str);
		System.out.println(text);
		System.out.println(encript(-key, text));
	}

	public static String encript(int key, String text) {
		StringBuilder es = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			
			char c = text.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c += key % 26;
				if (c < 'a')
					c += 26;
				if (c > 'z')
					c -= 26;
			} else if (c >= 'A' && c <= 'Z') {
				c += key % 26;
				if (c < 'A')
					c += 26;
				if (c > 'Z')
					c -= 26;
			}else if(IsNumber(c) && c > 47 && c < 58){
				c += key % 10;
				if(c < 48)
					c += 10;
				if(c > 57)
					c -= 10;
			}
			es.append(c);
		}
		return es.toString();
	}
	
	private static boolean IsNumber(char c){
		boolean flag = false;
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher isNum = pattern.matcher(String.valueOf(c));
		if(isNum.matches()){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
}
