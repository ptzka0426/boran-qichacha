package com.example.boranqichacha.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boranqichacha.Entity.FiUserInfo;
import com.example.boranqichacha.mapper.FiOrderInfoMapper;
import com.example.boranqichacha.mapper.FiUserInfoMapper;
import com.example.boranqichacha.service.FiUserInfoService;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@AutoConfigureAfter({FiUserInfoMapper.class})
public class FiUserInfoServiceImpl extends ServiceImpl<FiUserInfoMapper, FiUserInfo>
implements FiUserInfoService {

}




