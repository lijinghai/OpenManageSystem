package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Major;
import priv.ljh.pojo.Study;

import java.util.List;
import java.util.Map;

/**
 * 学习形式
 * @Author lijinghai
 * @Date 2021/6/5 15:29
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("学习形式实体接口类")
public interface StudyMapper {
    /**
     * 增加一名信息
     * @param study
     * @return
     */
    int addStudy(Study study);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteStudyByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param study
     * @return
     */
    int updateStudy(Study study);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryStudyById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Study> queryAllStudy();
}
