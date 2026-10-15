package dev.crgl;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class CrGl implements ClientModInitializer {
	public void onInitializeClient() {
		Cfg.ld();
		KeyMapping k = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.crystalglow.open", InputConstants.KEY_U, KeyMapping.Category.register(Identifier.fromNamespaceAndPath("crystalglow", "main"))));
		ClientTickEvents.END_CLIENT_TICK.register(m -> {
			while (k.consumeClick()) if (m.screen == null) m.setScreen(CfgScr.mk(null));
		});
	}
}
