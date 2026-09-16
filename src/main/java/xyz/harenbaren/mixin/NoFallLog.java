package xyz.harenbaren.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerGamePacketListenerImpl.class)
public class NoFallLog {
	@Redirect(at = @At(value = "INVOKE",
			target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;)V"),
			method = "forceSendPlayerSupportBlocks")
	private void suppressLog(Logger instance, String s, Object o) {
		// This code is injected into the Logger for forceSendPlayerSupportBlocks
		// Basically its annoying and wont shut up
	}
}