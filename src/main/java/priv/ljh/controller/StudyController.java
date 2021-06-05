package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.StudyMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Study;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.StudyService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * 学习形式表控制类
 * @Author lijinghai
 * @Date 2021/6/5 15:36
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"学习形式控制类"})
@Slf4j
@RestController
@RequestMapping("/study")
public class StudyController {
    @Autowired
    private StudyMapper studyMapper;
    @Autowired
    private StudyService studyService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addStudy(@RequestBody Study study) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        studyMapper.addStudy(study);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, study);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteStudy(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = studyMapper.deleteStudyByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateStudy(@RequestBody Study study){
        ResultResponse res = null;
        studyMapper.updateStudy(study);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, study);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryStudy(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Study> studies = studyMapper.queryAllStudy();
        log.info("studies====>"+ studies);
        MyPage page = this.studyService.searchStudy(pageNo, limit, idSort,studies);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryArrangeById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = studyMapper.queryStudyById(id);
        log.info("info====>"+info);
        MyPage page = this.studyService.searchStudyById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

