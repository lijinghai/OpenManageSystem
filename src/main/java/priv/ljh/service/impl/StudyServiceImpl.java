package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Study;
import priv.ljh.service.StudyService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 学习形式
 * @Author lijinghai
 * @Date 2021/6/5 15:32
 * @Email lijinghailjh@163.com
 */
@Service
public class StudyServiceImpl implements StudyService {
    /**
     * 查询所有
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param studies
     * @return
     */
    @Override
    public MyPage searchStudy(int pageNo, int limit, String idSorted, List<Study> studies) {
        MyPage page = null;
        List<Study> studyList = new ArrayList<>();
        studyList.addAll(studies);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(studyList);
        }
        int total = studyList.size();
        int maxPageNo = studyList.size()%limit == 0? studyList.size()/limit:studyList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(studyList.subList(beginIndex, endIndex), total);

        return page;
    }

    /**
     * 根据id查询一条数据
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    @Override
    public MyPage searchStudyById(int pageNo, int limit, String idSorted, List<Map> info) {
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
