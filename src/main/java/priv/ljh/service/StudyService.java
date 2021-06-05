package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Study;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 15:31
 * @Email lijinghailjh@163.com
 */
public interface StudyService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param studies
     * @return
     */
    public MyPage searchStudy(int pageNo, int limit, String idSorted, List<Study> studies);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchStudyById(int pageNo, int limit, String idSorted, List<Map> info);
}

