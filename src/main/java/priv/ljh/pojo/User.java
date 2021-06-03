package priv.ljh.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应数据库里面的用户表
 * @author lijinghai
 * @Date 2021-1-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("姓名(登录名)")
    private String username;
    @ApiModelProperty("登录密码")
    private String password;
    @ApiModelProperty("专业")
    private String profession;
    @ApiModelProperty("物品名")
    private String article;
    @ApiModelProperty("电话号码")
    private String phoneNum;
}
