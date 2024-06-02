package com.equipatour.coreservice.core.profilemanagement.service;

import com.equipatour.coreservice.core.profilemanagement.beans.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean> getAllUsers();

    UserBean getById(Long userId);

    void createUser(UserBean userBean);

    void updateUser(Long userId, UserBean userBean);

    void deleteUser(Long userId);
}
