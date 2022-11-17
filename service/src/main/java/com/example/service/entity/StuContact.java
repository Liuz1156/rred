package com.example.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2022-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StuContact对象", description="")
public class StuContact implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "basic_id", type = IdType.AUTO)
    private Integer basicId;

    @TableField("stuNumber")
    private String stuNumber;

    @ApiModelProperty(value = "联系电话")
    @TableField("phoneNumber")
    private String phoneNumber;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "qq号码")
    private String qq;

    @ApiModelProperty(value = "家庭电话")
    @TableField("faimlyPhoneNumber")
    private String faimlyPhoneNumber;

    @ApiModelProperty(value = "家庭邮编")
    @TableField("faimlyPostCode")
    private String faimlyPostCode;

    @ApiModelProperty(value = "家庭住址")
    @TableField("homeAdress")
    private String homeAdress;


}
