package com.example.online_shopping_platform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TbManagerMapper {
    @Select("select count(*) from tb_manager where manager_id = #{id} and passwd = #{password}")
    int GetCountManager(int id, String password);

    @Insert("insert into tb_manager(manager_id, passwd) value (#{manager_id},#{passwd})")
    void InsertManager(int manager_id, String passwd);
}
