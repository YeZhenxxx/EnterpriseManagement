package com.oioip.service.impl;

import com.oioip.domain.Role;
import com.oioip.mapper.RoleMapper;
import com.oioip.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 * 角色业务层实现类
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleMapper")
    private RoleMapper rm;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        List<Role> allRole = rm.findAllRole();
        return allRole;
    }

    @Override
    public List<Role> findUserNoHaveRoleByUserId(String userId) {
        List<Role> roles = rm.findUserNoHaveRoleByUserId(userId);
        return roles;
    }

    @Override
    public void addRoleToUser(String[] roleIds,String userId) throws Exception {
        for (String roleId : roleIds) {
            rm.addRoleToUser(roleId,userId);
        }
    }

    @Override
    public void saveRole(Role role) throws Exception {
        rm.saveRole(role);
    }

    @Override
    public void delRoleByRoleId(String roleId) throws Exception {
        rm.deleteRoleByRoleId(roleId);
    }

    @Override
    public List<Role> queryRolesByPermissionId(String permissionId) {
        List<Role> roles = rm.queryRolesByPermissionId(permissionId);
        return roles;
    }

    @Override
    public Role queryRoleDetailsByRoleId(String roleId) {
        Role role = rm.queryRoleDetailsByRoleId(roleId);
        return role;
    }

    @Override
    public void addPermissionToRoleByPermissionIdAndRoleId(String[] permissionId, String roleId)throws Exception {
        for (String pid : permissionId) {
            rm.addPermissionToRoleByPermissionIdAndRoleId(pid,roleId);
        }
    }

    @Override
    public void delPermissionToRoleByPermissionIdAndRoleId(String[] permissionId, String roleId) throws Exception {
        for (String pid : permissionId) {
            rm.delPermissionToRoleByPermissionIdAndRoleId(pid,roleId);
        }
    }

    @Override
    public List<Role> findUserHaveRoleByUserId(String userId) {
        List<Role> roles = rm.findUserHaveRoleByUserId(userId);
        return roles;
    }

    @Override
    public void delRoleToUser(String[] roleId, String userId) throws Exception {
        for (String id : roleId) {
            rm.delRoleToUser(id,userId);
        }
    }

    @Override
    public void updateRoleDetailsByRoleId(String roleId, Role role)throws Exception {
        rm.updateRoleDetailsByRoleId(roleId,role);
    }
}
