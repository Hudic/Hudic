package com.github.Hudic.web.index.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.Hudic.web.index.domain.entity.PasswordRecord;
import com.github.Hudic.web.index.domain.repository.PasswordRecordDao;
import com.github.Hudic.web.index.service.PasswordRecordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PasswordRecordServiceImpl implements PasswordRecordService {
    @Autowired
    private PasswordRecordDao dao;

    @Override
    public PasswordRecord save(PasswordRecord data) {
        String id = data.getId();
        if (StringUtils.isNotBlank(id)) {
            PasswordRecord existData = dao.findOneById(id);
            if (existData != null) {
                BeanUtil.copyProperties(data, existData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                existData.setUpdateTime(new Date());
                return dao.save(existData);
            } else {
                data.setCreateTime(new Date());
                return dao.save(data);
            }
        } else {
            data.setCreateTime(new Date());
            return dao.save(data);
        }

    }
}
