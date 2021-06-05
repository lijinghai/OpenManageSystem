package priv.ljh.service;

import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Dictionary;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 17:55
 * @Email lijinghailjh@163.com
 */
public interface DictionaryService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param dictionaries
     * @return
     */
    public MyPage searchDictionary(int pageNo, int limit, String idSorted, List<Dictionary> dictionaries);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchDictionaryById(int pageNo, int limit, String idSorted, List<Map> info);
}

