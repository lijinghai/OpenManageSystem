package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.User;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 14:02
 * @Email lijinghailjh@163.com
 */
public interface ArrangeService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param arranges
     * @return
     */
    public MyPage searchArrange(int pageNo, int limit, String idSorted, List<Arrange> arranges);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchArrangeById(int pageNo, int limit, String idSorted, List<Map> info);
}
