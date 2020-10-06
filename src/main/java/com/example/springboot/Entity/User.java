package com.example.springboot.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {

//    private Integer id;

    @NotNull(message = "名字不能为空")
    private String name;

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String phone;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Min(18)
    private Integer age;


}