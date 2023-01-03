package com.destinerikanb.javavalidation.service;

import com.destinerikanb.javavalidation.constraints.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    //validasi cross parameter
    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2
    )
    public void register(
            @NotBlank(message = "username cannot be blank") String username, //0
            @NotBlank(message = "password cannot be blank") String password, //1
            @NotBlank(message = "retypePassword cannot be blank") String retypePassword //2
    ){
        //TODO REGISTER
    }
}
