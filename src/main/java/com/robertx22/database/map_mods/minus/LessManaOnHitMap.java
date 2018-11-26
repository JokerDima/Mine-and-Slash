package com.robertx22.database.map_mods.minus;

import com.robertx22.database.stats.types.resources.ManaOnHit;
import com.robertx22.stats.Stat;
import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public class LessManaOnHitMap extends StatMod {

	public LessManaOnHitMap() {
	}

	@Override
	public String GUID() {
		return "LessManaOnHitMap";
	}

	@Override
	public int Min() {
		return -30;
	}

	@Override
	public int Max() {
		return -80;
	}

	@Override
	public StatTypes Type() {
		return StatTypes.Multi;
	}

	@Override
	public Stat GetBaseStat() {
		return new ManaOnHit();
	}

}