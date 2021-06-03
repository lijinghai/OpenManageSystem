package priv.ljh.operate.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.ljh.operate.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 员工 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-09
 */
@Mapper
@Repository
@ApiModel("用户实体接口类")
public interface DeptMapper extends BaseMapper<Dept> {

}
