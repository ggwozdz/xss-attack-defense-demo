package com.neoteric.xss;

/**
 * Created by ggwozdz on 19.09.15.
 */
public class TextEntry {
    private String title;
    private String content;

    public TextEntry() {
    }

    public TextEntry(String title, String content) {
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
        this.content = content;
    }
}
