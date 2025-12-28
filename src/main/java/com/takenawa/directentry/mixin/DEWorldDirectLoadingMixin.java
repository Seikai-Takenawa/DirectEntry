package com.takenawa.directentry.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldOpenFlows.class)
public class DEWorldDirectLoadingMixin {
    @Inject(
            method = "confirmWorldCreation",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void forceLoadWorld(Minecraft minecraft, CreateWorldScreen screen, Lifecycle lifecycle, Runnable loadWorld, boolean skipWarnings, CallbackInfo ci) {
        loadWorld.run();
        ci.cancel();
    }

    @Redirect(
            method = "openWorldCheckWorldStemCompatibility",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/levelgen/WorldOptions;isOldCustomizedWorld()Z")
    )
    private static boolean isOldCustomizedWorld(WorldOptions worldOptions) {
        return false;
    }

    @Redirect(
            method = "openWorldCheckWorldStemCompatibility",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/storage/WorldData;worldGenSettingsLifecycle()Lcom/mojang/serialization/Lifecycle;")
    )
    private static Lifecycle worldGenSettingsLifecycle(WorldData instance) {
        return Lifecycle.stable();
    }
}
