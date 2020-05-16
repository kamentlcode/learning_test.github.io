package com.graduation.novelweb.util;

/**
 * @author tanlin
 * @date 2020/5/4
 */
public class BookContent {

    /**
     * @Fields bookId : 书id
     */
    private int bookId;

    /**
     * @Fields chapter : 章节名
     */
    private String chapter;

    /**
     * @Fields content : 内容
     */
    private String content;

    /**
     * @Fields number : 章节序号
     */
    private Integer number;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
