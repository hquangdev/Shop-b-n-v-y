package com.example.authen_author.service;

import com.example.authen_author.config.KeycloakProvider;
import com.example.authen_author.entity.CreateUserRequest;


import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Service
public class KeycloakAdminClientService {
    //private final UserRepo userRepo;
    @Value("${keycloak.realm}")
    public String realm;

    private final KeycloakProvider kcProvider;


    public KeycloakAdminClientService(KeycloakProvider keycloakProvider) {
        this.kcProvider = keycloakProvider;
        //this.userRepo = userRepo;
    }

    public Response createKeycloakUser(CreateUserRequest user) {
        UsersResource usersResource = kcProvider.getInstance().realm(realm).users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());
        credentialRepresentation.setTemporary(false);
        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getUsername());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(user.getFirstname());
        kcUser.setLastName(user.getLastname());
        kcUser.setEmail(user.getEmail());
        kcUser.setEmailVerified(true);
        kcUser.setEnabled(true);

        Response response = usersResource.create(kcUser);

        if (response.getStatus() == 201) {
            //luu vao db

//            User localUser = new User();
//            localUser.setFirstName(kcUser.getFirstName());
//            localUser.setLastName(kcUser.getLastName());
//            localUser.setEmail(user.getEmail());
//            localUser.setCreatedDate(Timestamp.from(Instant.now()));
//            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
//            usersResource.get(userId).sendVerifyEmail();
//            userRepo.save(localUser);
        }

        return response;

    }

    private static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }

    public void updatePassword(String userId, String newPassword) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setTemporary(false);
        credential.setValue(newPassword);

        kcProvider.getInstance().realm(realm).users().get(userId).resetPassword(credential);
    }
    public String findUserIdByUsername(String username) {
        List<UserRepresentation> users = kcProvider.getInstance().realm(realm).users().search(username);
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return users.get(0).getId();
    }

    public void sendForgotPasswordEmail(String username) {
        List<UserRepresentation> users = kcProvider.getInstance()
                .realm(realm)
                .users()
                .search(username);

        if (users.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        String userId = users.get(0).getId();
        kcProvider.getInstance()
                .realm(realm)
                .users()
                .get(userId)
                .executeActionsEmail(List.of("UPDATE_PASSWORD"));
    }


    public UserRepresentation findUserByUsername(String username) {
        List<UserRepresentation> users = kcProvider.getInstance().realm(realm).users().search(username);
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public List<UserRepresentation> getAllUsers() {
        return kcProvider.getInstance().realm(realm).users().list();
    }


}
