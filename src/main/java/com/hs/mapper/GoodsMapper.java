package com.hs.mapper;

import com.hs.entiry.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: 彭于晏
 * @create: 2020-04-01 21:27
 **/
@Repository
public interface GoodsMapper {
@Select("select g.*,gt.typename from good g join  goodtype gt on g.typeid=gt.id")
List<Goods> getAll();

@Update("update  good set name=#{name},number=#{number},price=#{price},date=#{date},typeid=#{typeid} where id=#{id}")
int update(Goods goods);
@Insert("insert into good (name,number,price,date,typeid) values (#{name},#{number},#{price},#{date},#{typeid})")
int save(Goods goods);
@Delete("delete from good where id=#{id}")
int del(Integer id);
    @Select("select g.*,gt.typename from good g join  goodtype gt on g.typeid=gt.id where g.name like '%${name}%' or g.id='%${name}%'")
    List<Goods>query(String name);
    @Select("select * from good where id=#{id}")
    Goods queryById(Integer id);
    @Select("select * from goodtype")
    List<Map>gettype();
}
