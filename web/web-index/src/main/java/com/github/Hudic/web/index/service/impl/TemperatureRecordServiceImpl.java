package com.github.Hudic.web.index.service.impl;

import com.github.Hudic.web.index.domain.entity.TemperatureRecord;
import com.github.Hudic.web.index.domain.repository.TemperatureRecordDao;
import com.github.Hudic.web.index.service.TemperatureRecordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TemperatureRecordServiceImpl implements TemperatureRecordService {
    @Autowired
    private TemperatureRecordDao dao;

    @Override
    public TemperatureRecord save(TemperatureRecord data) {
        String id = data.getId();
        if (StringUtils.isBlank(id)) {
            data.setCreateTime(new Date());
            return dao.save(data);
        } else {
            TemperatureRecord existData = dao.findOneById(id);
            if (existData != null) {
                existData.setName(data.getName());
                existData.setTemperature(data.getTemperature());
                existData.setUpdateTime(new Date());
                return dao.save(existData);
            } else {
                data.setCreateTime(new Date());
                return dao.save(data);
            }
        }
    }

}
