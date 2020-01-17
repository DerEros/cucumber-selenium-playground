package com.example.config;

import java.util.List;

import com.example.config.BrowserConfig;

public class Configuration {
    private BrowserConfig browser;
    private List<User> users;
    private UserConfig userConfig;

    public void setBrowser(BrowserConfig browserConfig) { this.browser = browserConfig; }
    public BrowserConfig getBrowser() { return this.browser; }

    public void setUsers(List<User> users) { 
        this.users = users;
        this.userConfig = new UserConfig(users);
    }
    public List<User> getUsers() { return this.users; }
    public UserConfig getUserConfig() { return this.userConfig; }
}
