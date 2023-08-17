package com.asif.backend.controller;

import com.asif.backend.common.Routes.ApiConstants;
import com.asif.backend.common.Routes.Router;
import com.asif.backend.payload.request.UserRequestDto;
import com.asif.backend.payload.response.UserResponseDto;
import com.asif.backend.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = ApiConstants.USER)
public class UserController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(Router.CREATE_USER)
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) {
        logger.info("User create api Hit");
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
    }
}
