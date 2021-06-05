package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Major;
import priv.ljh.service.MajorService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 专业管理表 服务实现类
 * </p>
 * @Author lijinghai
 * @Date 2021/6/5 15:07
 * @Email lijinghailjh@163.com
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Override
    public MyPage searchMajor(int pageNo, int limit, String idSorted, List<Major> majors) {
        MyPage page = null;
        List<Major> majorList = new ArrayList<>();
        majorList.addAll(majors);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(majorList);
        }
        int total = majorList.size();
        int maxPageNo = majorList.size()%limit == 0? majorList.size()/limit:majorList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(majorList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchMajorById(int pageNo, int limit, String idSorted, List<Map> info) {
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
