package com.artframework.sample.domains.user.domain;

import mo.gov.dsaj.domain.core.domain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* user
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "用戶域")
public class UserDomain extends BaseDomain {
    /**
    * 主鍵
    */
    @ApiModelProperty(value =  "主鍵")
    private java.lang.Long id;
    /**
    * 名字
    */
    @ApiModelProperty(value =  "名字")
    private java.lang.String name;
    /**
    * 手机
    */
    @ApiModelProperty(value =  "手机")
    private java.lang.String phone;
    /**
    * 家庭成員總數
    */
    @ApiModelProperty(value =  "家庭成員總數")
    private java.lang.Integer familyMemberCount;
    /**
    * 創建時間
    */
    @ApiModelProperty(value =  "創建時間")
    private java.util.Date createdTime;
    /**
    * 創建用戶
    */
    @ApiModelProperty(value =  "創建用戶")
    private java.lang.String createdBy;
    /**
    * 創建時間
    */
    @ApiModelProperty(value =  "創建時間")
    private java.util.Date updatedTime;
    /**
    * 創建用戶
    */
    @ApiModelProperty(value =  "創建用戶")
    private java.lang.String updatedBy;

    /**
    * RELATE user_address
    */
    @ApiModelProperty(value =  "RELATE user_address")
    private UserAddressDomain userAddress;
    /**
    * RELATE user_family_member
    */
    @ApiModelProperty(value =  "RELATE user_family_member")
    private java.util.List<UserFamilyMemberDomain> userFamilyMemberList;


    /**
    * 加载数据標識類
    */
    @ApiModelProperty(value =  "加载数据標識類")
    private LoadFlag loadFlag;

    @Getter
    @Setter
    @ToString
    public static class UserAddressDomain extends BaseDomain{
        /**
        * 是否有变化
        */
        @ApiModelProperty(value =  "是否有变化")
        private Boolean changed = false;

        /**
        * 主鍵
        */
        @ApiModelProperty(value =  "主鍵")
        private java.lang.Long id;
        /**
        * 关联用户
        */
        @ApiModelProperty(value =  "关联用户")
        private java.lang.Long userId;
        /**
        * 地址
        */
        @ApiModelProperty(value =  "地址")
        private java.lang.String addressName;
        /**
        * 創建時間
        */
        @ApiModelProperty(value =  "創建時間")
        private java.util.Date createdTime;
        /**
        * 創建用戶
        */
        @ApiModelProperty(value =  "創建用戶")
        private java.lang.String createdBy;
        /**
        * 創建時間
        */
        @ApiModelProperty(value =  "創建時間")
        private java.util.Date updatedTime;
        /**
        * 創建用戶
        */
        @ApiModelProperty(value =  "創建用戶")
        private java.lang.String updatedBy;
    }
    @Getter
    @Setter
    @ToString
    public static class UserFamilyMemberDomain extends BaseDomain{
        /**
        * 是否有变化
        */
        @ApiModelProperty(value =  "是否有变化")
        private Boolean changed = false;

        /**
        * 主鍵
        */
        @ApiModelProperty(value =  "主鍵")
        private java.lang.Long id;
        /**
        * 唯一键
        */
        @ApiModelProperty(value =  "唯一键")
        private java.lang.Long userId;
        /**
        * 姓名
        */
        @ApiModelProperty(value =  "姓名")
        private java.lang.String name;
        /**
        * 家属关系
        */
        @ApiModelProperty(value =  "家属关系")
        private java.lang.String relType;
        /**
        * 創建時間
        */
        @ApiModelProperty(value =  "創建時間")
        private java.util.Date createdTime;
        /**
        * 創建用戶
        */
        @ApiModelProperty(value =  "創建用戶")
        private java.lang.String createdBy;
        /**
        * 創建時間
        */
        @ApiModelProperty(value =  "創建時間")
        private java.util.Date updatedTime;
        /**
        * 創建用戶
        */
        @ApiModelProperty(value =  "創建用戶")
        private java.lang.String updatedBy;
    }


    @Getter
    @Setter
    @ToString
    public static class LoadFlag extends BaseLoadFlag{

        /**
        *
        */
        @ApiModelProperty(value =  "加載UserAddressDomain")
        private Boolean loadUserAddress = false;

        /**
        *
        */
        @ApiModelProperty(value =  "加載UserFamilyMemberDomain")
        private Boolean loadUserFamilyMember = false;
    }
}
