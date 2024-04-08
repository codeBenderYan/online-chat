package com.platform.chaotic.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/7 21:48:30
 */
@Data
@TableName("user_info")
@Schema(name = "用户信息表")
public class UserInfoDO {

    @Schema(name="用户ID")
    @TableId
    private String userId;

    @Schema(name="用户名")
    private String userName;

    @Schema(name="用户密码")
    private String password;

    @Schema(name="性别，具体码值见数据字典‘001’")
    private String gender;

    @Schema(name="年龄")
    private Integer age;

    @Schema(name="手机号码")
    private String phone;

    @Schema(description="邮箱")
    private String email;

    @Schema(description="身份证号")
    private String idCard;

    @Schema(description="创建人")
    private String createUser;

    @Schema(description="创建时间")
    private LocalDateTime createTime;

    @Schema(description="更新人")
    private String updateUser;

    @Schema(description="更新时间")
    private LocalDateTime updateTime;

}
