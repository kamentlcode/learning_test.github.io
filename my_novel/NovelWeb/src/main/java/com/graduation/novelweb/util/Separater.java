package com.graduation.novelweb.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Separater {
	/**
	 * 生成小说文件夹
	 *
	 * @param novel
	 * @return 成功生成返回文件夹名，已存在返回null
	 */
	private static String genarateFolder(File novel) {
		if (!novel.isFile() || !novel.getAbsolutePath().endsWith(".txt")) {
			return null;
		}
		String novelName = novel.getAbsolutePath();
		String folderName = novelName.substring(0, novelName.indexOf(".txt"));
		File folder = new File(folderName);
		if (!folder.exists()) {
			folder.mkdirs();
			return folderName;
		}
		return null;
	}

//输出html文件


	private static void generateChapterHtmlFile(int currentPageIndex, String content, List<String> chapterList, String folderName) throws Exception {
String pageContent = "<html><head>"
+"<meta http-equiv='content-type' content='text/html;charset=utf-8'>"
+"<title>" + chapterList.get(currentPageIndex) + "</title>"
+"<script type=\"text/javascript\">"
+"window.onload = function(){"
+"//去掉默认的contextmenu事件，否则会和右键事件同时出现。\r\n"
+"document.oncontextmenu = function(e){"
+"e.preventDefault();"
+"};"
+" document.getElementById(\"body\").onmousedown = function(e){"
+" if(e.button ==2){"

		+"window.open('" + chapterList.get(currentPageIndex == chapterList.size() - 1 ? chapterList.size() - 1 : currentPageIndex + 1) + ".html','_self')"
+"}else if(e.button ==0){"

		+"window.open('" + chapterList.get(currentPageIndex == 0 ? 0 : currentPageIndex - 1) + ".html','_self')"
+"}else if(e.button ==1){"
+"window.open('章节目录.html','_self');}}}"
+"</script>"
+"</head><body bgcolor='#e6f3ff' id='body'>"
+"<h1 align='center'>" + chapterList.get(currentPageIndex) + "</h1>"

		+"<div style='line-height:40px;font-size:24px;width: 50%;margin :auto'>" + content + "</div>"
+"</br>"
+"<table align='center'>"
+"<tr>"

		+"<td><a href='" + chapterList.get(currentPageIndex == 0 ? 0 : currentPageIndex - 1) + ".html'>上一页</a></td>"
+"<td><a href='contents.html'>目录</a></td>"

		+"<td><a href='" + chapterList.get(currentPageIndex == chapterList.size() - 1 ? chapterList.size() - 1 : currentPageIndex + 1) + ".html'>下一页</a></td>"
+"</tr>"
+"</table>"
+"</body></html>";
String filePath = folderName + "\\" + chapterList.get(currentPageIndex) + ".html";
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
out.print(pageContent);
out.flush();
out.close();
}
/**
      * 获取章节列表
      * @param novel
      * @throws Exception
      */


	private static List<String> getChapterList(File novel) throws Exception {
List<String> chapterList = new ArrayList<String>();
FileInputStream fileInputStream = new FileInputStream(novel);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, getCharsetOfNovel(novel));
		BufferedReader novelbr = new BufferedReader(inputStreamReader);
		int currentIndex = 1;
		String line = novelbr.readLine();
		while (line != null) {
			if (line.indexOf("第") == 0 && line.indexOf("节") != -1) {
				chapterList.add("第" + currentIndex + "章" + line.substring(line.indexOf("节") + 1));
				currentIndex++;
			} else if (line.indexOf("第") == 0 && line.indexOf("章") != -1) {
				chapterList.add("第" + currentIndex + "章" + line.substring(line.indexOf("章") + 1));
				currentIndex++;
			}
			line = novelbr.readLine();
		}
		novelbr.close();
		fileInputStream.close();
		return chapterList;
}


	private static void generateChapterMenuHtmlFile(String folderName, List<String> chapterList) throws Exception {
String menuPath = folderName + "\\章节目录.html";
StringBuilder pageContent = new StringBuilder();
pageContent.append("<html><head>"
				+ "<meta http-equiv='content-type' content='text/html;charset=utf-8'>"
+"<title>" + folderName.substring(folderName.lastIndexOf("\\") + 1) + "章节目录</title>"
+"<head>"
+"<body bgcolor='#e6f3ff' id='body'>"
+"<h1 align='center'>章节目录</h1><br>"
+"<table style='margin :auto;'  cellpadding='10px' cellspacing='0' align='center' border='1'>");
for (int i = 0; i < chapterList.size(); i++) {
if (i == 0) {
pageContent.append("<tr>");
} else if (i % 5 == 0) {
pageContent.append("<td><a href='" + chapterList.get(i) + ".html'>" + chapterList.get(i) + "</a></td>");
pageContent.append("</tr>");
}
			pageContent.append("<td><a href='" + chapterList.get(i) + ".html'>" + chapterList.get(i) + "</a></td>");
		}
pageContent.append("</table></body></html>");
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(menuPath)));
out.print(pageContent.toString());
out.flush();
out.close();
}
 /**
      * 判断TXT文件编码方式
      * @param fileName
      * @return
      * @throws IOException
      */


	private static String getCharsetOfNovel(File novel) throws IOException {
BufferedInputStream bin = new BufferedInputStream(new FileInputStream(novel));
byte[] head = new byte[3];
bin.read(head, 0, head.length);
String encoding = "gb2312";
if (head[0] == -1 && head[1] == -2)
	encoding = "UTF-16";
if (head[0] == -2 && head[1] == -1)
		encoding = "Unicode";
if (head[0] == -17 && head[1] == -69 && head[2] == -65)
encoding = "UTF-8";
return encoding;}


	public static void generate(File novel) throws Exception {
String folderName = genarateFolder(novel);
if (folderName == null) {
return;
}
List<String> chapterList = getChapterList(novel);
generateChapterMenuHtmlFile(folderName, chapterList);
FileInputStream fileInputStream = new FileInputStream(novel);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, getCharsetOfNovel(novel));
		BufferedReader novelbr = new BufferedReader(inputStreamReader);
		int currentPageIndex = -1;
		StringBuilder content = new StringBuilder();
		String line = novelbr.readLine();
		while (line != null) {
			if (line.indexOf("第") == 0 && (line.indexOf("节") != -1 || line.indexOf("章") != -1)) {
				if (currentPageIndex > -1) {
					generateChapterHtmlFile(currentPageIndex, content.toString(), chapterList, folderName);
					content.delete(0, content.length());
				}
				currentPageIndex++;
			} else if (currentPageIndex > -1) {
				content.append(line + "<br><br>");
			}
			line = novelbr.readLine();
		}
		novelbr.close();
		fileInputStream.close();
}

	public static void main(String[] args) throws Exception {
		//F:\\设计文稿\\小说资源\\斗破苍穹\\斗破.txt
		File folder = new File("F:\\设计文稿\\小说资源\\斗破苍穹");
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			Separater.generate(files[i]);
		}
	}

}
