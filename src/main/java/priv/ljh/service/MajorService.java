package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Major;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 15:06
 * @Email lijinghailjh@163.com
 */
public interface MajorService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param majors
     * @return
     */
    public MyPage searchMajor(int pageNo, int limit, String idSorted, List<Major> majors);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchMajorById(int pageNo, int limit, String idSorted, List<Map> info);
}

