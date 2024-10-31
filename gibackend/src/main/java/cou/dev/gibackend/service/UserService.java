package cou.dev.gibackend.service;

import cou.dev.gibackend.model.dto.UserDTO;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/30 22:07
 */
public interface UserService {
    UserDTO getUserByName(String name);
}
