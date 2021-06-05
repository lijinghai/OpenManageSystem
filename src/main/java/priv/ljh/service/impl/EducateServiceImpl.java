package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Educate;
import priv.ljh.service.EducateService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 学制管理表 服务实现类
 * @Author lijinghai
 * @Date 2021/6/5 15:53
 * @Email lijinghailjh@163.com
 */
@Service
public class EducateServiceImpl implements EducateService {

    /**
     * 查询所有
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param educates
     * @return
     */
    @Override
    public MyPage searchEducate(int pageNo, int limit, String idSorted, List<Educate> educates) {
        MyPage page = null;
        List<Educate> educatesList = new ArrayList<>();
        educatesList.addAll(educates);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(educatesList);
        }
        int total = educatesList.size();
        int maxPageNo = educatesList.size()%limit == 0? educatesList.size()/limit:educatesList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(educatesList.subList(beginIndex, endIndex), total);

        return page;
    }

    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    @Override
    public MyPage searchEducateById(int pageNo, int limit, String idSorted, List<Map> info) {
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
