package com.msn.controllers;

import com.msn.services.IUpStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upstream")
public class UpStreamController {

    @Autowired
    private IUpStreamService upStreamService;

    @GetMapping("/")
    public String message() {
        return "From UpStreamController";
    }

    @GetMapping("/publish/{count}")
    public ResponseEntity<String> publish(@PathVariable(value = "count") Integer count) {
        upStreamService.publish(count);
        return new ResponseEntity<String>("Messages Successfully Published to UpStream Topic", HttpStatus.OK);
    }

}
