package com.neoteric.xss;

/**
 * Created by ggwozdz on 20.09.15.
 */
public class NotFoundException extends RuntimeException{
    public static NotFoundException withQuery(String query){
       return new NotFoundException(String.format("Document with title %s is not in the repo", query));
    }

    public NotFoundException(String message) {
        super(message);
    }
}
