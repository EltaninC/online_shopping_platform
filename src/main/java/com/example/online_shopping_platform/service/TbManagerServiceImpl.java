package com.example.online_shopping_platform.service;

import com.example.online_shopping_platform.mapper.TbManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbManagerServiceImpl implements TbManagerService{
    @Autowired
    TbManagerMapper tbManagerMapper;
    @Override
    public boolean hasMatchAdmin(int uid, String password) {
        return tbManagerMapper.GetCountManager(uid, password) == 1;
    }

    @Override
    public void InsertManager(int manager_id, String passwd) {
        tbManagerMapper.InsertManager(manager_id,passwd);
    }
}
