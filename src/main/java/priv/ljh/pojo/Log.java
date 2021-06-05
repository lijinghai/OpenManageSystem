package priv.ljh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author lijinghai
 * @Date 2021/6/5 18:18
 * @Email lijinghailjh@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="系统日志管理对象", description="系统日志管理表")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("请求方法")
    private String method;

    @ApiModelProperty("请求参数")
    private String arrange_name;

    @ApiModelProperty("层次名称")
    private String param;

    @ApiModelProperty("请求路径")
    private String route;

    @ApiModelProperty("请求结果")
    private String result;

    @ApiModelProperty("执行人名称")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "修改日期")
    private Date date;
}
