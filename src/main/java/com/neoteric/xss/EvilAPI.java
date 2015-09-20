package com.neoteric.xss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

/**
 * Created by ggwozdz on 20.09.15.
 */
@RestController
@RequestMapping("evil")
public class EvilAPI {

    private static final Logger LOG = LoggerFactory.getLogger(EvilAPI.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getString(@RequestParam("data") String userData){
        LOG.info("extractedData: {}", userData);
        return userData;
    }
}
