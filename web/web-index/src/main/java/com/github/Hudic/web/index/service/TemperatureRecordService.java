package com.github.Hudic.web.index.service;

import com.github.Hudic.web.index.domain.entity.TemperatureRecord;
import org.springframework.stereotype.Service;

@Service
public interface TemperatureRecordService {
    TemperatureRecord save(TemperatureRecord data);
}
