package net.wuerl.example.javaslang.collections;

import javaslang.collection.List;
import net.wuerl.example.javaslang.data.User;
import net.wuerl.example.javaslang.data.ImmutableUser;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test
    public void createsImmutableList() {
        final List<String> list = List.of("foo", "bar");

        assertThat(list).containsExactly("foo", "bar");
    }

    @Test
    public void createModifiedImmutableList() {
        final List<String> list = List.of("foo", "bar");
        final List<String> updatedList = list.append("baz");

        assertThat(updatedList).containsExactly("foo", "bar", "baz");
    }

    @Test
    public void mapListElements() {
        List<User> users = List.of(
                ImmutableUser.builder().name("foo").build(),
                ImmutableUser.builder().name("far").build()
                );

        assertThat(users.map(User::name)).containsExactly("foo", "far");

        assertThat(users.forAll(user -> user.name().startsWith("f"))).isTrue();
    }
}
