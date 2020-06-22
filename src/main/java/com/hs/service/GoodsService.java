package com.hs.service;

import com.hs.entiry.Goods;
import com.hs.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-01 21:27
 **/
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
   public List<Goods> getAll(){
        return goodsMapper.getAll();
    }
    public int update(Goods goods){
       if(goods.getId()!=null){
           return goodsMapper.update(goods);
        }else{
           return goodsMapper.save(goods);
       }
    }

    public int del(Integer id){
       return goodsMapper.del(id);
    }
    public List<Goods> query(String name){
       return goodsMapper.query(name);
    }

    public Goods queryById(Integer id){
       return goodsMapper.queryById(id);
    }
    public List<Map>gettype(){
       return goodsMapper.gettype();
    }
}
