package com.example.springboot.Controller;

import com.example.springboot.Entity.User;
import com.example.springboot.POJO.ResultBean;
import com.example.springboot.Service.impl.UserServiceImpl;
import com.example.springboot.config.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private Resource resource;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        System.out.println("1");
        return "hello,world";
    }


    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println("你好");
        return resource.getEmailServe();
    }

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {

        return userService.getById(id);
    }

//    @RequestMapping("/addUser")
//    @ResponseBody
//    public ResultBean addUserById(@Valid User user, BindingResult bindingResult) throws JsonProcessingException {
//        if (bindingResult.hasErrors()) {
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            //保存错误信息
//            Map<String, String> result = new HashMap<String, String>();
//            for (FieldError fieldError : fieldErrors) {
//                String message = fieldError.getDefaultMessage();
//                String filed = fieldError.getField();
//                log.error("[{}]:[{}]", filed, message);
//                result.put(filed, message);
//            }
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = objectMapper.writeValueAsString(result);
//            return new ResultBean("faild",json);
//
//        }
//
//        log.info("模拟用户添加成功");
//        return new ResultBean("success","OK");
//    }

    @RequestMapping("/addUser" )
    @ResponseBody
    public ResultBean addUserById(@Valid User user) {
        System.out.println(user);

        log.info("用户实现模拟添加");
        return new ResultBean("susses","ok");
    }
}
