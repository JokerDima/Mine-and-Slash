package com.robertx22.mine_and_slash.database.spells.spell_classes.nova;

import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.DamageData;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.EffectCalculation;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.SpellEffectDamage;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalResist;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ElementalParticleUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.SoundUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.Utilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;

public abstract class BaseNovaSpell extends BaseSpell {

    public float scaling = 0.5F;
    public double radius = 4;

    @Override
    public int useTimeTicks() {
        return 15;
    }

    @Override
    public SpellType getSpellType() {
        return SpellType.Aoe_Damage_Nova;
    }

    @Override
    public int getManaCost() {
        return 25;
    }

    @Override
    public int getBaseValue() {
        return 10;
    }

    @Override
    public ITextComponent GetDescription(SpellItemData data) {
        return CLOC.tooltip("aoe_spell_nova");

    }

    @Override
    public EffectCalculation ScalingValue() {
        return new EffectCalculation(new ElementalResist(this.getElement()), scaling);
    }

    @Override
    public boolean cast(PlayerEntity caster, int ticksInUse, SpellItemData data) {
        World world = caster.world;

        if (!world.isRemote) {

            ElementalParticleUtils.SpawnNovaParticle(this.getElement(), caster, radius, 200);

            List<LivingEntity> list = Utilities.getEntitiesWithinRadius(radius, 2, caster, LivingEntity.class);

            for (int i = 0; i < list.size(); ++i) {
                LivingEntity entity1 = list.get(i);

                if (Load.hasUnit(entity1) && entity1 != caster) {

                    entity1.playSound(SoundEvents.ENCHANT_THORNS_HIT, 0.7F, 0);

                    SpellEffectDamage effect = new SpellEffectDamage(this.getElement());
                    effect.Activate(new DamageData(caster, data), entity1);

                }

            }

        }

        SoundUtils.playSoundAtPlayer(caster, SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);

        return true;
    }

}
