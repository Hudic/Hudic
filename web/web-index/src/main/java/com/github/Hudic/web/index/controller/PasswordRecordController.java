package com.github.Hudic.web.index.controller;

import com.github.Hudic.web.index.domain.entity.PasswordRecord;
import com.github.Hudic.web.index.service.PasswordRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passwordRecord")
public class PasswordRecordController {
    @Autowired
    private PasswordRecordService service;

    @RequestMapping("/save")
    public PasswordRecord save(PasswordRecord data) {
        return service.save(data);
    }
}
