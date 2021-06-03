package priv.ljh.operate.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.Dept;
import priv.ljh.operate.mapper.DeptMapper;
import priv.ljh.operate.service.DeptService;

import java.util.List;

/**
 * <p>
 * 员工 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-09
 */
@Api(tags = {"员工控制类"})
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @ApiOperation("增加一条用户信息")
    @PostMapping
    public String addDept(Dept dept){
        int result = deptMapper.insert(dept);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("根据id删除一条用户数据")
    @DeleteMapping(value = "{id}")
    public String deleteDept(@PathVariable("id")Long id){
        int result = deptMapper.deleteById(id);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public String updateDept(Dept dept){
        int result =deptMapper.updateById(dept);
        if(result != 0){
            return "success";
        }else{
            return "error";
        }
    }

    @ApiOperation("查询所有用户数据")
    @GetMapping
    public List<Dept> findAll() {
        List<Dept> users = deptMapper.selectList(null);
        return users;
    }

}

