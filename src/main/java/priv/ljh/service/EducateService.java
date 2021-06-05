package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Educate;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 15:52
 * @Email lijinghailjh@163.com
 */
public interface EducateService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param educates
     * @return
     */
    public MyPage searchEducate(int pageNo, int limit, String idSorted, List<Educate> educates);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchEducateById(int pageNo, int limit, String idSorted, List<Map> info);
}
