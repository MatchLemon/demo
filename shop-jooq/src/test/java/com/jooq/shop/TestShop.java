package com.jooq.shop;

import com.generator.tables.Shop;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ShopApplication.class})
public class TestShop {
    com.generator.tables.Shop s =  Shop.SHOP.as("s");
    @Autowired
    DSLContext dsl;
    @Test
    public void testInsert() {
        //DSL.using();//
     List ll = dsl.select(Shop.SHOP.DESC).from(Shop.SHOP).fetch();
     dsl.insertInto(Shop.SHOP);
        dsl.insertInto(Shop.SHOP)

                .columns(s.SHOP_NAME,s.DESC,s.PRICE).values("rice","象形", BigDecimal.valueOf(123)).execute();
    }


}
