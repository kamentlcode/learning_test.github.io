package com.graduation.novelweb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	/** * @param args */
	public static void main(String[] args) { 
		String testString = "第一回 风雪惊变/r/n钱塘江浩浩江水，日日夜夜无穷无休的从临安牛家村边绕过，东流入海。  "
				+ "第二回 yeyo/r/n钱塘江浩浩江水，日日夜夜无穷无休的从临安牛家村边绕过，东流入海。";
		Pattern p =Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");
		Matcher matcher = p.matcher(testString); 
		//System.out.println("=========="+matcher.find());
		while (matcher.find()) { 

			for(int i = 0; i <= matcher.groupCount(); i++) {
				System.out.println("==========2");
				System.out.println("group"+ i + " : " + matcher.start(i) + " - " + matcher.end(i));
				System.out.println(matcher.group(i)); 
			} 
		} 
	}
}