package com.neoteric.xss;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by ggwozdz on 20.09.15.
 */
@RestController
@RequestMapping("documents")
public class DocumentsAPI {

    private final DataRepo<DocumentInfo> repo;

    public DocumentsAPI() {
        this.repo = new DataRepo<>();
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<DocumentInfo> getAll(){
        return this.repo.findAll(data->true);
    }

    @RequestMapping(value = "{title}", method = RequestMethod.GET)
    public DocumentInfo getByTitle(@PathVariable("title") String title){
        Optional<DocumentInfo> documentInfo = this.repo.findOne(data -> data.getTitle().equalsIgnoreCase(title));
        if(documentInfo.isPresent()){
            return documentInfo.get();
        }else{
            throw NotFoundException.withQuery(title);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public DocumentInfo createDocument(@RequestBody DocumentInfo documentInfo){
        return this.repo.add(documentInfo);
    }




}
