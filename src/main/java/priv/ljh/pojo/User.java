package priv.ljh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应数据库里面的用户管理表
 * @author lijinghai
 * @Date 2021-6-4
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="用户管理对象", description="用户管理表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("编号")
    private Integer code;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("角色")
    private String role;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "修改日期")
    private Date date;
}
