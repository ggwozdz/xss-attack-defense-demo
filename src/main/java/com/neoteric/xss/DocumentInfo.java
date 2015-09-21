package com.neoteric.xss;

/**
 * Created by ggwozdz on 20.09.15.
 */
public class DocumentInfo {
    private String title;
    private String content;

    public DocumentInfo() {
    }

    public DocumentInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content
                //.replaceAll("\"", "&quot;")
                //.replaceAll("\\(", "&lpar;")
                //.replaceAll("\\)", "&rpar;")
                ;
    }
}
