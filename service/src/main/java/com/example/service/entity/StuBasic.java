package com.example.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StuBasic对象", description="")
public class StuBasic implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("stuNumber")
    private String stuNumber;

    @ApiModelProperty(value = "姓名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "身份证号")
    @TableField("cardID")
    private String cardID;

    @ApiModelProperty(value = "性别 1男 2女")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date birth;

    @ApiModelProperty(value = "学院编号")
    private Integer academy;

    @ApiModelProperty(value = "专业编号")
    private Integer major;

    @ApiModelProperty(value = "班级编号")
    private Integer banji;

    @ApiModelProperty(value = "逻辑删除 0未删除 1删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "学制")
    @TableField("eduSystem")
    private Integer eduSystem;

    @ApiModelProperty(value = "籍贯")
    @TableField("navPlace")
    private String navPlace;

    @ApiModelProperty(value = "生源地")
    @TableField("originPlace")
    private String originPlace;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField("politicalFace")
    private String politicalFace;

    @ApiModelProperty(value = "所属校区")
    private String district;

    @ApiModelProperty(value = "入学日期")
    @TableField("enrollTime")
    private Date enrollTime;


}
