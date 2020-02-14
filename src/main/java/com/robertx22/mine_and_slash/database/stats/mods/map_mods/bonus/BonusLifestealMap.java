package com.robertx22.mine_and_slash.database.stats.mods.map_mods.bonus;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.resources.Lifesteal;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class BonusLifestealMap extends StatMod {

    public BonusLifestealMap() {
    }

    @Override
    public String GUID() {
        return "bonus_lifesteal_map";
    }

    @Override
    public float Min() {
        return 15;
    }

    @Override
    public float Max() {
        return 40;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Flat;
    }

    @Override
    public Stat GetBaseStat() {
        return Lifesteal.getInstance();
    }

}