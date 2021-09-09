package com.mrcrayfish.legacyvehicle;

import com.mrcrayfish.legacyvehicle.client.ClientHandler;
import com.mrcrayfish.legacyvehicle.datagen.RecipeGen;
import com.mrcrayfish.legacyvehicle.datagen.VehiclePropertiesGen;
import com.mrcrayfish.legacyvehicle.init.ModEntities;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Author: MrCrayfish
 */
@Mod(Reference.MOD_ID)
public class LegacyVehicleMod
{
    public LegacyVehicleMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.REGISTER.register(eventBus);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::onGatherData);
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {
        ClientHandler.setup();
    }

    private void onGatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new RecipeGen(generator));
        generator.addProvider(new VehiclePropertiesGen(generator));
    }
}
