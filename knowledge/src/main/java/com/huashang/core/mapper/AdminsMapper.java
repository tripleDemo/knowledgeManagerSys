package com.huashang.core.mapper;

import com.huashang.core.pojo.Admins;
import java.util.List;

public interface AdminsMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admins record);

    Admins selectByPrimaryKey(String adminId);
    
    Admins selectByUsername(String username);

    List<Admins> selectAll();

    int updateByPrimaryKey(Admins record);
}