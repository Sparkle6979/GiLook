package cou.dev.gibackend.service.impl;

import cou.dev.gibackend.interaction.UserInteractive;
import cou.dev.gibackend.model.dto.UserDTO;
import cou.dev.gibackend.model.sto.UserSTO;
import cou.dev.gibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/30 22:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInteractive userInteractive;
    @Override
    public UserDTO getUserByName(String name) {
        // TODO: 2024/10/31 补全校验
        UserSTO userByName = userInteractive.getUserByName(name);
        return UserDTO.builder().userName(userByName.getLogin()).build();
    }
}
