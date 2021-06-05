package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Resource;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:34
 * @Email lijinghailjh@163.com
 */
public interface ResourceService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param resources
     * @return
     */
    public MyPage searchResource(int pageNo, int limit, String idSorted, List<Resource> resources);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchResourceById(int pageNo, int limit, String idSorted, List<Map> info);
}


