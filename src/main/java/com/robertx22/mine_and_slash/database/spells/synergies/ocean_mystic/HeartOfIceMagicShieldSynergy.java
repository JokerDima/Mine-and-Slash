package com.robertx22.mine_and_slash.database.spells.synergies.ocean_mystic;

import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.spells.spell_classes.ocean_mystic.HeartOfIceSpell;
import com.robertx22.mine_and_slash.database.spells.synergies.Synergy;
import com.robertx22.mine_and_slash.database.spells.synergies.ctx.BeforeHealContext;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalSpellDamage;
import com.robertx22.mine_and_slash.saveclasses.ResourcesData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.saveclasses.spells.SpellCalcData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.List;

public class HeartOfIceMagicShieldSynergy extends Synergy<BeforeHealContext> {

    @Override
    public String GUID() {
        return "heart_of_ice_magic_shield_synergy";
    }

    public static SpellCalcData CALC = SpellCalcData.one(new ElementalSpellDamage(Elements.Water), 1F, 5);

    @Override

    public List<ITextComponent> GetTooltipString(TooltipInfo info) {
        List<ITextComponent> list = new ArrayList<>();

        addSpellName(list);

        list.add(new StringTextComponent("Heals magic shield too"));

        list.addAll(CALC.GetTooltipString(info));

        return list;
    }

    @Override
    public BaseSpell spellAffected() {
        return HeartOfIceSpell.getInstance();
    }

    @Override
    public void tryActivate(BeforeHealContext ctx) {

        ResourcesData.Context heal = new ResourcesData.Context(ctx.casterData, ctx.caster,
                                                               ResourcesData.Type.MAGIC_SHIELD,
                                                               CALC.getCalculatedValue(ctx.casterData),
                                                               ResourcesData.Use.RESTORE, spellAffected()
        );

        Load.Unit(ctx.target).modifyResource(heal);
    }
}