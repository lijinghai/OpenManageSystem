package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.EducateMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Educate;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.EducateService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 15:57
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"学制管理控制类"})
@Slf4j
@RestController
@RequestMapping("/educate")
public class EducateController {
    @Autowired
    private EducateMapper educateMapper;
    @Autowired
    private EducateService educateService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addEducate(@RequestBody Educate educate) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        educateMapper.addEducate(educate);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, educate);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteEducate(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = educateMapper.deleteEducateByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateEducate(@RequestBody Educate educate){
        ResultResponse res = null;
        educateMapper.updateEducate(educate);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, educate);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryEducate(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Educate> educates = educateMapper.queryAllEducate();
        log.info("educates====>"+ educates);
        MyPage page = this.educateService.searchEducate(pageNo, limit, idSort,educates);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryEducateById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = educateMapper.queryEducateById(id);
        log.info("info====>"+info);
        MyPage page = this.educateService.searchEducateById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

