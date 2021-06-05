package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.MajorMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Major;
import priv.ljh.service.MajorService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * 专业管理控制类
 * @Author lijinghai
 * @Date 2021/6/5 15:15
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"专业管理控制类"})
@Slf4j
@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private MajorService majorService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addMajor(@RequestBody Major major) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        majorMapper.addMajor(major);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, major);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteMajor(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = majorMapper.deleteMajorByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateMajor(@RequestBody Major major){
        ResultResponse res = null;
        majorMapper.updateMajor(major);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, major);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryArrange(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Major> majors = majorMapper.queryAllMajor();
        log.info("majors====>"+ majors);
        MyPage page = this.majorService.searchMajor(pageNo, limit, idSort,majors);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryArrangeById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = majorMapper.queryMajorById(id);
        log.info("info====>"+info);
        MyPage page = this.majorService.searchMajorById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

