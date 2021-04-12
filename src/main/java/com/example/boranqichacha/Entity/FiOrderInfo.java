package com.example.boranqichacha.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 * @TableName fi_order_info
 */
@TableName(value ="fi_order_info")
@Data
public class FiOrderInfo implements Serializable {
    /**
     * 订单号
     */
    @TableId
    private Long order_Id;

    /**
     * 商户支付号
     */
    private String out_Trade_No;

    /**
     * 业务商品id
     */
    private Long goods_Id;

    /**
     * 业务id
     */
    private Integer business_Id;

    /**
     * 用户id
     */
    private Integer user_Id;

    /**
     * 预留手机号
     */
    private String order_Mobile;

    /**
     * 订单状态 1 待付款 2已接单  3已完成 4已取消  5废弃订单
     */
    private Integer order_Status;

    /**
     * 订单进度   1企业核名 2提交材料 3领取执照 4刻章
     */
    private Integer order_Schedule;

    /**
     * 支付状态 0未付款  1已付款
     */
    private Integer pay_Status;

    /**
     * 订单类型 1用户线上下单 2后台工作人员下单
     */
    private Integer order_Type;

    /**
     * 订单生成时间
     */
    private Date order_Time;

    /**
     * 支付时间
     */
    private Date pay_Time;

    /**
     * 应付金额
     */
    private BigDecimal total_Money;

    /**
     * 实付金额
     */
    private BigDecimal order_Money;

    /**
     * 优惠金额
     */
    private BigDecimal coupon_Money;

    /**
     * 支付渠道 1微信支付 2支付宝支付 3第三方支付 4其他支付
     */
    private Integer pay_Channel;

    /**
     * 订单备注
     */
    private String order_Remark;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String del_Flag;

    /**
     * 创建时间
     */
    private Date create_Time;

    /**
     * 更新时间
     */
    private Date update_Time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
