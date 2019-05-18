package com.stopysinger.core.zuul.controller;

import com.stopysinger.core.zuul.exception.ResourceNotFoundException;
import com.stopysinger.core.zuul.model.User;
import com.stopysinger.core.zuul.repository.UserRepository;
import com.stopysinger.core.zuul.security.CurrentUser;
import com.stopysinger.core.zuul.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
