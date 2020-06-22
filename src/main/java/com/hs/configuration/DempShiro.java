package com.hs.configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hs.realm.DemoRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 配置shiro
 * @author: 彭于晏
 * @create: 2020-04-03 10:32
 **/
@Configuration
public class DempShiro {
//    首先是需要一个安全管理器 bean
    @Bean
    public DefaultWebSecurityManager webSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(demoRealm()); //需要注入一个realm
        return defaultWebSecurityManager;
    }

//   一个Realm实例 bean
    @Bean
    public DemoRealm demoRealm(){
        DemoRealm demoRealm=new DemoRealm();
        //注入密码匹配器
        demoRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return demoRealm;
    }
    //密码匹配器
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        //setStoredCredentialsHexEncoded true为16进制编码，false 为base64
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }
    @Bean
    public LifecycleBeanPostProcessor postProcessor(){

        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator autoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor advisor(){
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(webSecurityManager());
        return advisor;
    }

//安全管理过滤器
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean() {
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(webSecurityManager());
        factoryBean.setLoginUrl("/login.html");
        factoryBean.setSuccessUrl("/index.html");
        factoryBean.setUnauthorizedUrl("/error.html");

        //要过滤的路径的Map集合
        Map<String,String> map=new HashMap<>();
        map.put("/user/login","anon");
        map.put("/static/**","anon");
        map.put("/*.jar","anon");
        map.put("/logout","logout");
        map.put("/**","authc");

        factoryBean.setFilterChainDefinitionMap(map);

        return factoryBean;

    }


    /**
     * 这个是thymeleaf页面使用的shiro标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}

