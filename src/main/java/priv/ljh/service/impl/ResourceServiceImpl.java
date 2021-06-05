package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Resource;
import priv.ljh.service.ResourceService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:35
 * @Email lijinghailjh@163.com
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public MyPage searchResource(int pageNo, int limit, String idSorted, List<Resource> resources) {
        MyPage page = null;
        List<Resource> resourceList = new ArrayList<>();
        resourceList.addAll(resources);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(resourceList);
        }
        int total = resourceList.size();
        int maxPageNo = resourceList.size()%limit == 0? resourceList.size()/limit:resourceList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(resourceList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchResourceById(int pageNo, int limit, String idSorted, List<Map> info) {
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
