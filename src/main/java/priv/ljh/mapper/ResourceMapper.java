package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Resource;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:31
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("资源分类管理实体接口类")
public interface ResourceMapper {
    /**
     * 增加一名信息
     * @param resource
     * @return
     */
    int addResource(Resource resource);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteResourceByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param resource
     * @return
     */
    int updateResource(Resource resource);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryResourceById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Resource> queryAllResource();
}
