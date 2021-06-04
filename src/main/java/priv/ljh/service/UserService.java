package priv.ljh.service;

import priv.ljh.pojo.User;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 自定义分页查询方法
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param users
     * @return
     */
    public MyPage searchUser(int pageNo, int limit, String idSorted, List<User> users);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchUserById(int pageNo, int limit, String idSorted, List<Map> info);

}
