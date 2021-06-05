package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:05
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("课程类别管理实体接口类")
public interface CourseMapper {
    /**
     * 增加一名信息
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteCourseByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryCourseById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Course> queryAllCourse();
}

