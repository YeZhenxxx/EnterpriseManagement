package com.oioip.service;

import com.oioip.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 *
 * 权限 业务层
 */
public interface PermissionService {
    /**
     * 根据角色名获取权限列表
     * @param roleId
     * @return
     */
    public abstract List<Permission> findPermissionByRoleId(String roleId);

    /**
     * 根据角色ID查询未拥有的权限列表
     * @param roleId
     * @return
     */
    public abstract List<Permission> queryNoHavePermissionByRoleId(String roleId);


    /**
     * 根据角色ID查询已拥有的权限列表
     * @param roleId
     * @return
     */
    public abstract List<Permission> queryHavePermissionByRoleId(@Param("roleId") String roleId);

    /**
     * 查询权限列表
     * @return
     */
    public abstract List<Permission> findAll();

    /**
     * 添加权限
     * @param permission
     * @throws Exception
     */
    public abstract void addPermission(Permission permission) throws Exception;

    /**
     * 根据权限ID删除权限
     * @param permissionId
     * @throws Exception
     */
    public abstract void delPermissionByPermissionId(@Param("permissionId") String permissionId)throws Exception;

    /**
     * 查询权限信息(包括拥有该权限的角色)
     * @param permissionId
     * @return
     */
    public abstract Permission queryPermissionDetailsByPermissionId(String permissionId);

    /**
     * 根据权限ID更新权限信息
     * @param permissionId
     * @param permission
     * @throws Exception
     */
    public abstract void updatePermissionDetailsByPermissionId(String permissionId,Permission permission)throws Exception;

}
