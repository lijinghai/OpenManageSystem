package priv.ljh.service.impl;

import org.springframework.stereotype.Service;
import priv.ljh.pojo.User;
import priv.ljh.service.UserService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户管理表 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 查询所有
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param users
     * @return
     */
    @Override
    public MyPage searchUser(int pageNo, int limit, String idSorted, List<User> users) {
        MyPage page = null;
        List<User> userList = new ArrayList<>();
        userList.addAll(users);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(userList);
        }
        int total = userList.size();
        int maxPageNo = userList.size()%limit == 0? userList.size()/limit:userList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(userList.subList(beginIndex, endIndex), total);

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
    public MyPage searchUserById(int pageNo, int limit, String idSorted, List<Map> info) {
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
