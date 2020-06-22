package com.hs.mapper;

import com.hs.entiry.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 11:40
 **/
@Repository
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User getuser(User user);

    @Select("select r.rolename " +
            "from t_user u,t_user_role ur,t_role r " +
            "where u.id=ur.userid and ur.roleid=r.id and u.username=#{userName}")
    Set<String> queryRolesByUserName(String userName);

    @Select("select distinct m.menuname " +
            "from t_user u,t_user_role ur,t_role r,t_menu_role mr,t_menu m " +
            "where u.id=ur.userid and ur.roleid=r.id " +
            "and r.id=mr.roleid and mr.menuid=m.id " +
            "and u.username=#{userName}")
    Set<String> queryMenusByUserName(String userName);
}
