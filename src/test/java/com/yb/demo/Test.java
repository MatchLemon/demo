package com.yb.demo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int       initialCapacity =3;
        System.out.println((initialCapacity >>> 1));
        LoadingCache<String,String> cahceBuilder= CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue="hello "+key+"!";
                        return strProValue;
                    }
                });
        try {
            cahceBuilder.get("12",()->{
                return "asd";
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CacheBuilder.newBuilder()
                .expireAfterWrite(100, TimeUnit.DAYS).
    build();

        LoadingCache<String,String> cahceBuilder1 = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue="hello "+key+"!";
                        return strProValue;
                    }
                });
        List<String> ll = new ArrayList<>();

        ll.stream().distinct().collect(Collectors.toList());
    }
}
