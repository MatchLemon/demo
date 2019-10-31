package com.yb.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
@Mapper
public interface UserDao extends BaseMapper<User> {
}
