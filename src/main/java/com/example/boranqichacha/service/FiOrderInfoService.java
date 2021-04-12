package com.example.boranqichacha.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.boranqichacha.Entity.FiOrderInfo;

import java.util.List;
import java.util.Map;


/**
 *
 */
public interface FiOrderInfoService extends IService<FiOrderInfo> {
    List<Map<String,Object>> list_userid(int userid, IPage<Map<String,Object>> page);
}
