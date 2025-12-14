package com.example.examplemod.test;

import com.example.examplemod.ExampleMod;
import org.junit.jupiter.api.Test;

public class DasmTest {
    @Test
    public void testDasmApplication() {
        ExampleMod.src("SRC");
        ExampleMod.dst("DST");
    }
}
