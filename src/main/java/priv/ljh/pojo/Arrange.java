package priv.ljh.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 对应数据库里面的层次管理表
 * @author lijinghai
 * @Date 2021-6-4
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="层次管理对象", description="层次管理表")
public class Arrange implements Serializable {
}
