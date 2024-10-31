package cou.dev.gibackend.controller;

import cou.dev.gibackend.model.dto.UserDTO;
import cou.dev.gibackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/30 22:01
 */
@Api(tags = "个人信息页")
@RequestMapping(value = "/person")
@RestController
public class PersonController {
    @Autowired
    private UserService userService;

    @ApiOperation("根据名称获取用户信息")
    @GetMapping("/{name}")
    public ResponseEntity<UserDTO> getUserInfoByName(@PathVariable String name) {
        UserDTO userByName = userService.getUserByName(name);
        return ResponseEntity.ok(userByName);
    }

}
