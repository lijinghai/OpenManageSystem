package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Major;

import java.util.List;
import java.util.Map;

/**
 * 专业管理
 * @Author lijinghai
 * @Date 2021/6/5 15:04
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("专业管理实体接口类")
public interface MajorMapper {
    /**
     * 增加一名信息
     * @param major
     * @return
     */
    int addMajor(Major major);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteMajorByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param major
     * @return
     */
    int updateMajor(Major major);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryMajorById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Major> queryAllMajor();
}
