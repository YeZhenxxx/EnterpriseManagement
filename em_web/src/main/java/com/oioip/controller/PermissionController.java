package com.oioip.controller;

import com.oioip.domain.Permission;
import com.oioip.domain.Role;
import com.oioip.domain.Status;
import com.oioip.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 *
 * 权限 访问层
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Resource(name = "permissionService")
    private PermissionService ps;


    @RequestMapping("/findAll")
    public ModelAndView findAllPermission(){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissions = ps.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/QueryNoHavePermissionByRoleId")
    public ModelAndView queryNoHavePermission(@RequestParam("roleId") String roleId){
        ModelAndView mv=new ModelAndView();
        Role role=new Role();
        role.setId(roleId);
        List<Permission> permissions = ps.queryNoHavePermissionByRoleId(roleId);
        mv.addObject("role",role);
        mv.addObject("permissions",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/QueryHavePermissionByRoleId")
    public ModelAndView queryHavePermission(@RequestParam("roleId") String roleId){
        ModelAndView mv=new ModelAndView();
        Role role=new Role();
        role.setId(roleId);
        List<Permission> permissions = ps.queryHavePermissionByRoleId(roleId);
        mv.addObject("role",role);
        mv.addObject("permissions",permissions);
        mv.setViewName("role-permission-del");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/addPermission")
    public Status addPermission(Permission permission){
        Status status=new Status();
        try {
            ps.addPermission(permission);
            status.setCode(200);
            status.setMessage("添加权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("添加权限失败");
        }
        return status;
    }

    @RequestMapping("/delPermissionByPermissionId")
    public void delPermission(@RequestParam("permissionId") String permissionId, HttpServletRequest req, HttpServletResponse resp){
        try {
            ps.delPermissionByPermissionId(permissionId);
            resp.sendRedirect(req.getSession().getServletContext().getContextPath()+"/permission/findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryPermissionDetail")
    public ModelAndView queryPermissionDetailByPermissionId(@RequestParam("permissionId")String permissionId){
        ModelAndView mv=new ModelAndView();
        Permission permission = ps.queryPermissionDetailsByPermissionId(permissionId);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/updatePermissionDetails")
    public Status updatePermissionDetailsByPermissionId(@RequestParam("permissionId")String permissionId,Permission permission){
        Status status=new Status();
        try {
            ps.updatePermissionDetailsByPermissionId(permissionId,permission);
            status.setCode(200);
            status.setMessage("更新权限信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("更新权限信息失败");
        }
        return status;
    }


}
