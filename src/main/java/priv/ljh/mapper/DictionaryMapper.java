package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 17:52
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("字典管理实体接口类")
public interface DictionaryMapper {
    /**
     * 增加一名信息
     * @param dictionary
     * @return
     */
    int addDictionary(Dictionary dictionary);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteDictionaryByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param dictionary
     * @return
     */
    int updateDictionary(Dictionary dictionary);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryDictionaryById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Dictionary> queryAllDictionary();
}

