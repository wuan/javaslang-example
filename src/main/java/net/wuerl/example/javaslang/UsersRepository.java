package net.wuerl.example.javaslang;

import javaslang.collection.List;
import net.wuerl.example.javaslang.data.User;
import net.wuerl.example.javaslang.data.ImmutableUser;

public class UsersRepository {

    public List<User> getUsers() {
        return List.of("Bernd Mustermann", "Daniela Musterfrau").map(this::createUser);
    }

    private User createUser(String name) {
        return ImmutableUser.builder().name(name).build();
    }

}
