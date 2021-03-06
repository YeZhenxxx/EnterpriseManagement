package com.oioip.mapper;

import com.oioip.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("roleMapper")
public interface RoleMapper {
    /**
     * 根据用户ID,查询所有对应的角色
     * @param userId
     * @return
     */
    public List<Role> findRolesAndPermissionByUserId(String userId);

    /**
     * 查询所有角色
     * @return
     */
    public abstract List<Role> findAllRole();

    /**
     * 根据用户ID获取该用户未拥有的所有角色
     * @param userId
     * @return
     */
    public abstract List<Role> findUserNoHaveRoleByUserId(String userId);

    /**
     * 根据用户ID获取该用户拥有的所有角色
     * @param userId
     * @return
     */
    public abstract List<Role> findUserHaveRoleByUserId(String userId);

    /**
     * 根据权限ID查询拥有该权限的角色
     * @param permissionId
     * @return
     */
    public abstract List<Role> queryRolesByPermissionId(@Param("permissionId")String permissionId);

    /**
     * 添加角色给用户
     * @param userId
     * @param roleId
     * @throws Exception
     */
    public abstract void addRoleToUser(@Param("roleId") String roleId,@Param("userId") String userId) throws Exception;

    /**
     * 将用户的角色删除
     * @param userId
     * @param roleId
     * @throws Exception
     */
    public abstract void delRoleToUser(@Param("roleId") String roleId,@Param("userId") String userId) throws Exception;

    /**
     * 根据角色ID更新角色信息
     * @param roleId
     * @param role
     * @throws Exception
     */
    public abstract void updateRoleDetailsByRoleId(@Param("roleId") String roleId,@Param("role") Role role)throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    public abstract void saveRole(Role role)throws Exception;

    /**
     * 根据roleId删除角色
     * @param roleId
     * @throws Exception
     */
    public abstract void deleteRoleByRoleId(@Param("roleId") String roleId)throws Exception;

    /**
     * 根据角色ID获取角色详情
     * @param roleId
     * @return
     */
    public abstract Role queryRoleDetailsByRoleId(@Param("roleId") String roleId);

    /**
     * 根据权限Id和角色ID添加权限给角色
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    public abstract void addPermissionToRoleByPermissionIdAndRoleId(@Param("pid")String permissionId,@Param("rid") String roleId )throws Exception;

    /**
     * 根据权限Id和角色ID删除角色权限
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    public abstract void delPermissionToRoleByPermissionIdAndRoleId(@Param("pid")String permissionId,@Param("rid") String roleId )throws Exception;
}
