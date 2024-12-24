package de.m_marvin.playernbt.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.commands.data.DataAccessor;
import net.minecraft.server.commands.data.EntityDataAccessor;
import net.minecraft.world.entity.Entity;

@Debug(export = true)
@Mixin(EntityDataAccessor.class)
public abstract class EntityDataAccessorMixin implements DataAccessor {
	
	@Shadow
    private Entity entity;
	
	@Override
    public void setData(CompoundTag other) throws CommandSyntaxException {
        UUID uuid = this.entity.getUUID();
        this.entity.load(other);
        this.entity.setUUID(uuid);
    }
	
}
