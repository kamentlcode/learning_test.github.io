package com.graduation.novelweb.util;

import com.graduation.novelweb.dto.Chapters;
import com.graduation.novelweb.dto.Novels;
import com.graduation.novelweb.mapper.ChaptersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tanlin
 * @date 2020/5/4
 */
@Component
public class ParseBookContentUtil {
//    public static void main(String[] args) {
//        Novels novel = new Novels();
//        novel.setnId(1588768096);
//        novel.setnName("奥术神座");
//        parse(novel);
//    }

    @Autowired
    private ChaptersMapper chaptersMapper;

    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void parse(Novels novel) {
        //String path = book.getBookDownPath();
        String fileNamedirs="F:\\设计文稿\\小说资源\\奥术神座\\奥术神座.txt";
        ArrayList<Chapters> list = new ArrayList<>();
//        if (!path.contains("G:/books/")) {
////            path = "G:/books" + path.substring(6);
////        }
        try {
            // 编码格式
            String encoding = "UTF-8";
            // 文件路径
            File file = new File(fileNamedirs);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                System.out.println("======================="+"查询到文件");
                // 输入流
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //Long count = (long) 0;
                boolean bflag=false;
                int n=0;
                String newStr=null;
                String titleName=null;
                String newChapterName = null;//新章节名称
                String beforeChapterName = null; // 记录上一章 章节名
                String substring=null;
                int indexOf=0;
                int indexOf1=0;
                String rn = "\r\n";
                String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";

                Chapters chapters = new Chapters();
                Date now = new Date();

                int line=0;
                //小说内容类
                //BookContent content;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    //content=new BookContent();
                    //小说名称
                    // content.setName(book.getBookDownName());
                    //count++;
                    // 正则表达式
                    Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");
                    Matcher matcher = p.matcher(lineTxt);
                    Matcher matcher1 = p.matcher(lineTxt);
                    newStr=newStr +lineTxt+rn;
                    while (matcher.find()) {
                        titleName = matcher.group();
                        //章节去空
                        newChapterName = titleName.trim();
                        //获取章节
                        //System.out.println(newChapterName);
                        chapters.setcName(beforeChapterName);
                        beforeChapterName = newChapterName;
                        indexOf1=indexOf;
                        //System.out.println(indexOf);
                        indexOf = newStr.indexOf(newChapterName);
                        // System.out.println(newChapterName + ":" + "第" + count + "行"); // 得到返回的章
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
                        // 若indexOf1 < indexOf 就说明图书有章节出错，此时跳过 到时在后台补加
                        //  if(indexOf!=indexOf1 ) {
                        if (indexOf1 < indexOf) {
                            //根据章节数量生成
                            if (line > 4000) {
                                //return list;
                            }
                            chapters.setcId(++line+novel.getnId());
                            //content.setBookId(line);
                            //System.out.println("--" + indexOf1 + "截取" + indexOf + "--");
                            substring = newStr.substring(indexOf1+chapters.getcName().length()+8, indexOf);
                            //System.out.println(substring);  +104
                            chapters.setcContent(nbsp+substring);
                            //list.add(content);
                            //bookContentManager.save(content);
                            //System.out.println("1  "+content.getNumber()+"2  "+content.getChapter()+"3   "+content.getContent());
//                            System.out.println(content.getContent().contains(content.getChapter()));
//                            System.out.println("6666"+content.getContent());
                            //对象赋值
                            chapters.setcWords(chapters.getcContent().length());
                            chapters.setnId(novel.getnId());
                            chapters.setCreateTime(now);
                            chapters.setUpdateTime(now);
                            //list.add(chapters);
                            chaptersMapper.updateByPrimaryKeyWithBLOBs(chapters);
                            System.out.println("1  "+chapters.getcId()+"     2  "+chapters.getcName()+"     3   1");

                        } else {
                            System.out.println("错误章节：" + newChapterName);
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
        //return list;
    }

}
