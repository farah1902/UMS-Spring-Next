package com.saadfarah.user_mngt_system_back.service;

import com.saadfarah.user_mngt_system_back.entity.UserEntity;
import com.saadfarah.user_mngt_system_back.model.User;
import com.saadfarah.user_mngt_system_back.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities
                = userRepository.findAll();

        List<User> users = userEntities
                .stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmail()
                ))

                .toList();
/*                .collect(Collectors.toList());*/

        return users;
    }

    @Override
    public User getUserById(Long id) {

        UserEntity userEntity
                = userRepository.findById(id).get();

        User user = new User();
        BeanUtils.copyProperties(userEntity, user);

        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public User updateUser(Long id, User user) {

        UserEntity userEntity =
                userRepository.findById(id).get();

        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        userRepository.save(userEntity);

        return user;
    }


}
