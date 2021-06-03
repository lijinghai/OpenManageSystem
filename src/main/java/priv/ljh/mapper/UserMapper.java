package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.User;

import java.util.List;

/**
 * 用户类接口
 * @Mapper 表示的是mybatis的mapper类
 * @author lijinghai
 * @Date 2021-1-19
 */

@Mapper
@Repository
@ApiModel("用户实体接口类")
public interface UserMapper {
    /**
     * 增加一名用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据id删除一条用户信息
     * @param id
     * @return
     */
    int deleteUserByID(@Param("id") Integer id);

    /**
     * 更新一条用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> queryAllUser();

}
