package mod.kagic.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GUIWarpPadContainer extends Container {

	public GUIWarpPadContainer() {
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}