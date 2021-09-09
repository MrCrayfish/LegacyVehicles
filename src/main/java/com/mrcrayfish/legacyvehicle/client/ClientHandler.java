package com.mrcrayfish.legacyvehicle.client;

import com.mrcrayfish.legacyvehicle.client.render.vehicle.*;
import com.mrcrayfish.legacyvehicle.init.ModEntities;
import com.mrcrayfish.vehicle.util.VehicleUtil;
import net.minecraftforge.fml.ModList;

/**
 * Author: MrCrayfish
 */
public class ClientHandler
{
    public static void setup()
    {
        setupVehicleRenders();
    }

    private static void setupVehicleRenders()
    {
        VehicleUtil.registerVehicleRenderer(ModEntities.DUNE_BUGGY.get(), DuneBuggyRenderer::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.SHOPPING_CART.get(), ShoppingCartRenderer::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.MINI_BIKE.get(), MiniBikeRenderer::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.BUMPER_CAR.get(), BumperCarModel::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.SPEED_BOAT.get(), SpeedBoatRenderer::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.ALUMINUM_BOAT.get(), AluminumBoatRenderer::new);
        VehicleUtil.registerVehicleRenderer(ModEntities.SMART_CAR.get(), SmartCarRenderer::new);

        if(ModList.get().isLoaded("cfm"))
        {
            VehicleUtil.registerVehicleRenderer(ModEntities.SOFA.get(), SofaCarRenderer::new);
            VehicleUtil.registerVehicleRenderer(ModEntities.BATH.get(), BathModel::new);
        }
    }
}
