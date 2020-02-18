package com.github.Hudic.web.index.domain.repository;

import com.github.Hudic.web.index.domain.entity.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRecordDao extends JpaRepository<TemperatureRecord, String>, JpaSpecificationExecutor<TemperatureRecord> {
    TemperatureRecord findOneById(String id);
}
