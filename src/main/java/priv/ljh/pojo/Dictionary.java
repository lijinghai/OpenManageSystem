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
 * @Date 2021/6/5 17:43
 * @Email lijinghailjh@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="字典管理对象", description="字典管理表")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("字典值")
    private Integer value;

    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("类型编号")
    private String code;


    @ApiModelProperty("类型名称")
    private String role;

    @ApiModelProperty("修改人")
    private String user;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "修改日期")
    private Date date;

}