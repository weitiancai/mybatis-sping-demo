package com.example.controller;


import com.example.dao.UserDOMapper;
import com.example.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserDOMapper userDOMapper;
    @GetMapping("/login")
    public UserDO loginExample(@RequestParam("id") Integer id){
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return userDO;
    }
}
