package com.example.boranqichacha.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boranqichacha.Entity.FiProvinceSamr;
import com.example.boranqichacha.mapper.FiProvinceSamrMapper;
import com.example.boranqichacha.service.FiProvinceSamrService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@AutoConfigureAfter({FiProvinceSamrMapper.class})
public class FiProvinceSamrServiceImpl extends ServiceImpl<FiProvinceSamrMapper, FiProvinceSamr>
implements FiProvinceSamrService {

}




