package com.oioip.service.impl;

import com.oioip.domain.Permission;
import com.oioip.mapper.PermissionMapper;
import com.oioip.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 * 权限 业务层实现类
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource(name = "permissionMapper")
    private PermissionMapper pm;

    @Override
    public List<Permission> findPermissionByRoleId(String roleId) {
        List<Permission> permissions = pm.findPermissionByRoleId(roleId);
        return permissions;
    }

    @Override
    public List<Permission> queryNoHavePermissionByRoleId(String roleId) {
        List<Permission> permissions = pm.queryNoHavePermissionByRoleId(roleId);
        return permissions;
    }

    @Override
    public List<Permission> queryHavePermissionByRoleId(String roleId) {
        List<Permission> permissions = pm.queryHavePermissionByRoleId(roleId);
        return permissions;
    }

    @Override
    public List<Permission> findAll() {
        List<Permission> all = pm.findAll();
        return all;
    }

    @Override
    public void addPermission(Permission permission)throws Exception {
        pm.addPermission(permission);
    }

    @Override
    public void delPermissionByPermissionId(String permissionId) throws Exception {
        pm.delPermissionByPermissionId(permissionId);
    }

    @Override
    public Permission queryPermissionDetailsByPermissionId(String permissionId) {
        Permission permission = pm.queryPermissionDetailsByPermissionId(permissionId);
        return permission;
    }

    @Override
    public void updatePermissionDetailsByPermissionId(String permissionId, Permission permission) throws Exception {
        pm.updatePermissionDetailsByPermissionId(permissionId,permission);
    }
}
