package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Course;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:07
 * @Email lijinghailjh@163.com
 */
public interface CourseService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param courses
     * @return
     */
    public MyPage searchCourse(int pageNo, int limit, String idSorted, List<Course> courses);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchCourseById(int pageNo, int limit, String idSorted, List<Map> info);
}
