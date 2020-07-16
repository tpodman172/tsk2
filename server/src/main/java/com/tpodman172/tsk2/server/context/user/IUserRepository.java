package com.tpodman172.tsk2.server.context.user;

import java.util.Optional;

public interface IUserRepository {
    Optional<UserEntity> findByEmail(String email);

    void insert(UserEntity userEntity);
}