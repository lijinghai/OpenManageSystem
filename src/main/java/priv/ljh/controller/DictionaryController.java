package priv.ljh.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.ljh.mapper.ArrangeMapper;
import priv.ljh.mapper.DictionaryMapper;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Dictionary;
import priv.ljh.service.ArrangeService;
import priv.ljh.service.DictionaryService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 18:02
 * @Email lijinghailjh@163.com
 */
@Api(tags = {"字典管理控制类"})
@Slf4j
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse addDictionary(@RequestBody Dictionary dictionary) {
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        dictionaryMapper.addDictionary(dictionary);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, dictionary);
        return res;
    }

    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteDictionary(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = dictionaryMapper.deleteDictionaryByID(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateDictionary(@RequestBody Dictionary dictionary){
        ResultResponse res = null;
        dictionaryMapper.updateDictionary(dictionary);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, dictionary);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryDictionary(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Dictionary> dictionaries = dictionaryMapper.queryAllDictionary();
        log.info("dictionaries====>"+ dictionaries);
        MyPage page = this.dictionaryService.searchDictionary(pageNo, limit, idSort,dictionaries);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryDictionaryById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = dictionaryMapper.queryDictionaryById(id);
        log.info("info====>"+info);
        MyPage page = this.dictionaryService.searchDictionaryById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

