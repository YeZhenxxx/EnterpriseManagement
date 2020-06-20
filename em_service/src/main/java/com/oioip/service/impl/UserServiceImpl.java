package com.oioip.service.impl;

import com.github.pagehelper.PageHelper;
import com.oioip.domain.Role;
import com.oioip.domain.UserInfo;
import com.oioip.mapper.RoleMapper;
import com.oioip.mapper.UserMapper;
import com.oioip.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 * 用户登录接口
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    private UserMapper um;

    @Resource(name = "bCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 根据用户名查找用户  username有前端页面提供
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo loginUser = um.findByUserName(username);
        User user=new User(loginUser.getUsername(),loginUser.getPassword(),loginUser.getStatus()==0?false:true,true,true,true,getAuthority(loginUser));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(UserInfo userInfo){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : userInfo.getRoles()) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<UserInfo> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<UserInfo> all = um.findAll();
        return all;
    }

    @Override
    public UserInfo findRolesAndPermissionByUserId(String id) {
        UserInfo byId = um.findRolesAndPermissionByUserId(id);
        return byId;
    }

    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        //对密码进行加密,该类会自动动态生成盐值参与加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        um.saveUser(userInfo);
    }

    @Override
    public UserInfo findUserByUserId(String userId) {
        UserInfo userByUserId = um.findUserByUserId(userId);
        return userByUserId;
    }

}
