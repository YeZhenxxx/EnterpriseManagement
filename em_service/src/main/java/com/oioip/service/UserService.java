package com.oioip.service;

import com.oioip.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author Administrator
 * 用户登录认证
 */
public interface UserService extends UserDetailsService {

    /**
     * 分页查询所有用户
     * @param page
     * @param size
     * @return
     */

    public abstract List<UserInfo> findAll(Integer page,Integer size);

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


}
