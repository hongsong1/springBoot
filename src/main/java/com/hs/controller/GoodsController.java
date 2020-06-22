package com.hs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entiry.Goods;
import com.hs.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-01 21:28
 **/
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/getAll123")
    public PageInfo<Goods>  getAll(String name,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsServiceAll=null;
        if(name==""||name==null){

            goodsServiceAll= goodsService.getAll();
        }else{
            goodsServiceAll=goodsService.query(name);
        }
        PageInfo<Goods> info=new PageInfo<>(goodsServiceAll);

//        System.out.println(goods.getName());
//        if(index!=null){
//            Goods goods = goodsService.queryById(index);
//            map.put("goods",goods);
//        }else{
//        Goods goods=new Goods();
//        map.put("goods",goods);
//        }
//
//        map.put("goodslist",goodsServiceAll);
        return info;
    }

    @RequestMapping("/del")
    public Integer del(Integer id){

        return goodsService.del(id);
    }
    @RequestMapping("/update")
    public String update(@RequestBody Goods goods){
        System.out.println(goods);
        goodsService.update(goods);
        return "forward:/getAll123";
    }

    @RequestMapping("/query")
    public String update(String name,Map map){
        map.put("goodslist",goodsService.query(name));
//        Goods goods=new Goods();
        Goods goods=new Goods();
        map.put("goods",goods);
        return "goods";
    }
    @RequestMapping("/getType")
    public List<Map> getType(){
        return goodsService.gettype();
    }
}
