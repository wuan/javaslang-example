package net.wuerl.example.javaslang.collections;

import net.wuerl.example.javaslang.data.User;
import net.wuerl.example.javaslang.data.ImmutableUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaListTest {

    @Test
    public void throwsWhenAddingElementToUnmodifiableList() {
        final List<String> list = Arrays.asList("foo", "bar");

        assertThatThrownBy(
                () -> list.add("baz")
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void createsImmutableList() {
        final List<String> list = Arrays.asList("foo", "bar");

        assertThat(list).containsExactly("foo", "bar");
    }

    @Test
    public void createModifiedImmutableList() {
        final List<String> list = Arrays.asList("foo", "bar");

        final ArrayList<String> modifiableUpdatedList = new ArrayList<>(list);
        modifiableUpdatedList.add("baz");
        final List<String> updatedList = Collections.unmodifiableList(modifiableUpdatedList);

        assertThat(updatedList).containsExactly("foo", "bar", "baz");
    }

    @Test
    public void mapListElements() {
        List<User> users = Arrays.asList(ImmutableUser.builder().name("foo").build());

        final List<String> userNames = users.stream().map(User::name).collect(Collectors.toList());
    }
}
