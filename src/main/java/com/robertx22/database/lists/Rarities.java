package com.robertx22.database.lists;

import java.util.Arrays;
import java.util.List;

import com.robertx22.classes.MobRarity;
import com.robertx22.classes.Rarity;
import com.robertx22.database.rarities.general.Common;
import com.robertx22.database.rarities.general.Epic;
import com.robertx22.database.rarities.general.Legendary;
import com.robertx22.database.rarities.general.Mythical;
import com.robertx22.database.rarities.general.Rare;
import com.robertx22.database.rarities.general.Uncommon;
import com.robertx22.database.rarities.mobs.Boss;
import com.robertx22.database.rarities.mobs.Champion;
import com.robertx22.database.rarities.mobs.Elite;
import com.robertx22.database.rarities.mobs.Normal;
import com.robertx22.database.rarities.mobs.Veteran;
import com.robertx22.database.rarities.mobs.WorldBoss;

public class Rarities {

	List<Rarity> All = Arrays.asList(new Common(), new Uncommon(), new Rare(), new Epic(), new Legendary(),
			new Mythical());

	List<MobRarity> Mobs = Arrays.asList(new Normal(), new Veteran(), new Elite(), new Champion(), new Boss(),
			new WorldBoss());

}