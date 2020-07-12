package com.robertx22.mine_and_slash.database.affixes.data;

import com.robertx22.mine_and_slash.database.StatModifier;
import com.robertx22.mine_and_slash.database.affixes.AffixBuilder;
import com.robertx22.mine_and_slash.database.affixes.ElementalAffixBuilder;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.AllAttributes;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.Dexterity;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.Intelligence;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.Strength;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalDamageBonus;
import com.robertx22.mine_and_slash.registry.ISlashRegistryInit;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.ModType;

import java.util.Arrays;

public class JewelrySuffixes implements ISlashRegistryInit {

    @Override
    public void registerAll() {

        ElementalAffixBuilder.start()
            .guid(x -> x.guidName + "_ele_dmg_jewelry")
            .add(Elements.Fire, "Of Embers")
            .add(Elements.Water, "Of Ice")
            .add(Elements.Thunder, "Of Electricity")
            .add(Elements.Nature, "Of Venom")
            .tier(1, x -> Arrays.asList(new StatModifier(15, 20, new ElementalDamageBonus(x), ModType.FLAT)))
            .tier(2, x -> Arrays.asList(new StatModifier(11, 15, new ElementalDamageBonus(x), ModType.FLAT)))
            .tier(3, x -> Arrays.asList(new StatModifier(7, 11, new ElementalDamageBonus(x), ModType.FLAT)))
            .tier(4, x -> Arrays.asList(new StatModifier(5, 7, new ElementalDamageBonus(x), ModType.FLAT)))
            .tier(5, x -> Arrays.asList(new StatModifier(2, 5, new ElementalDamageBonus(x), ModType.FLAT)))
            .Req(SlotRequirement.Of(GearItemSlot.SlotFamily.Jewelry))
            .Suffix()
            .Build();

        AffixBuilder.Normal("of_the_philosopher")
            .Named("Of the Philosopher")
            .tier(1, new StatModifier(7, 10, Intelligence.INSTANCE, ModType.FLAT))
            .tier(2, new StatModifier(5, 7, Intelligence.INSTANCE, ModType.FLAT))
            .tier(3, new StatModifier(3, 5, Intelligence.INSTANCE, ModType.FLAT))
            .Req(SlotRequirement.Of(GearItemSlot.SlotFamily.Jewelry))
            .Suffix()
            .Build();

        AffixBuilder.Normal("of_the_titan")
            .Named("Of the Titan")
            .tier(1, new StatModifier(7, 10, Strength.INSTANCE, ModType.FLAT))
            .tier(2, new StatModifier(5, 7, Strength.INSTANCE, ModType.FLAT))
            .tier(3, new StatModifier(3, 5, Strength.INSTANCE, ModType.FLAT))
            .Req(SlotRequirement.Of(GearItemSlot.SlotFamily.Jewelry))
            .Suffix()
            .Build();

        AffixBuilder.Normal("of_the_wind")
            .Named("Of the Wind")
            .tier(1, new StatModifier(7, 10, Dexterity.INSTANCE, ModType.FLAT))
            .tier(2, new StatModifier(5, 7, Dexterity.INSTANCE, ModType.FLAT))
            .tier(3, new StatModifier(3, 5, Dexterity.INSTANCE, ModType.FLAT))
            .Req(SlotRequirement.Of(GearItemSlot.SlotFamily.Jewelry))
            .Suffix()
            .Build();

        AffixBuilder.Normal("of_the_sky")
            .Named("Of the Sky")
            .tier(1, new StatModifier(6, 8, AllAttributes.getInstance(), ModType.FLAT))
            .tier(2, new StatModifier(4, 6, AllAttributes.getInstance(), ModType.FLAT))
            .tier(3, new StatModifier(2, 4, AllAttributes.getInstance(), ModType.FLAT))
            .tier(4, new StatModifier(1, 2, AllAttributes.getInstance(), ModType.FLAT))
            .Req(SlotRequirement.Of(GearItemSlot.SlotFamily.Jewelry))
            .Suffix()
            .Build();

    }
}