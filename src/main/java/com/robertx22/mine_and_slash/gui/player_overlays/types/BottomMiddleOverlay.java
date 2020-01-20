package com.robertx22.mine_and_slash.gui.player_overlays.types;

import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class BottomMiddleOverlay extends BasePlayerOverlay {

    @Override
    public void Draw(AbstractGui gui, Minecraft mc, LivingEntity entity, RenderGameOverlayEvent event, UnitData data) {
        Unit unit = data.getUnit();

        int offY = 12;
        int offY2 = 45;

        int height = mc.mainWindow.getScaledHeight();
        int width = mc.mainWindow.getScaledWidth();

        // ENERGY
        int x = width / 2 - this.TEXTURE_WIDTH * 2;
        int y = height - offY;

        this.DrawBar(mc, gui, energytexturepath, data.getCurrentEnergy(), unit.energyData().val, Type.ENE, data, x, y);

        // ENERGY

        // MANA
        x = width / 2 + this.TEXTURE_WIDTH;
        y = height - offY;
        this.DrawBar(mc, gui, manatexturepath, data.getCurrentMana(), unit.manaData().val, Type.MANA, data, x, y);
        // MANA

        // HEALTHs
        x = width / 2 - this.TEXTURE_WIDTH;
        y = height - offY2;

        this.DrawBar(
                mc, gui, healthtexturepath, unit.health().CurrentValue(entity, unit), unit.healthData().val, Type.HP,
                data, x, y
        );
        // HEALTH

        // EXP
        x = width / 2 + 5;
        y = height - offY2;

        this.DrawBar(
                mc, gui, experiencetexturepath, data.getExp(), data.GetExpRequiredForLevelUp(), Type.EXP, data, x, y);
        // EXP

    }

}
