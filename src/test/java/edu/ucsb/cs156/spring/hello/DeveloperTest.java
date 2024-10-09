package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Alvin", Developer.getName());
    }

    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("alvinwang1", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f24-04", t.getName());
        assertTrue(t.getMembers().contains("Alvin"),"Team should contain Alvin");
        assertTrue(t.getMembers().contains("Michael"),"Team should contain Michael");
        assertTrue(t.getMembers().contains("Jackie"),"Team should contain Jackie");
        assertTrue(t.getMembers().contains("Nikhil"),"Team should contain Nikhil");
        assertTrue(t.getMembers().contains("Piyush"),"Team should contain Piyush");
        assertTrue(t.getMembers().contains("Nilay"),"Team should contain Nilay");

    }

}
