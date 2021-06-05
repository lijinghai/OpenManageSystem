package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Role;
import priv.ljh.service.RoleService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:53
 * @Email lijinghailjh@163.com
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public MyPage searchRole(int pageNo, int limit, String idSorted, List<Role> roles) {
        MyPage page = null;
        List<Role> roleList = new ArrayList<>();
        roleList.addAll(roles);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(roleList);
        }
        int total = roleList.size();
        int maxPageNo = roleList.size()%limit == 0? roleList.size()/limit:roleList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(roleList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchRoleById(int pageNo, int limit, String idSorted, List<Map> info) {
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
