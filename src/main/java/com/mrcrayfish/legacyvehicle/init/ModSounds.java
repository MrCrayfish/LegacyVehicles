package com.mrcrayfish.legacyvehicle.init;

import com.mrcrayfish.legacyvehicle.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: MrCrayfish
 */
public class ModSounds
{
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

    public static final RegistryObject<SoundEvent> ENTITY_BUMPER_CAR_ENGINE = register("entity.bumper_car.engine");
    public static final RegistryObject<SoundEvent> ENTITY_BUMPER_CAR_BONK = register("entity.bumper_car.bonk");
    public static final RegistryObject<SoundEvent> ENTITY_SPEED_BOAT_ENGINE = register("entity.speed_boat.engine");

    private static RegistryObject<SoundEvent> register(String id)
    {
        return ModSounds.REGISTER.register(id, () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, id)));
    }
}
