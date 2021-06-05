package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.CourseMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Course;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.CourseService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:11
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"课程类别管理控制类"})
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseService courseService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addCourse(@RequestBody Course course) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        courseMapper.addCourse(course);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, course);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteCourse(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = courseMapper.deleteCourseByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateCourse(@RequestBody Course course){
        ResultResponse res = null;
        courseMapper.updateCourse(course);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, course);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryCourse(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Course> courses = courseMapper.queryAllCourse();
        log.info("courses====>"+ courses);
        MyPage page = this.courseService.searchCourse(pageNo, limit, idSort,courses);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryCourseById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = courseMapper.queryCourseById(id);
        log.info("info====>"+info);
        MyPage page = this.courseService.searchCourseById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

