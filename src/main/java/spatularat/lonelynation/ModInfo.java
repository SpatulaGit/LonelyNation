package spatularat.lonelynation;

import net.fabricmc.loader.api.FabricLoader;

public class ModInfo {

	public static final String MOD_ID = "lonely-nation";

	public static final String LINE = "~~~~~~~~~~~~~~~~~~~~";

	public static final String VERSION =
			FabricLoader
					.getInstance()
					.getModContainer(MOD_ID)
					.get()
					.getMetadata()
					.getVersion()
					.getFriendlyString();
}
