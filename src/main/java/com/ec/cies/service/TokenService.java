package com.ec.cies.service;

import com.ec.cies.pojo.User;

public interface TokenService {
    String getToken(User user);
}
