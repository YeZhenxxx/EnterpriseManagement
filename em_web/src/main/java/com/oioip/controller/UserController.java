package com.oioip.controller;

import com.github.pagehelper.PageInfo;
import com.oioip.domain.Role;
import com.oioip.domain.Status;
import com.oioip.domain.UserInfo;
import com.oioip.service.RoleService;
import com.oioip.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 *
 * 用户Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService us;
    @Resource(name = "roleService")
    private RoleService rs;

    /**
     * @Secured 注解表示允许哪些角色访问
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "4") Integer size){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> all = us.findAll(page, size);
        PageInfo pageInfo=new PageInfo(all);
        mv.addObject("userList",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findRolesAndPermissionByUserId")
    public ModelAndView findRolesAndPermissionByUserId(@Param("id") String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = us.findRolesAndPermissionByUserId(id);
        System.out.println(userInfo);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/save")
    @Secured("ROLE_ADMIN")
    public Status saveUser(UserInfo userInfo){
        Status status=new Status();
        try {
            us.saveUser(userInfo);
            status.setCode(200);
            status.setMessage("保存成功");
        } catch (Exception e) {
            status.setCode(500);
            status.setMessage("保存失败");
        }
        return status;
    }

    @RequestMapping("/findNoHaveRoleByUserId")
    public ModelAndView findNoHaveRoleByUserId(String userId){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = us.findUserByUserId(userId);
        List<Role> roles = rs.findUserNoHaveRoleByUserId(userInfo.getId());
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/findHaveRoleByUserId")
    public ModelAndView findHaveRoleByUserId(String userId){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        List<Role> roles = rs.findUserHaveRoleByUserId(userInfo.getId());
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-del");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/addRoleToUser")
    public Status addRoleToUser(@RequestParam(name = "ids") String[] roleIds,@RequestParam(name = "userId")String userId){
        Status status=new Status();
        try {
            rs.addRoleToUser(roleIds,userId);
            status.setCode(200);
            status.setMessage("添加角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setMessage("添加角色失败");
        }
        return status;
    }

    @ResponseBody
    @RequestMapping("/delRoleToUser")
    public Status delRoleToUser(@RequestParam("ids")String[] ids, @RequestParam("userId") String userId){
        Status status=new Status();
        try {
            rs.delRoleToUser(ids,userId);
            status.setCode(200);
            status.setMessage("删除角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("删除角色失败");
        }
        return status;
    }
}

