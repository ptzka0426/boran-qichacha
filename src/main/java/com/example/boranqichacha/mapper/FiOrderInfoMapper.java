package com.example.boranqichacha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.boranqichacha.Entity.FiOrderInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


/**
 * @Entity generator.Entity.FiOrderInfo
 */
@Mapper
public interface FiOrderInfoMapper extends BaseMapper<FiOrderInfo> {
    @Select("select dd.order_id,yw.goods_name,yw.icon,zt.schedule_remark from fi_order_info dd   INNER JOIN fi_business_goods yw on dd.business_id=yw.business_id\n" +
            "INNER JOIN fi_order_schedule_record zt on zt.order_id=dd.order_id\n" +
            " where user_id=#{userid}\n" +
            " GROUP BY dd.order_id,goods_name\n" +
            " ORDER BY DD.create_time DESC")
    List<Map<String,Object>> list_userid(int userid, IPage<Map<String,Object>> page);
}




