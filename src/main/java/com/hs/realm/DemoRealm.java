package com.hs.realm;

import com.hs.entiry.User;
import com.hs.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 10:38
 **/
public class DemoRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> rolesList = userService.getRole(userName);
        Set<String> resource =userService.getResource(userName);
        info.setRoles(rolesList);
        info.setStringPermissions(resource);
        return info;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User all = userService.getAll(new User().setUsername(username));
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(all.getUsername(),all.getPassword(), ByteSource.Util.bytes(all.getUsername()),this.getName());
        return simpleAuthenticationInfo;
    }
}
