package spatularat.modernnations.client;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import spatularat.modernnations.client.command.CommandManager;
import spatularat.modernnations.client.config.ConfigManager;


public class ModernNationsClient implements ClientModInitializer {
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