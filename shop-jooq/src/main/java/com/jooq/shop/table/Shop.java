/*
 * This file is generated by jOOQ.
 */
package com.jooq.shop.table;


import com.generator.Demo;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.ShopRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Shop extends TableImpl<ShopRecord> {

    private static final long serialVersionUID = 1679871121;

    /**
     * The reference instance of <code>demo.shop</code>
     */
    public static final Shop SHOP = new Shop();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ShopRecord> getRecordType() {
        return ShopRecord.class;
    }

    /**
     * The column <code>demo.shop.id</code>.
     */
    public final TableField<ShopRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>demo.shop.shop_name</code>.
     */
    public final TableField<ShopRecord, String> SHOP_NAME = createField(DSL.name("shop_name"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>demo.shop.desc</code>.
     */
    public final TableField<ShopRecord, String> DESC = createField(DSL.name("desc"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>demo.shop.remark</code>.
     */
    public final TableField<ShopRecord, String> REMARK = createField(DSL.name("remark"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>demo.shop.create_time</code>.
     */
    public final TableField<ShopRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>demo.shop.price</code>.
     */
    public final TableField<ShopRecord, BigDecimal> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.DECIMAL(10, 2), this, "");

    /**
     * Create a <code>demo.shop</code> table reference
     */
    public Shop() {
        this(DSL.name("shop"), null);
    }

    /**
     * Create an aliased <code>demo.shop</code> table reference
     */
    public Shop(String alias) {
        this(DSL.name(alias), SHOP);
    }

    /**
     * Create an aliased <code>demo.shop</code> table reference
     */
    public Shop(Name alias) {
        this(alias, SHOP);
    }

    private Shop(Name alias, Table<ShopRecord> aliased) {
        this(alias, aliased, null);
    }

    private Shop(Name alias, Table<ShopRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Shop(Table<O> child, ForeignKey<O, ShopRecord> key) {
        super(child, key, SHOP);
    }

    @Override
    public Schema getSchema() {
        return Demo.DEMO;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SHOP_PRIMARY);
    }

    @Override
    public Identity<ShopRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SHOP;
    }

    @Override
    public UniqueKey<ShopRecord> getPrimaryKey() {
        return Keys.KEY_SHOP_PRIMARY;
    }

    @Override
    public List<UniqueKey<ShopRecord>> getKeys() {
        return Arrays.<UniqueKey<ShopRecord>>asList(Keys.KEY_SHOP_PRIMARY);
    }

    @Override
    public Shop as(String alias) {
        return new Shop(DSL.name(alias), this);
    }

    @Override
    public Shop as(Name alias) {
        return new Shop(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Shop rename(String name) {
        return new Shop(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Shop rename(Name name) {
        return new Shop(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, LocalDateTime, BigDecimal> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}