package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Course;
import priv.ljh.service.CourseService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:08
 * @Email lijinghailjh@163.com
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public MyPage searchCourse(int pageNo, int limit, String idSorted, List<Course> courses) {
        MyPage page = null;
        List<Course> courseList = new ArrayList<>();
        courseList.addAll(courses);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(courseList);
        }
        int total = courseList.size();
        int maxPageNo = courseList.size()%limit == 0? courseList.size()/limit:courseList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(courseList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchCourseById(int pageNo, int limit, String idSorted, List<Map> info) {
        MyPage page = null;
        List<Map> infoList = new ArrayList<>();
        infoList.addAll(info);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(infoList);
        }
        int total = infoList.size();
        int maxPageNo = infoList.size()%limit == 0? infoList.size()/limit:infoList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(infoList.subList(beginIndex, endIndex), total);

        return page;
    }
}
