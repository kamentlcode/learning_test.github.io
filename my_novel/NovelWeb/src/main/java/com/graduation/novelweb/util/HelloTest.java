package com.graduation.novelweb.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class HelloTest {
    public static void main(String[] args) {

        String fileNamedirs="F:\\设计文稿\\小说资源\\斗破苍穹\\斗破.txt";
        try {
            // 编码格式
            String encoding = "UTF-8";
            // 文件路径
            File file = new File(fileNamedirs);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                // 输入流
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                Long count = (long) 0;
                boolean bflag=false;
                int n=0;
                String newStr=null;
                String titleName=null;
                String newChapterName = null;//新章节名称
                String substring=null;
                int indexOf=0;
                int indexOf1=0;
                int line=0;
                //小说内容类
                Content content = new Content();
                while ((lineTxt = bufferedReader.readLine()) != null) {

                    //小说名称
                    content.setName("斗破");
 
                    count++;
                    // 正则表达式
                    Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");

                    Matcher matcher = p.matcher(lineTxt);
                    Matcher matcher1 = p.matcher(lineTxt);

                    newStr=newStr+lineTxt;

                    while (matcher.find()) {
                        titleName = matcher.group();
                        //章节去空
                        newChapterName = titleName.trim();
                        //获取章节
                        System.out.println(newChapterName);
                        content.setChapter(newChapterName);
                        indexOf1=indexOf;
                        //System.out.println(indexOf);
                        indexOf = newStr.indexOf(newChapterName);
                        System.out.println("indexOf"+indexOf);
                       //System.out.println(newChapterName + ":" + "第" + count + "行"); // 得到返回的章
                        if(bflag) {
                            bflag=false;
                            break;
                        }
                        if(n==0) {
                            indexOf1 = newStr.indexOf(newChapterName);
                        }
                        n=1;
                        bflag=true;
                        //System.out.println(chapter);
                    }
                    while(matcher1.find()) {
                        if(indexOf!=indexOf1) {
                            //根据章节数量生成
                            content.setNumber(++line);
                            content.setId(line);
                            //设置第多少个开始的共多少字符
                            substring = newStr.substring(indexOf1, indexOf);
                            //System.out.println(substring);
                            content.setContent(substring);
                            //System.out.println(content.toString());+content.getChapter()
                            //System.out.println(content.getNumber()+"=="+indexOf+"=="+content.getContent());
                        }
 
                    }
                }
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }





}