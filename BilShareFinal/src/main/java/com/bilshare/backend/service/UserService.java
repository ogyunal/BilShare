package com.bilshare.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.bilshare.backend.entity.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bilshare.backend.entity.User;
import com.bilshare.backend.repository.UserRepository;

@Service
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    public static final String MODIFY_LOCKED_USER_NOT_PERMITTED = "User has been locked and cannot be modified or deleted";
    private static final String DELETING_SELF_NOT_PERMITTED = "You cannot delete your own account";

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public Page<User> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return getRepository()
                    .findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
                            repositoryFilter, repositoryFilter, repositoryFilter, repositoryFilter, pageable);
        } else {
            return find(pageable);
        }
    }*/

    public long count() {
        return userRepository.count();
    }

    public UserRepository getRepository() {
        return userRepository;
    }

    /*public Page<User> find(Pageable pageable) {
        return getRepository().findBy(pageable);
    }*/

    public void save(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        //newUser.setLocked(true);
        userRepository.save(newUser);
    }

    public User createNew(User currentUser) {
        return new User();
    }



    public User findByLogin (String username,String password)
    {
        return userRepository.findByLogin(username,password);
    }

}