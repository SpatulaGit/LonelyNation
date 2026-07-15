package spatularat.modernnations;

import net.fabricmc.loader.api.FabricLoader;

public class ModInfo {

    public static final String MOD_ID = "modernnations";

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
