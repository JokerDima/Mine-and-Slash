package com.robertx22.mine_and_slash.database.spells.synergies.ember_mage;

import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.configs.PreCalcSpellConfigs;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.configs.SC;
import com.robertx22.mine_and_slash.database.spells.spell_classes.ember_mage.VolcanoSpell;
import com.robertx22.mine_and_slash.database.spells.synergies.OnDamageDoneSynergy;
import com.robertx22.mine_and_slash.potion_effects.bases.PotionEffectUtils;
import com.robertx22.mine_and_slash.potion_effects.ember_mage.BurnEffect;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.saveclasses.spells.AbilityPlace;
import com.robertx22.mine_and_slash.saveclasses.spells.IAbility;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.effectdatas.SpellDamageEffect;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.RandomUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class VolcanoBurnSynergy extends OnDamageDoneSynergy {

    @Override
    public String GUID() {
        return "volcano_burn_synergy";
    }

    @Override
    public List<ITextComponent> getSynergyTooltipInternal(TooltipInfo info) {
        List<ITextComponent> list = new ArrayList<>();

        addSpellName(list);

        list.add(new StringTextComponent("Chance to apply debuff"));

        list.addAll(BurnEffect.INSTANCE.GetTooltipString(info));

        return list;
    }

    @Override
    public PreCalcSpellConfigs getConfigsAffectingSpell() {
        PreCalcSpellConfigs c = new PreCalcSpellConfigs();
        c.set(SC.MANA_COST, 1, 2);
        return c;
    }

    @Override
    public PreCalcSpellConfigs getPreCalcConfig() {
        PreCalcSpellConfigs c = new PreCalcSpellConfigs();
        c.set(SC.CHANCE, 5, 50);
        c.setMaxLevel(6);
        return c;
    }

    @Override
    public AbilityPlace getAbilityPlace() {
        return AbilityPlace.upFrom(VolcanoSpell.getInstance());
    }

    @Nullable
    @Override
    public IAbility getRequiredAbility() {
        return VolcanoSpell.getInstance();
    }

    @Override
    public void tryActivate(SpellDamageEffect effect) {

        float chance = getContext(effect.source).getConfigFor(this)
            .get(SC.CHANCE)
            .get(Load.spells(effect.source), this);

        if (RandomUtils.roll(chance)) {
            PotionEffectUtils.apply(BurnEffect.INSTANCE, effect.source, effect.target);
        }
    }
}