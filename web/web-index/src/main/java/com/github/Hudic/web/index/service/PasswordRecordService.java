package com.github.Hudic.web.index.service;

import com.github.Hudic.web.index.domain.entity.PasswordRecord;
import org.springframework.stereotype.Service;

@Service
public interface PasswordRecordService {
    public PasswordRecord save(PasswordRecord data);

}
