package priv.ljh.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.pojo.Arrange;
import priv.ljh.pojo.Role;

import java.util.List;
import java.util.Map;

/**
 * @Author lijinghai
 * @Date 2021/6/5 16:50
 * @Email lijinghailjh@163.com
 */
@Mapper
@Repository
@ApiModel("角色管理实体接口类")
public interface RoleMapper {
    /**
     * 增加一名信息
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 根据id删除一条信息
     * @param id
     * @return
     */
    int deleteRoleByID(@Param("id") Integer id);

    /**
     * 更新一条信息
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Map> queryRoleById(int id);

    /**
     * 查询所有的信息
     * @return
     */
    List<Role> queryAllRole();
}

