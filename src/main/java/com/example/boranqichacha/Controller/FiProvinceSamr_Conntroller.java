package com.example.boranqichacha.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.boranqichacha.Entity.FiProvinceSamr;
import com.example.boranqichacha.Util.AjaxJson;
import com.example.boranqichacha.service.FiProvinceSamrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LT
 * @create 2021-04-13 11:20
 * 市监管局接口
 */
@RequestMapping("Samr")
@RestController
public class FiProvinceSamr_Conntroller {
    @Autowired
    private FiProvinceSamrService fiProvinceSamrService;

    @RequestMapping(value = "supervision",method = RequestMethod.GET)
    public AjaxJson supervision(Integer pageNo,Integer pageSize){
        IPage<FiProvinceSamr> iPage=new Page<>(pageNo,pageSize);
        return AjaxJson.getSuccess("市监管局:"+pageNo+"页",fiProvinceSamrService.page(iPage));
    }

}
