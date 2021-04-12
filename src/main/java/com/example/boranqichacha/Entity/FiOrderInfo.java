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
    private Long orderId;

    /**
     * 商户支付号
     */
    private String outTradeNo;

    /**
     * 业务商品id
     */
    private Long goodsId;

    /**
     * 业务id
     */
    private Long businessId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 预留手机号
     */
    private String orderMobile;

    /**
     * 订单状态 1 待付款 2已接单  3已完成 4已取消  5废弃订单
     */
    private Integer orderStatus;

    /**
     * 订单进度   1企业核名 2提交材料 3领取执照 4刻章
     */
    private Integer orderSchedule;

    /**
     * 支付状态 0未付款  1已付款
     */
    private Integer payStatus;

    /**
     * 订单类型 1用户线上下单 2后台工作人员下单
     */
    private Integer orderType;

    /**
     * 订单生成时间
     */
    private Date orderTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 应付金额
     */
    private BigDecimal totalMoney;

    /**
     * 实付金额
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    private BigDecimal couponMoney;

    /**
     * 支付渠道 1微信支付 2支付宝支付 3第三方支付 4其他支付
     */
    private Integer payChannel;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FiOrderInfo other = (FiOrderInfo) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderMobile() == null ? other.getOrderMobile() == null : this.getOrderMobile().equals(other.getOrderMobile()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderSchedule() == null ? other.getOrderSchedule() == null : this.getOrderSchedule().equals(other.getOrderSchedule()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getTotalMoney() == null ? other.getTotalMoney() == null : this.getTotalMoney().equals(other.getTotalMoney()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getCouponMoney() == null ? other.getCouponMoney() == null : this.getCouponMoney().equals(other.getCouponMoney()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getOrderRemark() == null ? other.getOrderRemark() == null : this.getOrderRemark().equals(other.getOrderRemark()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderMobile() == null) ? 0 : getOrderMobile().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderSchedule() == null) ? 0 : getOrderSchedule().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getTotalMoney() == null) ? 0 : getTotalMoney().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getCouponMoney() == null) ? 0 : getCouponMoney().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getOrderRemark() == null) ? 0 : getOrderRemark().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", businessId=").append(businessId);
        sb.append(", userId=").append(userId);
        sb.append(", orderMobile=").append(orderMobile);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderSchedule=").append(orderSchedule);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", totalMoney=").append(totalMoney);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", couponMoney=").append(couponMoney);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", orderRemark=").append(orderRemark);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
