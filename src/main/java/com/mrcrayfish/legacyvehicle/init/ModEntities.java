package com.mrcrayfish.legacyvehicle.init;

import com.mrcrayfish.legacyvehicle.Reference;
import com.mrcrayfish.legacyvehicle.entity.vehicle.AluminumBoatEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.BathEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.BumperCarEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.CouchEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.DuneBuggyEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.MiniBikeEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.ShoppingCartEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.SmartCarEntity;
import com.mrcrayfish.legacyvehicle.entity.vehicle.SpeedBoatEntity;
import com.mrcrayfish.vehicle.util.VehicleUtil;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: MrCrayfish
 */
public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);

    public static final RegistryObject<EntityType<DuneBuggyEntity>> DUNE_BUGGY = VehicleUtil.createEntityType(REGISTER, "dune_buggy", DuneBuggyEntity::new, 0.75F, 0.75F);
    public static final RegistryObject<EntityType<ShoppingCartEntity>> SHOPPING_CART = VehicleUtil.createEntityType(REGISTER, "shopping_cart", ShoppingCartEntity::new, 1.0F, 1.0F);
    public static final RegistryObject<EntityType<MiniBikeEntity>> MINI_BIKE = VehicleUtil.createEntityType(REGISTER, "mini_bike", MiniBikeEntity::new, 1.0F, 1.0F);
    public static final RegistryObject<EntityType<BumperCarEntity>> BUMPER_CAR = VehicleUtil.createEntityType(REGISTER, "bumper_car", BumperCarEntity::new, 1.5F, 1.0F);
    public static final RegistryObject<EntityType<SpeedBoatEntity>> SPEED_BOAT = VehicleUtil.createEntityType(REGISTER, "speed_boat", SpeedBoatEntity::new, 1.5F, 1.0F);
    public static final RegistryObject<EntityType<AluminumBoatEntity>> ALUMINUM_BOAT = VehicleUtil.createEntityType(REGISTER, "aluminum_boat", AluminumBoatEntity::new, 2.25F, 0.875F);
    public static final RegistryObject<EntityType<SmartCarEntity>> SMART_CAR = VehicleUtil.createEntityType(REGISTER, "smart_car", SmartCarEntity::new, 1.85F, 1.15F);

    public static final RegistryObject<EntityType<CouchEntity>> SOFA = VehicleUtil.createModDependentEntityType(REGISTER, "cfm", "couch", CouchEntity::new, 1.0F, 1.0F, true);
    public static final RegistryObject<EntityType<BathEntity>> BATH = VehicleUtil.createModDependentEntityType(REGISTER, "cfm", "bath", BathEntity::new, 1.0F, 1.0F, false);
}
