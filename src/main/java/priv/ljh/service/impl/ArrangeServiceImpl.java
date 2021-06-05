package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.User;
import priv.ljh.service.ArrangeService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 层次管理表 服务实现类
 * </p>
 * @Author lijinghai
 * @Date 2021/6/5 14:03
 * @Email lijinghailjh@163.com
 */
@Service
public class ArrangeServiceImpl implements ArrangeService {

    /**
     * 查询所有
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param arranges
     * @return
     */
    @Override
    public MyPage searchArrange(int pageNo, int limit, String idSorted, List<Arrange> arranges) {
        MyPage page = null;
        List<Arrange> arrangeList = new ArrayList<>();
        arrangeList.addAll(arranges);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(arrangeList);
        }
        int total = arrangeList.size();
        int maxPageNo = arrangeList.size()%limit == 0? arrangeList.size()/limit:arrangeList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(arrangeList.subList(beginIndex, endIndex), total);

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
    public MyPage searchArrangeById(int pageNo, int limit, String idSorted, List<Map> info) {
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
