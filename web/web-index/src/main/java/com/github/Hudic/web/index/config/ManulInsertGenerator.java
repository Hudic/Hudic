package com.github.Hudic.web.index.config;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.UUID;

/**
 * 自定义生成id规则
 * 如有传入id，且数据库中不存在该id，则以该id存入数据库中
 * 未传入id，则自动生成，采用的是随机UUID，重复几率非常小，也可加上时间戳确保随机出来的uuid不重复
 */
@Configuration
public class ManulInsertGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) throws HibernateException {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);
        if (id == null) {
//            Serializable generate = super.generate(s, obj);
            id = UUID.randomUUID().toString();
        }
        return id;
    }
}
