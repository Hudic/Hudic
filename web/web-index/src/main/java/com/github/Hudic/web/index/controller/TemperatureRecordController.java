package com.github.Hudic.web.index.controller;

import com.github.Hudic.web.index.domain.entity.TemperatureRecord;
import com.github.Hudic.web.index.service.TemperatureRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureRecordController {
    @Qualifier("temperatureRecordServiceImpl")
    @Autowired
    private TemperatureRecordService service;

    @PostMapping("/save")
    public TemperatureRecord save(TemperatureRecord data) {
        return service.save(data);
    }
}
