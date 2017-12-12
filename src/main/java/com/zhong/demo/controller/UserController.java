package com.zhong.demo.controller;

import com.zhong.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 用户控制器
 *
 * @author zhongqinghe
 * @create 2017/12/12 11:33
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    //创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> list = new ArrayList<>(UserController.users.values());
        return list;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUserList(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
