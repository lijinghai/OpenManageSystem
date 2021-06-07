package priv.ljh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 对应数据库里面的专业管理表
 * @Author lijinghai
 * @Date 2021/6/5 14:57
 * @Email lijinghailjh@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="专业管理对象", description="专业管理表")
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("专业代码")
    private Integer major_code;

    @ApiModelProperty("专业名称")
    private String major_name;

    @ApiModelProperty("层次")
    private String level;

    @ApiModelProperty("备注")
    private String major_note;

}
