package com.example.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserConfig {
    private final Map<String, User> users;

	public UserConfig(List<User> users) {
        this.users = new LinkedHashMap<>();
        Map<String, List<User>> userListMap = users.stream().collect(Collectors.groupingBy(User::getLogin));
        userListMap.forEach((name, userList) -> this.users.put(name, userList.get(0)));
    }

    public String loginFor(String username) {
        return this.users.get(username).getLogin();
    }

    public String passwordFor(String username) {
        return this.users.get(username).getPassword();
    }
}
