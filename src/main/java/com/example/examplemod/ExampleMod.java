package com.example.examplemod;

import io.github.notstirred.dasm.api.annotations.Dasm;

import io.github.notstirred.dasm.api.annotations.selector.Ref;
import io.github.notstirred.dasm.api.annotations.transform.TransformFromMethod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ExampleMod.MODID)
@Dasm({})
public class ExampleMod {
    public static final String MODID = "examplemod";

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        src("SRC");
        try {
            dst("DST");
            System.exit(0);
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Dasm Failure for DST");
            System.exit(1);
        }
    }

    public static void src(String text) {
        System.err.println("Dasm Success for " + text);
    }

    @TransformFromMethod(value = "src(Ljava/lang/String;)V", owner = @Ref(ExampleMod.class))
    public native static void dst(String text);
}
