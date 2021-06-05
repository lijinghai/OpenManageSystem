package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.ResourceMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Resource;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.ResourceService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:40
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"资源分类管理控制类"})
@Slf4j
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceService resourceService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addResource(@RequestBody Resource resource) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        resourceMapper.addResource(resource);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, resource);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteResource(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = resourceMapper.deleteResourceByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateResource(@RequestBody Resource resource){
        ResultResponse res = null;
        resourceMapper.updateResource(resource);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, resource);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryResource(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Resource> arranges = resourceMapper.queryAllResource();
        log.info("arranges====>"+ arranges);
        MyPage page = this.resourceService.searchResource(pageNo, limit, idSort,arranges);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryResourceById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = resourceMapper.queryResourceById(id);
        log.info("info====>"+info);
        MyPage page = this.resourceService.searchResourceById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

