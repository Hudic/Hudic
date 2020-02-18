package com.github.Hudic.web.index.domain.repository;

import com.github.Hudic.web.index.domain.entity.PasswordRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRecordDao extends JpaRepository<PasswordRecord, String>, JpaSpecificationExecutor<PasswordRecord> {
    PasswordRecord findOneById(String id);
}
