package com.mrcrayfish.legacyvehicle.client.model;

import com.mrcrayfish.legacyvehicle.Reference;
import com.mrcrayfish.vehicle.client.model.ISpecialModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum SpecialModels implements ISpecialModel
{
    DUNE_BUGGY_BODY("dune_buggy_body"),
    DUNE_BUGGY_HANDLES("dune_buggy_handles"),
    SHOPPING_CART_BODY("shopping_cart_body"),
    MINI_BIKE_BODY("mini_bike_body"),
    MINI_BIKE_HANDLES("mini_bike_handles"),
    BUMPER_CAR_BODY("bumper_car_body"),
    SPEED_BOAT_BODY("speed_boat_body"),
    ALUMINUM_BOAT_BODY("aluminum_boat_body"),
    SMART_CAR_BODY("smart_car_body"),

    /* Mod dependent models */
    RAINBOW_SOFA(new ModelResourceLocation("cfm:rainbow_sofa", "inventory"), false);

    /**
     * The location of an item model in the [MOD_ID]/models/vehicle/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Determines if the model should be loaded as a special model
     */
    private final boolean specialModel;

    /**
     * Cached model
     */
    @OnlyIn(Dist.CLIENT)
    private IBakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    SpecialModels(String modelName)
    {
        this(new ResourceLocation(Reference.MOD_ID, "vehicle/" + modelName), true);
    }

    /**
     * Sets the model's location
     *
     * @param resource name of the model file
     */
    SpecialModels(ResourceLocation resource, boolean specialModel)
    {
        this.modelLocation = resource;
        this.specialModel = specialModel;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public IBakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            IBakedModel model = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
            if(model == Minecraft.getInstance().getModelManager().getMissingModel())
            {
                return model;
            }
            this.cachedModel = model;
        }
        return this.cachedModel;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void register(ModelRegistryEvent event)
    {
        for(SpecialModels model : values())
        {
            if(model.specialModel)
            {
                ModelLoader.addSpecialModel(model.modelLocation);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void clearModelCache()
    {
        for(SpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }
}
