package com.oioip.mapper;

import com.oioip.domain.Permission;
import com.oioip.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 *
 * 权限表持久层
 */
public interface PermissionMapper {

    /**
     * 根据角色名ID权限列表
     * @param roleId
     * @return
     */
    public abstract List<Permission> findPermissionByRoleId(String roleId);

    /**
     * 根据角色ID查询未拥有的权限列表
     * @param roleId
     * @return
     */
    public abstract List<Permission> queryNoHavePermissionByRoleId(@Param("roleId") String roleId);


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
    public abstract void addPermission(Permission permission)throws Exception;

    /**
     * 根据权限ID删除权限
     * @param permissionId
     */
    public abstract void delPermissionByPermissionId(@Param("permissionId") String permissionId);

    /**
     * 查询权限信息(包括拥有该权限的角色)
     * @param permissionId
     * @return
     */
    public abstract Permission queryPermissionDetailsByPermissionId(@Param("permissionId")String permissionId);

    /**
     * 根据权限ID更新权限信息
     * @param permissionId
     * @param permission
     * @throws Exception
     */
    public abstract void updatePermissionDetailsByPermissionId(@Param("permissionId") String permissionId,@Param("permission") Permission permission)throws Exception;

}
