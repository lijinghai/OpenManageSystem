package priv.ljh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.UserMapper;
import priv.ljh.pojo.User;

import java.util.List;

/**
 * 用户控制类
 * @author lijinghai
 * @Date 2021-1-19
 */
@Api(tags = {"用户控制类"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("增加一条用户信息")
    @PostMapping
    public String addUser(User user){
        int result = userMapper.addUser(user);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("根据id删除一条用户数据")
    @DeleteMapping(value = "{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        int result = userMapper.deleteUserByID(id);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public String updateUser(User user){
        int result = userMapper.updateUser(user);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("查询所有用户数据")
    @GetMapping
    public List<User> findAll() {
        List<User> users = userMapper.queryAllUser();
        return users;
    }
}
