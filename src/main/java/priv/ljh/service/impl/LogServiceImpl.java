package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Log;
import priv.ljh.service.LogService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 18:25
 * @Email lijinghailjh@163.com
 */
@Service
public class LogServiceImpl implements LogService {
    @Override
    public MyPage searchLog(int pageNo, int limit, String idSorted, List<Log> logs) {
        MyPage page = null;
        List<Log> logList = new ArrayList<>();
        logList.addAll(logs);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(logList);
        }
        int total = logList.size();
        int maxPageNo = logList.size()%limit == 0? logList.size()/limit:logList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(logList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchLogById(int pageNo, int limit, String idSorted, List<Map> info) {
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
