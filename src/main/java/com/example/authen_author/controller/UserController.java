package com.example.authen_author.controller;

import com.example.authen_author.config.KeycloakProvider;
import com.example.authen_author.entity.CreateUserRequest;
import com.example.authen_author.entity.ForgotPassword;
import com.example.authen_author.entity.LoginRequest;
import com.example.authen_author.entity.UpdatePassword;

import com.example.authen_author.service.KeycloakAdminClientService;
import jakarta.validation.constraints.NotNull;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private KeycloakAdminClientService kcAdminClient;

    @Autowired
    private KeycloakProvider kcProvider;

//    @Autowired
//    private UserRepo userRepo;

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(UserController.class);


//    public UserController(KeycloakAdminClientService kcAdminClient, KeycloakProvider kcProvider) {
//        this.kcProvider = kcProvider;
//        this.kcAdminClient = kcAdminClient;
//    }


    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest user) {
        Response createdResponse = kcAdminClient.createKeycloakUser(user);
        int statusCode = createdResponse.getStatus();
        if (statusCode == 201) {
            return ResponseEntity.status(201).body("Tạo tài khoản thành công cho user: " + user.getUsername());
        } else {
            return ResponseEntity.status(statusCode).body("Tạo tài khoản thất bại. Mã lỗi: " + statusCode);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@NotNull @RequestBody LoginRequest loginRequest) {
        try (Keycloak keycloak = kcProvider.newKeycloakBuilderWithPasswordCredentials(
                loginRequest.getUsername(), loginRequest.getPassword()).build()) {

            AccessTokenResponse accessTokenResponse = keycloak.tokenManager().getAccessToken();
            return ResponseEntity.ok(accessTokenResponse);

        } catch (BadRequestException ex) {
            String errorDetail = ex.getResponse().readEntity(String.class);
            LOG.warn("Login failed: {}", errorDetail);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Đăng nhập thất bại: " + errorDetail);
        } catch (Exception ex) {
            LOG.error("Unexpected error during login", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi không xác định khi đăng nhập.");
        }
    }


    @PostMapping("/update")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePassword updatePassword) {
        try {
            String userId = kcAdminClient.findUserIdByUsername(updatePassword.getUsername());
            kcAdminClient.updatePassword(userId, updatePassword.getNewPassword());
            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update password: " + e.getMessage());
        }
    }


    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPassword forgotPassword) {
        String username = forgotPassword.getUsername();
        try {
            kcAdminClient.sendForgotPasswordEmail(username);
            return ResponseEntity.ok("Reset password email sent to user.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error: " + e.getMessage());
        }
    }

/// /demo
    // LẤY THÔNG TIN USER THEO USERNAME
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        UserRepresentation user = kcAdminClient.findUserByUsername(username);
        return user != null
                ? ResponseEntity.ok(user)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy user: " + username);
    }

    // LẤY DANH SÁCH TOÀN BỘ USER
    @GetMapping
    public ResponseEntity<List<UserRepresentation>> getAllUsers() {
        List<UserRepresentation> users = kcAdminClient.getAllUsers();
        return ResponseEntity.ok(users);
    }



}

