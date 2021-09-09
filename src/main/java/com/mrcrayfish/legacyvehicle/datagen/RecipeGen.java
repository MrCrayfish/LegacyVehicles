package com.mrcrayfish.legacyvehicle.datagen;

import com.mrcrayfish.legacyvehicle.init.ModEntities;
import com.mrcrayfish.vehicle.crafting.FluidEntry;
import com.mrcrayfish.vehicle.crafting.WorkstationIngredient;
import com.mrcrayfish.vehicle.datagen.FluidExtractorRecipeBuilder;
import com.mrcrayfish.vehicle.datagen.FluidMixerRecipeBuilder;
import com.mrcrayfish.vehicle.datagen.WorkstationRecipeBuilder;
import com.mrcrayfish.vehicle.entity.VehicleEntity;
import com.mrcrayfish.vehicle.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Author: MrCrayfish
 */
public class RecipeGen extends RecipeProvider
{
    public RecipeGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        workstationCrafting(consumer, ModEntities.ALUMINUM_BOAT.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 80), WorkstationIngredient.of(ModItems.PANEL.get(), 10));
        workstationCrafting(consumer, ModEntities.BUMPER_CAR.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 36), WorkstationIngredient.of(Items.REDSTONE, 8), WorkstationIngredient.of(ModItems.PANEL.get(), 8));
        workstationCrafting(consumer, ModEntities.DUNE_BUGGY.get(), WorkstationIngredient.of(Items.YELLOW_CONCRETE, 8), WorkstationIngredient.of(Items.BLUE_CONCRETE, 4), WorkstationIngredient.of(Items.RED_CONCRETE, 2));
        workstationCrafting(consumer, ModEntities.MINI_BIKE.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 24), WorkstationIngredient.of(Items.BLACK_WOOL, 2));
        workstationCrafting(consumer, ModEntities.SHOPPING_CART.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 8), WorkstationIngredient.of(Items.IRON_BARS, 4));
        workstationCrafting(consumer, ModEntities.SMART_CAR.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 80), WorkstationIngredient.of(Items.BLACK_WOOL, 8), WorkstationIngredient.of(Tags.Items.GLASS_PANES, 6), WorkstationIngredient.of(Items.REDSTONE, 8), WorkstationIngredient.of(ModItems.PANEL.get(), 16));
        workstationCrafting(consumer, ModEntities.SPEED_BOAT.get(), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 80), WorkstationIngredient.of(Items.BLACK_WOOL, 8), WorkstationIngredient.of(Tags.Items.GLASS_PANES, 4), WorkstationIngredient.of(ModItems.PANEL.get(), 10));

        dependantWorkstationCrafting(consumer, "cfm", new ResourceLocation("legacyvehicle:bath"), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 80), WorkstationIngredient.of(ModItems.PANEL.get(), 10));
        dependantWorkstationCrafting(consumer, "cfm", new ResourceLocation("legacyvehicle:sofa"), WorkstationIngredient.of(new ResourceLocation("cfm:rainbow_sofa"), 1), WorkstationIngredient.of(Tags.Items.INGOTS_IRON, 8));

    }

    private static void workstationCrafting(Consumer<IFinishedRecipe> consumer, EntityType<? extends VehicleEntity> type, WorkstationIngredient ... materials)
    {
        ResourceLocation entityId = Objects.requireNonNull(type.getRegistryName());
        WorkstationRecipeBuilder.crafting(entityId, Arrays.asList(materials)).save(consumer, new ResourceLocation(entityId.getNamespace(), entityId.getPath() + "_crafting"));
    }

    private static void dependantWorkstationCrafting(Consumer<IFinishedRecipe> consumer, String modId, ResourceLocation entityId, WorkstationIngredient ... materials)
    {
        WorkstationRecipeBuilder.crafting(entityId, Arrays.asList(materials)).addCondition(new ModLoadedCondition(modId)).save(consumer, new ResourceLocation(entityId.getNamespace(), entityId.getPath() + "_crafting"));
    }
}
