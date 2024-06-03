package com.dtopiast.venus.core.service.auth;

import com.dtopiast.venus.domain.user.model.User;

public interface ITokenService {
    public String getSubject(String token);
    String getToken(User user);

}
