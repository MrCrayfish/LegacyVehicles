package com.mrcrayfish.legacyvehicle.entity.vehicle;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish
 */
public class BumperCarEntity extends LandVehicleEntity
{
    public BumperCarEntity(EntityType<? extends BumperCarEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.maxUpStep = 0.625F;
        //TODO figure out fuel system
    }

    @Override
    public void push(Entity entityIn)
    {
        if(entityIn instanceof BumperCarEntity && this.isVehicle())
        {
            applyBumperCollision((BumperCarEntity) entityIn);
        }
    }

    private void applyBumperCollision(BumperCarEntity entity)
    {
        //TODO reapply bump collision
        /*this.setDeltaMovement(this.getDeltaMovement().add(this.vehicleMotionX * 2, 0, this.vehicleMotionZ * 2));
        level.playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.ENTITY_BUMPER_CAR_BONK.get(), SoundCategory.NEUTRAL, 1.0F, 0.6F + 0.1F * this.getNormalSpeed());
        this.currentSpeed *= 0.25F;*/
    }

}
