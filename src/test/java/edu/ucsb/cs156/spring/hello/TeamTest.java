package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean() {
        team = new Team("test-team");
        Team test = team;
        assertEquals(true, test.equals(team));

        assertEquals(false, team.equals(1));

        Team test_Contents = new Team("test-team");
        team.addMember("test1");
        team.addMember("test2");
        team.addMember("test3");
        team.addMember("test4");
        team.addMember("test5");

        test_Contents.addMember("test1");
        test_Contents.addMember("test2");
        test_Contents.addMember("test3");
        test_Contents.addMember("test4");
        test_Contents.addMember("test5");
        // name is equal, contents are equal
        assertEquals(true, team.equals(test_Contents));

        // name is not equal, contents are equal
        test_Contents.setName("test-team1");
        assertEquals(false, team.equals(test_Contents));

        // name is equal, contents are not equal
        test_Contents.setName("test-team");
        test_Contents.setMembers(null);
        assertEquals(false, team.equals(test_Contents));

        // name is not equal, contents are not equal
        test_Contents.setName("test-team1");
        assertEquals(false, team.equals(test_Contents));

    }

    @Test
    public void hashCode_returns_correct_boolean() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

}
