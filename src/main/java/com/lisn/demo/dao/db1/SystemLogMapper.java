package com.lisn.demo.dao.db1;

import com.lisn.demo.core.universal.Mapper;
import com.lisn.demo.model.SystemLog;

import java.util.List;

public interface SystemLogMapper extends Mapper<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);
}