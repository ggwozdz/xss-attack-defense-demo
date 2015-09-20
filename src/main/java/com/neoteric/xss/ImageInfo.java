package com.neoteric.xss;

/**
 * Created by ggwozdz on 19.09.15.
 */
public class ImageInfo {
    private int id;
    private String imageUrl;
    private String imageDescr;

    public ImageInfo() {
    }

    public ImageInfo(int id, String imageUrl, String imageDescr) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageDescr = imageDescr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDescr() {
        return imageDescr;
    }

    public void setImageDescr(String imageDescr) {
        this.imageDescr = imageDescr;
    }
}
