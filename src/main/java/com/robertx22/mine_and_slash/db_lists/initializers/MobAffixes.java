package com.robertx22.mine_and_slash.db_lists.initializers;

import com.robertx22.mine_and_slash.database.affixes.Affix;
import com.robertx22.mine_and_slash.database.mob_affixes.base.MobAffix;
import com.robertx22.mine_and_slash.database.stats.types.generated.WeaponDamage;
import com.robertx22.mine_and_slash.registry.ISlashRegistryInit;
import com.robertx22.mine_and_slash.saveclasses.ExactStatData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.ModType;

import java.util.ArrayList;
import java.util.List;

public class MobAffixes implements ISlashRegistryInit {

    public static MobAffix EMPTY = new MobAffix("empty", "empty", Affix.Type.prefix);

    public static MobAffix COLD = new MobAffix("cold", "Cold", Affix.Type.prefix).setMods(new ExactStatData(5, ModType.FLAT, new WeaponDamage(Elements.Water)));
    public static MobAffix FLAMING = new MobAffix("flaming", "Flaming", Affix.Type.prefix).setMods(new ExactStatData(5, ModType.FLAT, new WeaponDamage(Elements.Fire)));
    public static MobAffix LIGHTNING = new MobAffix("lightning", "Lightning", Affix.Type.prefix).setMods(new ExactStatData(5, ModType.FLAT, new WeaponDamage(Elements.Thunder)));
    public static MobAffix VENOMOUS = new MobAffix("venom", "Venomous", Affix.Type.prefix).setMods(new ExactStatData(5, ModType.FLAT, new WeaponDamage(Elements.Nature)));

    public static MobAffix OF_RUIN = new MobAffix("of_ruin", "Of Ruin", Affix.Type.suffix).setMods(new ExactStatData(5, ModType.FLAT, new WeaponDamage(Elements.Physical)));

    @Override
    public void registerAll() {

        List<MobAffix> all = new ArrayList<>();

        all.add(COLD);
        all.add(FLAMING);
        all.add(LIGHTNING);
        all.add(VENOMOUS);

        all.add(OF_RUIN);

        all.forEach(x -> x.addToSerializables());

    }
}
