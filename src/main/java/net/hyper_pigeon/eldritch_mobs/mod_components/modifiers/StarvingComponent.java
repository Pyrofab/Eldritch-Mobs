package net.hyper_pigeon.eldritch_mobs.mod_components.modifiers;

import net.hyper_pigeon.eldritch_mobs.EldritchMobsMod;
import net.hyper_pigeon.eldritch_mobs.mod_components.interfaces.ModifierInterface;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.CompoundTag;

public class StarvingComponent implements ModifierInterface {
    private final static long cooldown = 300;
    private long nextAbilityUse = 0L;
    @Override
    public void useAbility(MobEntity entity) {
        if(entity.getTarget()!= null && entity.canSee(entity.getTarget()) && entity.getTarget().isAlive()) {
            long time = entity.getEntityWorld().getTime();
            if (time > nextAbilityUse) {
                nextAbilityUse = time + cooldown;
                LivingEntity target = entity.getTarget();

                if(EldritchMobsMod.CONFIG.intensity <= 1){
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 250, 0));
                }
                else if(EldritchMobsMod.CONFIG.intensity == 2){
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 275, 0));
                }
                else {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0));
                }
            }
        }
    }

    @Override
    public void setRank() {

    }

    @Override
    public void setMods() {

    }

    @Override
    public boolean hasMod(String name) {
        return false;
    }

    @Override
    public void damageActivatedMod(LivingEntity entity, DamageSource source, float amount) {

    }

    @Override
    public boolean isEldritch() {
        return false;
    }

    @Override
    public String get_mod_string() {
        return null;
    }

    @Override
    public boolean isElite() {
        return false;
    }

    @Override
    public boolean isUltra() {
        return false;
    }

    @Override
    public void setIs_elite(boolean bool) {

    }

    @Override
    public void setIs_ultra(boolean bool) {

    }

    @Override
    public void setIs_eldritch(boolean bool) {

    }

    @Override
    public void spawnedInLampChunk() {

    }

    @Override
    public void readFromNbt(CompoundTag compoundTag) {

    }

    @Override
    public void writeToNbt(CompoundTag compoundTag) {

    }
}
