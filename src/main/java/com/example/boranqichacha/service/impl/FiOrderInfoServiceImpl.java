package com.example.boranqichacha.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boranqichacha.Entity.FiOrderInfo;
import com.example.boranqichacha.mapper.FiOrderInfoMapper;
import com.example.boranqichacha.service.FiOrderInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 *
 */
@Service
@AutoConfigureAfter({FiOrderInfoMapper.class})
public class FiOrderInfoServiceImpl extends ServiceImpl<FiOrderInfoMapper, FiOrderInfo>
implements FiOrderInfoService {
    @Autowired
    FiOrderInfoMapper fiOrderInfoMapper;
    @Override
    public List<Map<String,Object>>list_userid(int userid, IPage<Map<String,Object>> page) {
        return fiOrderInfoMapper.list_userid(userid,page);
    }
}




