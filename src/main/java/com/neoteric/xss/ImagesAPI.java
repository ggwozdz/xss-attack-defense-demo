package com.neoteric.xss;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ggwozdz on 19.09.15.
 */
@RestController
@RequestMapping("images")
public class ImagesAPI {
    private final List<ImageInfo> images;

    public ImagesAPI() {
        this.images = new ArrayList<>();
        this.images.add(new ImageInfo(1, "http://neoteric.eu/wp-content/uploads/2015/08/neoteric-logotyp2.png", "Neoteric for Life"));
        this.images.add(new ImageInfo(2, "http://neoteric.eu/wp-content/uploads/2015/08/neoteric-logotyp2.png", "Neoteric for Life"));
        this.images.add(new ImageInfo(3, "http://neoteric.eu/wp-content/uploads/2015/08/neoteric-logotyp2.png", "Neoteric for Life"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ImageInfo> getAll(){
        return this.images;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<ImageInfo> getAll(@PathVariable("id") int id){
        return this.images.stream().filter(img -> img.getId() == id).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ImageInfo getAll(@RequestBody ImageInfo imageInfo){
        this.images.add(imageInfo);
        int id = this.images.size();
        imageInfo.setId(id);

        return imageInfo;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ImageInfo update(@PathVariable("id") int id, @RequestBody ImageInfo imageInfo){
        Optional<ImageInfo> stored = this.images.stream().filter(img -> img.getId() == id).findFirst();
        if(stored.isPresent()){
            stored.get().setImageDescr(imageInfo.getImageDescr());
            stored.get().setImageUrl(imageInfo.getImageUrl());
            return stored.get();
        }else {
            return null;
        }
    }
}
