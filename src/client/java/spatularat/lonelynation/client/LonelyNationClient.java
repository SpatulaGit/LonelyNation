package spatularat.lonelynation.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import spatularat.lonelynation.client.commands.CommandManager;
import spatularat.lonelynation.client.data.JsonFileManager;
import spatularat.lonelynation.client.data.*;

public class LonelyNationClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(){

		JsonFileManager.createFile("/config/lonelynation.json", new Config());

		ClientPlayConnectionEvents.JOIN.register(((handler, sender, client) -> {
			JsonFileManager.createFile("/lonelynation/ChunkData.json", new ChunkData());
		}));

		ClientCommandRegistrationCallback.EVENT.register(
				((dispatcher, registryAccess) -> {
					CommandManager.register(dispatcher);
				})
		);
	}
}