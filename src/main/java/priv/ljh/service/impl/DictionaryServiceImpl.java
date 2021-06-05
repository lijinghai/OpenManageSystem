package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Dictionary;
import priv.ljh.service.DictionaryService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 17:56
 * @Email lijinghailjh@163.com
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public MyPage searchDictionary(int pageNo, int limit, String idSorted, List<Dictionary> dictionaries) {
        MyPage page = null;
        List<Dictionary> dictionarieList = new ArrayList<>();
        dictionarieList.addAll(dictionaries);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(dictionarieList);
        }
        int total = dictionarieList.size();
        int maxPageNo = dictionarieList.size()%limit == 0? dictionarieList.size()/limit:dictionarieList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(dictionarieList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchDictionaryById(int pageNo, int limit, String idSorted, List<Map> info) {
        MyPage page = null;
        List<Map> infoList = new ArrayList<>();
        infoList.addAll(info);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(infoList);
        }
        int total = infoList.size();
        int maxPageNo = infoList.size()%limit == 0? infoList.size()/limit:infoList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(infoList.subList(beginIndex, endIndex), total);

        return page;
    }
}
