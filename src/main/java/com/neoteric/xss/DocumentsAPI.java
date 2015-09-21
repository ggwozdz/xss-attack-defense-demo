package com.neoteric.xss;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by ggwozdz on 20.09.15.
 */
@RestController
@RequestMapping("documents")
public class DocumentsAPI {
    private static final Logger LOG = LoggerFactory.getLogger(DocumentsAPI.class);

    private final DataRepo<DocumentInfo> repo;

    public DocumentsAPI() {
        this.repo = new DataRepo<>();
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<DocumentInfo> getAll(){
        LOG.info("get all documents");
        return this.repo.findAll(data->true);
    }

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public DocumentInfo getByTitle(@RequestParam("title") String title){
        LOG.info("get document by title");

        if(!title.matches("^[A-Za-z ]*$")){
            throw new IllegalArgumentException("Bad title query: "+title);
        }

        Optional<DocumentInfo> documentInfo = this.repo.findOne(data -> data.getTitle().equalsIgnoreCase(title));
        if(documentInfo.isPresent()){
            return documentInfo.get();
        }else{
            throw NotFoundException.withQuery(title);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public DocumentInfo createDocument(@RequestBody DocumentInfo documentInfo){
        LOG.info("create document");

        if(!documentInfo.getTitle().matches("^[A-Za-z ]*$")){
            throw new IllegalArgumentException("Bad valuef or title: "+documentInfo.getTitle());
        }

        return this.repo.add(documentInfo);
    }




}
