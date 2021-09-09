package com.mrcrayfish.legacyvehicle.client.render.vehicle;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrcrayfish.legacyvehicle.client.model.SpecialModels;
import com.mrcrayfish.legacyvehicle.entity.vehicle.BumperCarEntity;
import com.mrcrayfish.legacyvehicle.init.ModEntities;
import com.mrcrayfish.vehicle.client.raytrace.MatrixTransform;
import com.mrcrayfish.vehicle.client.raytrace.RayTraceTransforms;
import com.mrcrayfish.vehicle.client.raytrace.TransformHelper;
import com.mrcrayfish.vehicle.client.render.AbstractLandVehicleRenderer;
import com.mrcrayfish.vehicle.client.render.Axis;
import com.mrcrayfish.vehicle.entity.properties.PoweredProperties;
import com.mrcrayfish.vehicle.entity.properties.VehicleProperties;
import com.mrcrayfish.vehicle.util.RenderUtil;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nullable;

/**
 * Author: MrCrayfish
 */
public class BumperCarModel extends AbstractLandVehicleRenderer<BumperCarEntity>
{
    public BumperCarModel(VehicleProperties defaultProperties)
    {
        super(defaultProperties);
    }

    @Override
    protected void render(@Nullable BumperCarEntity vehicle, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, float partialTicks, int light)
    {
        //Render body
        this.renderDamagedPart(vehicle, SpecialModels.BUMPER_CAR_BODY.getModel(), matrixStack, renderTypeBuffer, light);

        //Render the handles bars
        matrixStack.pushPose();
        matrixStack.translate(0, 0.2, 0);
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(-45F));
        matrixStack.translate(0, -0.02, 0);
        matrixStack.scale(0.9F, 0.9F, 0.9F);

        float wheelAngle = this.wheelAngleProperty.get(vehicle, partialTicks);
        float maxSteeringAngle = this.vehiclePropertiesProperty.get(vehicle).getExtended(PoweredProperties.class).getMaxSteeringAngle();
        float steeringWheelRotation = (wheelAngle / maxSteeringAngle) * 15F;
        matrixStack.mulPose(Axis.POSITIVE_Y.rotationDegrees(steeringWheelRotation));

        RenderUtil.renderColoredModel(com.mrcrayfish.vehicle.client.model.SpecialModels.GO_KART_STEERING_WHEEL.getModel(), ItemCameraTransforms.TransformType.NONE, false, matrixStack, renderTypeBuffer, this.colorProperty.get(vehicle), light, OverlayTexture.NO_OVERLAY);

        matrixStack.popPose();
    }

    @Override
    public void applyPlayerModel(BumperCarEntity entity, PlayerEntity player, PlayerModel model, float partialTicks)
    {
        model.rightLeg.xRot = (float) Math.toRadians(-85F);
        model.rightLeg.yRot = (float) Math.toRadians(10F);
        model.leftLeg.xRot = (float) Math.toRadians(-85F);
        model.leftLeg.yRot = (float) Math.toRadians(-10F);

        float wheelAngle = this.wheelAngleProperty.get(entity, partialTicks);
        float maxSteeringAngle = this.vehiclePropertiesProperty.get(entity).getExtended(PoweredProperties.class).getMaxSteeringAngle();
        float steeringWheelRotation = (wheelAngle / maxSteeringAngle) * 15F / 2F;
        model.rightArm.xRot = (float) Math.toRadians(-65F - steeringWheelRotation);
        model.rightArm.yRot = (float) Math.toRadians(-7F);
        model.leftArm.xRot = (float) Math.toRadians(-65F + steeringWheelRotation);
        model.leftArm.yRot = (float) Math.toRadians(7F);
    }

    @Nullable
    @Override
    public RayTraceTransforms getRayTraceTransforms()
    {
        return (entityRayTracer, transforms, parts) ->
        {
            TransformHelper.createTransformListForPart(SpecialModels.BUMPER_CAR_BODY, parts, transforms);
            TransformHelper.createTransformListForPart(com.mrcrayfish.vehicle.client.model.SpecialModels.GO_KART_STEERING_WHEEL, parts, transforms,
                    MatrixTransform.translate(0.0F, 0.2F, 0.0F),
                    MatrixTransform.rotate(Axis.POSITIVE_X, -45F),
                    MatrixTransform.translate(0.0F, -0.02F, 0.0F),
                    MatrixTransform.scale(0.9F));
            TransformHelper.createFuelFillerTransforms(ModEntities.BUMPER_CAR.get(), com.mrcrayfish.vehicle.client.model.SpecialModels.FUEL_DOOR_CLOSED, parts, transforms);
        };
    }
}
