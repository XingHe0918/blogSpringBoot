package com.example.blogspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogspringboot.model.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
