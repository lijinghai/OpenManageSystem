package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Educate;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 15:51
 * @Email lijinghailjh@163.com
 */

@Mapper
@Repository
@ApiModel("学制管理实体接口类")
public interface EducateMapper {
    /**
     * 增加一名信息
     * @param educate
     * @return
     */
    int addEducate(Educate educate);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteEducateByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param educate
     * @return
     */
    int updateEducate(Educate educate);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryEducateById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Educate> queryAllEducate();
}
