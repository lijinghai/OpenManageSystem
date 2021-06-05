package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Log;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 18:22
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("系统日志管理实体接口类")
public interface LogMapper {
    /**
     * 增加一名信息
     * @param log
     * @return
     */
    int addLog(Log log);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteLogByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param log
     * @return
     */
    int updateLog(Log log);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryLogById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Log> queryAllLog();
}

