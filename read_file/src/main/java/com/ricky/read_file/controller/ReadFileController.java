package com.ricky.read_file.controller;

import com.ricky.read_file.model.PersonDataResponse;
import com.ricky.read_file.service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController("readFileController")
public class ReadFileController {

    @Autowired
    ReadFileService readFileService;

    @RequestMapping(value = "/read_file", method = RequestMethod.GET, produces = "application/json")
    public PersonDataResponse generateResponse() throws FileNotFoundException {
        return readFileService.buildResponse();
    }
}
