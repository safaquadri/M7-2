package com.cs2340.team6.totallyratticalapp;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import android.content.SharedPreferences;

/**
 * Created by squadri on 11/15/17.
 */

public class squadri6Test {

    String incorrect_un;
    String incorrect_pw;
    String correct_un;
    String correct_pw;

    @Before
    public void setUp() {
        incorrect_un = "bob";
        incorrect_pw = "bob";
        correct_un = "squadri";
        correct_pw = "123";

        CSVReader.addDummyUser(new User("Safa", correct_un, correct_pw, null));
    }

    @Test
    public void search_User_Exists() {
        assertTrue(CSVReader.userExists(correct_un, correct_pw));
    }

    @Test
    public void search_User_Does_Not_Exist() {
        assertFalse(CSVReader.userExists(incorrect_un, incorrect_pw));
    }
}
