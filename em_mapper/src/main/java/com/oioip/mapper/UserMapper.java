package com.oioip.mapper;

import com.oioip.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 *
 * 用户持久层接口
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 查询所有用户操作
     * @return
     */
    public abstract List<UserInfo> findAll();


    /**
     * 根据用户名查询对象
     * @param username
     * @return
     */
    public abstract UserInfo findByUserName(@Param("userName") String username);

    /**
     * 根据用户ID获取详细信息
     * @param id 用户ID
     * @return
     */
    public abstract UserInfo findRolesAndPermissionByUserId(String id);

    /**
     * 保存用户
     * @param userInfo
     * @exception
     */
    public abstract void saveUser(UserInfo userInfo) throws Exception;

    /**
     * 通过用户ID获取用户详细信息，不包括角色和权限信息
     * @param userId
     * @return
     */
    public abstract UserInfo findUserByUserId(@Param("userId") String userId);

    /**
     * 根据角色Id获取所属用户列表
     * @param roleId
     * @return
     */
    public abstract List<UserInfo> findUsersByRoleId(@Param("userId") String roleId);


}
