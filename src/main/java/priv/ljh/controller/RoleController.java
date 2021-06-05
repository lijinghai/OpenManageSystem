package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.RoleMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Role;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.RoleService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 17:00
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"角色管理控制类"})
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addRole(@RequestBody Role role) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        roleMapper.addRole(role);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, role);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteRole(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = roleMapper.deleteRoleByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateRole (@RequestBody Role role){
        ResultResponse res = null;
        roleMapper.updateRole(role);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, role);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryRole(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Role> roles = roleMapper.queryAllRole();
        log.info("roles====>"+ roles);
        MyPage page = this.roleService.searchRole(pageNo, limit, idSort,roles);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryArrangeById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = roleMapper.queryRoleById(id);
        log.info("info====>"+info);
        MyPage page = this.roleService.searchRoleById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}
