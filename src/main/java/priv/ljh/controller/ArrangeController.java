package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.User;
import priv.ljh.service.ArrangeService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * 层次管理表控制类
 * @Author lijinghai
 * @Date 2021/6/5 14:11
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"层次管理控制类"})
@Slf4j
@RestController
@RequestMapping("/arrange")
public class ArrangeController {
    @Autowired
    private ArrangeMapper arrangeMapper;
    @Autowired
    private ArrangeService arrangeService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addArrange(@RequestBody Arrange arrange) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        arrangeMapper.addArrange(arrange);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, arrange);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteArrange(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = arrangeMapper.deleteArrangeByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateArrange(@RequestBody Arrange arrange){
        ResultResponse res = null;
        arrangeMapper.updateArrange(arrange);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, arrange);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryArrange(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Arrange> arranges = arrangeMapper.queryAllArrange();
        log.info("arranges====>"+ arranges);
        MyPage page = this.arrangeService.searchArrange(pageNo, limit, idSort,arranges);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryArrangeById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = arrangeMapper.queryArrangeById(id);
        log.info("info====>"+info);
        MyPage page = this.arrangeService.searchArrangeById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}
