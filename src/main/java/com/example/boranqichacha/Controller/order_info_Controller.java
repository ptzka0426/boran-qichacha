package com.example.boranqichacha.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.boranqichacha.Entity.FiOrderInfo;
import com.example.boranqichacha.Util.AjaxJson;
import com.example.boranqichacha.service.FiOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @Author LT
 * @create 2021-04-12 11:19
 */
@RequestMapping("order_form")
@RestController
public class order_info_Controller {
    @Autowired
    FiOrderInfoService FiOrderInfoService;

    @RequestMapping(value = "list-userid",method = RequestMethod.POST)
    public AjaxJson list_id(int id,Integer pageNo,Integer pageSize){
        /*IPage<FiOrderInfo> page = new Page<>(pageNo, pageSize);
        FiOrderInfo fi_order=new FiOrderInfo();
        fi_order.setUser_Id(id);
        QueryWrapper<FiOrderInfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(fi_order);
        wrapper.orderByDesc("order_time");*/
        /*return AjaxJson.getPageData(Long.parseLong(pageNo+""),FiOrderInfoService.page(page, wrapper));*/

        IPage<Map<String,Object>> iPage =  new Page<>(pageNo, pageSize);
        /*iPage.setRecords(FiOrderInfoService.list_userid(id,iPage));
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());*/
        if (iPage.getRecords().size() != 0) {
            List<Map<String,Object>> mpUserList1 = iPage.getRecords();
            mpUserList1.forEach(System.out::println);
        } else {
            System.out.println("数据已经加载完成");
        }

        return AjaxJson.getSuccess("用户下单",FiOrderInfoService.list_userid(id,iPage));
    }
}
