package com.pensatocode.example.client;

import com.pensatocode.example.model.Credentials;
import com.pensatocode.example.model.PersonalData;
import com.pensatocode.example.model.User;

import java.util.List;

public final class UserBootstrap {
    private UserBootstrap() {
        // Nothing to do
    }

    public static List<User> initUsers() {
        var users = new java.util.ArrayList<User>();
        var personalData1 = new PersonalData("John Doe", "john.doe@example.com");
        var credentials1 = new Credentials("jdoe", "123456");
        users.add(new User(1L, personalData1, credentials1));
        var personalData2 = new PersonalData("Jane Doe", "jane.doe@example.com");
        var credentials2 = new Credentials("janedoe", "123456");
        users.add(new User(2L, personalData2, credentials2));
        var personalData3 = new PersonalData("John Smith", "john.smith@example.com");
        var credentials3 = new Credentials("jsmith", "123456");
        users.add(new User(3L, personalData3, credentials3));
        return users;
    }
}
