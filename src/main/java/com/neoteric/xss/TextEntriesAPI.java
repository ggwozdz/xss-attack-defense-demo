package com.neoteric.xss;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggwozdz on 19.09.15.
 */
@RestController
@RequestMapping("textEntries")
public class TextEntriesAPI {

    private final List<TextEntry> textEntries;

    public TextEntriesAPI() {
        this.textEntries = new ArrayList<>();
        this.textEntries.add(new TextEntry("Title 1", "<b onmouseover=alert('Wufff!')>click me!</b>"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TextEntry> getAll(){
        return this.textEntries;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<TextEntry> create(@RequestBody TextEntry textEntry){
        this.textEntries.add(textEntry);
        return this.textEntries;
    }


}
