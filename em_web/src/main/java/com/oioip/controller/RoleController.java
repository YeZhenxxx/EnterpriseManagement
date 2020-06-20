package com.oioip.controller;

import com.oioip.domain.Role;
import com.oioip.domain.Status;
import com.oioip.service.RoleService;
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
 * 角色Controller
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource(name = "roleService")
    private RoleService rs;

    @RequestMapping("/findAll")
    public ModelAndView findAllRole(){
        ModelAndView mv=new ModelAndView();
        List<Role> allRole = rs.findAllRole();
        mv.addObject("roleList",allRole);
        mv.setViewName("role-list");
        return mv;
    }


    @ResponseBody
    @RequestMapping("/save")
    public Status saveRole(Role role){
        Status status=new Status();
        try {
            rs.saveRole(role);
            status.setCode(200);
            status.setMessage("添加角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("添加角色失败");
        }
        return status;
    }

    @RequestMapping("/deleteRoleByRoleId")
    public void deleteRoleByRoleId(@RequestParam("roleId") String roleId, HttpServletRequest req, HttpServletResponse resp){
        try {
            rs.delRoleByRoleId(roleId);
            resp.sendRedirect(req.getSession().getServletContext().getContextPath()+"/role/findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/roleDetails")
    public ModelAndView queryRoleDetails(@RequestParam("roleId") String roleId){
        ModelAndView mv=new ModelAndView();
        Role role = rs.queryRoleDetailsByRoleId(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }


    @ResponseBody
    @RequestMapping("/addPermissionToRole")
    public Status addPermissionToRole(@RequestParam("pids") String[] permissionId,@RequestParam("roleId") String roleId){
        Status status=new Status();
        try {
            rs.addPermissionToRoleByPermissionIdAndRoleId(permissionId,roleId);
            status.setCode(200);
            status.setMessage("添加权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("添加权限失败");
        }
        return status;
    }

    @ResponseBody
    @RequestMapping("/delPermissionToRole")
    public Status delPermissionToRole(@RequestParam("pids") String[] permissionId,@RequestParam("roleId") String roleId){
        Status status=new Status();
        try {
            rs.delPermissionToRoleByPermissionIdAndRoleId(permissionId,roleId);
            status.setCode(200);
            status.setMessage("删除权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("删除权限失败");
        }
        return status;
    }

    @ResponseBody
    @RequestMapping("/updateRoleDetails")
    public Status updateRoleDetailsByRoleId(@RequestParam("roleId")String roleId,Role role){
        Status status=new Status();
        try {
            rs.updateRoleDetailsByRoleId(roleId,role);
            status.setCode(200);
            status.setMessage("更新角色信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("更新角色信息失败");
        }
        return status;
    }

}
