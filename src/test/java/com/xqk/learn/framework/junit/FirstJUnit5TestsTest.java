package com.xqk.learn.framework.junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstJUnit5TestsTest {

    @Test
    void add() {
        assertEquals(2, 1 + 1);
    }
}