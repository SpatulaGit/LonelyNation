package spatularat.lonelynation.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import spatularat.lonelynation.client.command.CommandManager;
import spatularat.lonelynation.client.config.ConfigManager;

public class LonelyNationClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(){

		ConfigManager.load();

		ClientCommandRegistrationCallback.EVENT.register(
				((dispatcher, registryAccess) -> {
					CommandManager.register(dispatcher);
				})
		);
	}
}