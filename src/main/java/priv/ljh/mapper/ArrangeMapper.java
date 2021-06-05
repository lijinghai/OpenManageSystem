package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;

import java.util.List;
import java.util.Map;

/**
 * 层次管理表类接口
 * @Mapper 表示的是mybatis的mapper类
 * @author lijinghai
 * @Date 2021-6-5
 */

@Mapper
@Repository
@ApiModel("层次管理实体接口类")
public interface ArrangeMapper {
    /**
     * 增加一名信息
     * @param arrange
     * @return
     */
    int addArrange(Arrange arrange);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteArrangeByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param arrange
     * @return
     */
    int updateArrange(Arrange arrange);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryArrangeById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Arrange> queryAllArrange();
}
