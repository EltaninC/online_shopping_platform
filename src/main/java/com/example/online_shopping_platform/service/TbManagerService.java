package com.example.online_shopping_platform.service;

public interface TbManagerService {
    public boolean hasMatchAdmin(int uid, String password);
    public void InsertManager(int manager_id, String passwd);
}
