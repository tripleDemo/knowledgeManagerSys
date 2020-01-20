package com.huashang.core.mapper;

import com.huashang.core.pojo.Users;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    Users selectByPrimaryKey(String userId);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
    
    int updateUserPassword(@Param("email") String email, @Param("encryptPwd") String encryptPwd);
    
    Users selectByUsername(String username);
    
    List<Users> likeByUsername(@Param("start") Long start, @Param("pageSize") Integer pageSize, @Param("username") String username);
}