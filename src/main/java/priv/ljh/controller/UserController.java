package priv.ljh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.UserMapper;
import priv.ljh.pojo.User;
import priv.ljh.service.UserService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;
import cn.hutool.core.util.RandomUtil;

import java.util.List;
import java.util.Map;

/**
 * 用户管理表控制类
 * @author lijinghai
 * @Date 2021-6-4
 */
@Api(tags = {"用户管理控制类"})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @ApiOperation("增加一条用户信息")
    @PostMapping
    public ResultResponse addUser(@RequestBody User user) {
            ResultResponse res = null;
            int id = RandomUtil.randomInt(10000);
            userMapper.addUser(user);
            res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
            return res;
        }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = userMapper.deleteUserByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateUser(@RequestBody User user){
        ResultResponse res = null;
        userMapper.updateUser(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryUser(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<User> users = userMapper.queryAllUser();
        log.info("users====>"+ users);
        MyPage page = this.userService.searchUser(pageNo, limit, idSort,users);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryUserById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = userMapper.queryUserById(id);
        log.info("info====>"+info);
        MyPage page = this.userService.searchUserById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

}
