package com.hs.controller;

import com.hs.entiry.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 11:52
 **/

@Controller
@RequestMapping
public class UserController {
@RequestMapping("/login")
public String authentication(User user, HttpServletResponse response){
    Subject subject= SecurityUtils.getSubject();
    try{
        if(!subject.isAuthenticated()){
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            subject.login(usernamePasswordToken);
            response.sendRedirect("/getAll123");
            return "forward: getAll123";
        }
    }catch (UnknownAccountException uae) { //账号不存在
        throw new UnknownAccountException("账号不存在");
    } catch (IncorrectCredentialsException ice) {//密码不匹配
        throw new IncorrectCredentialsException("密码不匹配");
    } catch (LockedAccountException lae) {//账户锁定
        throw new LockedAccountException("账户锁定异常");
    } catch (ExcessiveAttemptsException ece) {
        throw new ExcessiveAttemptsException("多次登录锁定账号异常");
    } catch (AuthenticationException ae) { //认证异常
        throw new AuthenticationException("认证异常");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "error";
}

@RequestMapping("/getAll")
@ResponseBody
public List<User> getUser(Integer id){
    System.out.println(id);
    List<User> list=new ArrayList<>();
    User user=new User();
    user.setUsername("帅五地");
    user.setAge(18);
    User user1=new User();
    user1.setUsername("帅2");
    user1.setAge(20);
    list.add(user);
    list.add(user1);
    return list;
}
}
