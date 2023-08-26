package com.pensatocode.example.client;

import com.pensatocode.example.model.Credential;
import com.pensatocode.example.model.PersonalData;
import com.pensatocode.example.model.User;
import com.pensatocode.example.services.SecretKeyGenerator;

import java.util.List;

public final class UserBootstrap {
    private UserBootstrap() {
        // Nothing to do
    }

    public static List<User> initUsers(SecretKeyGenerator secretKeyGenerator) {
        var users = new java.util.ArrayList<User>();
        var personalData1 = new PersonalData("Alex Pensato", "alex.pensato@example.com");
        var secretKey1 = secretKeyGenerator.generateKey();
        var credentials1 = new Credential("alex", secretKey1);
        users.add(new User(1L, personalData1, credentials1));
        var personalData2 = new PersonalData("Jane Doe", "jane.doe@example.com");
        var secretKey2 = secretKeyGenerator.generateKey();
        var credentials2 = new Credential("janedoe", secretKey2);
        users.add(new User(2L, personalData2, credentials2));
        var personalData3 = new PersonalData("Mark Smith", "mark.smith@example.com");
        var secretKey3 = secretKeyGenerator.generateKey();
        var credentials3 = new Credential("mrsmith", secretKey3);
        users.add(new User(3L, personalData3, credentials3));
        return users;
    }
}
