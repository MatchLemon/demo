package com.jooq.shop.controller;

import com.jooq.shop.table.Shop;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopController {
    @Autowired
    DSLContext dsl;
    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/getShop")
    @ResponseBody
    public Map getList() {
        List<com.jooq.shop.enity.Shop> result =  dsl.select().from(Shop.SHOP).fetchInto(com.jooq.shop.enity.Shop.class);
        Map map = new HashMap();
        map.put("code", "1");
        map.put("data", result);
        return map;
    }

    @RequestMapping(value = "/getShopById")
    @ResponseBody
    public Object getShopById(String id){
        DSLContext dsl = DSL.using(dataSource, SQLDialect.MYSQL);
        Result<Record> result =  dsl.select().from(DSL.table("user")).where("id=" + id).limit(1).fetch();
        return result.get(0).intoMap();
    }

    /**
     * insert table
     * @param shop
     * @return
     */
    @RequestMapping(value = "/saveShop")
    @ResponseBody
    public Map save(com.jooq.shop.enity.Shop shop) {
        int i = dsl.newRecord(Shop.SHOP,shop).insert();

        Map map = new HashMap();
        map.put("code", "1");
        map.put("data", i);
        return map;
    }
    @RequestMapping(value = "/get-shop")
    @ResponseBody
    public Map query() {
        DSL.field("id").eq(1);
      Object[] result = dsl.select(DSL.field("u.id"), DSL.field("u.user_name")
                ,DSL.field("s.shop_name")
        ).from(DSL.table("user").as("u")).leftJoin(DSL.table("shop").as("s")).on("u.id=s.id")
                .fetch().map(item->item.intoMap()).toArray();
        Map map = new HashMap();
        map.put("code", "1");
        map.put("result", result);


        Object[] result2 =  dsl.fetch("select * from user").map(item->item.intoMap()).toArray();
        map.put("result2", result2);

        return  map;
    }

}
