package com.equipatour.coreservice.core.profilemanagement.service;

import com.equipatour.coreservice.core.profilemanagement.beans.UserBean;
import com.equipatour.coreservice.core.profilemanagement.dao.UserDAO;
import com.equipatour.coreservice.core.profilemanagement.model.User;
import com.equipatour.coreservice.shared.base.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
public class UserService extends BaseService<User, UserBean> {

    @Autowired
    private UserDAO userRepository;

    @Override
    public UserBean toBean(User model, Class<UserBean> modelClass) {
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(model, bean);
        // bean.setAgency(model.getAgency().getId());
        return bean;
    }

    public List<UserBean> getAllUsers() {
        List<UserBean> list = new ArrayList<>();
        List<User> users =  userRepository.findAll();

        for (User user : users) {
            list.add(toBean(user, UserBean.class));
        }

        return list;
    }

    public UserBean getById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("User %s not found", userId));
        }

        return toBean(userOptional.get(), UserBean.class);
    }

    public void createUser(UserBean userBean) {
        userRepository.save(toModel(userBean, User.class));
    }

    public void updateUser(Long userId, UserBean userBean) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("User %s not found", userId));
        }

        userRepository.save(toModel(userBean, User.class));
    }

    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("User %s not found", userId));
        }

        userRepository.delete(userOptional.get());
    }
}
