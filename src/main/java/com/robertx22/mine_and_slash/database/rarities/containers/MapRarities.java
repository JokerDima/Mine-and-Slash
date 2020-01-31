package com.robertx22.mine_and_slash.database.rarities.containers;

import com.robertx22.mine_and_slash.database.rarities.BaseRaritiesContainer;
import com.robertx22.mine_and_slash.database.rarities.MapRarity;
import com.robertx22.mine_and_slash.database.rarities.maps.*;

public class MapRarities extends BaseRaritiesContainer<MapRarity> {

    public MapRarities() {
        super();
        add(CommonMap.getInstance());
        add(UncommonMap.getInstance());
        add(RareMap.getInstance());
        add(EpicMap.getInstance());
        add(LegendaryMap.getInstance());
        add(MythicalMap.getInstance());

        this.onInit();
    }

}
