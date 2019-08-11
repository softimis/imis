package com.imis.project.test.service.impl;

import com.imis.frame.core.dao.BaseDao;
import com.imis.frame.core.service.impl.BaseServiceImpl;
import com.imis.project.test.dao.TestDao;
import com.imis.project.test.entity.TestEntity;
import com.imis.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends BaseServiceImpl<TestDao,TestEntity> implements TestService{

}
