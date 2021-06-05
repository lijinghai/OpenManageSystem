package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.LogMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Log;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.LogService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 18:32
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"系统日志管理控制类"})
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private LogService logService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addLog(@RequestBody Log log) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        logMapper.addLog(log);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, log);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteLog(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = logMapper.deleteLogByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateLog(@RequestBody Log log){
        ResultResponse res = null;
        logMapper.updateLog(log);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, log);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryLog(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Log> logs = logMapper.queryAllLog();
        log.info("logs====>"+ logs);
        MyPage page = this.logService.searchLog(pageNo, limit, idSort,logs);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryLogById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = logMapper.queryLogById(id);
        log.info("info====>"+info);
        MyPage page = this.logService.searchLogById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}
