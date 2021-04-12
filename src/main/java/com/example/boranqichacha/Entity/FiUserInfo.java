package com.example.boranqichacha.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName fi_user_info
 */
@TableName(value ="fi_user_info")
@Data
public class FiUserInfo implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String mobileNo;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码盐值
     */
    private String salt;

    /**
     * 自己的邀请码
     */
    private String invitationCode;

    /**
     * 邀请我的邀请码
     */
    private String invitationMeCode;

    /**
     * vip等级
     */
    private Integer vipLv;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 微信unionId
     */
    private String unionId;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 是否实名认证  0否 1是
     */
    private Boolean isCertification;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 删除标记 (0未删除 1已删除)
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

    /**
     * 用户禁用状态 0未禁用 1禁用
     */
    private Integer disableStatus;

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
        FiUserInfo other = (FiUserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHeadImg() == null ? other.getHeadImg() == null : this.getHeadImg().equals(other.getHeadImg()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMobileNo() == null ? other.getMobileNo() == null : this.getMobileNo().equals(other.getMobileNo()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getInvitationCode() == null ? other.getInvitationCode() == null : this.getInvitationCode().equals(other.getInvitationCode()))
            && (this.getInvitationMeCode() == null ? other.getInvitationMeCode() == null : this.getInvitationMeCode().equals(other.getInvitationMeCode()))
            && (this.getVipLv() == null ? other.getVipLv() == null : this.getVipLv().equals(other.getVipLv()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getUnionId() == null ? other.getUnionId() == null : this.getUnionId().equals(other.getUnionId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsCertification() == null ? other.getIsCertification() == null : this.getIsCertification().equals(other.getIsCertification()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDisableStatus() == null ? other.getDisableStatus() == null : this.getDisableStatus().equals(other.getDisableStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHeadImg() == null) ? 0 : getHeadImg().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMobileNo() == null) ? 0 : getMobileNo().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getInvitationCode() == null) ? 0 : getInvitationCode().hashCode());
        result = prime * result + ((getInvitationMeCode() == null) ? 0 : getInvitationMeCode().hashCode());
        result = prime * result + ((getVipLv() == null) ? 0 : getVipLv().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getUnionId() == null) ? 0 : getUnionId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsCertification() == null) ? 0 : getIsCertification().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDisableStatus() == null) ? 0 : getDisableStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", headImg=").append(headImg);
        sb.append(", nickName=").append(nickName);
        sb.append(", mobileNo=").append(mobileNo);
        sb.append(", password=").append(password);
        sb.append(", company=").append(company);
        sb.append(", email=").append(email);
        sb.append(", salt=").append(salt);
        sb.append(", invitationCode=").append(invitationCode);
        sb.append(", invitationMeCode=").append(invitationMeCode);
        sb.append(", vipLv=").append(vipLv);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", status=").append(status);
        sb.append(", isCertification=").append(isCertification);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", regTime=").append(regTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", disableStatus=").append(disableStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
