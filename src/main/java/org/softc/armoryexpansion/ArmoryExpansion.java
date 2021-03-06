package org.softc.armoryexpansion;

import c4.conarm.*;
import net.minecraftforge.common.*;
import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import slimeknights.tconstruct.*;

@Mod(
        modid = ArmoryExpansion.MODID,
        name = ArmoryExpansion.NAME,
        version = ArmoryExpansion.VERSION,
        dependencies = ArmoryExpansion.DEPENDENCIES
)
@Mod.EventBusSubscriber
public final class ArmoryExpansion {
    public static final String MODID = "armoryexpansion";
    public static final String NAME = "Armory Expansion";
    public static final String VERSION = "1.4.2";
    static final String DEPENDENCIES =
            "required-after:" + TConstruct.modID + "; " +
            "required-after:" + ConstructsArmory.MODID + "; ";

    private static Configuration config;

    public static Configuration getConfig() {
        return config;
    }

    public static void setConfig(Configuration config) {
        ArmoryExpansion.config = config;
    }

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        config = new Configuration(event.getSuggestedConfigurationFile());
    }

    public static boolean isIntegrationEnabled(String modid){
        return config
                .get("integrations", modid, true, "Whether integration with " + modid + " should be enabled").getBoolean();
    }

    public static int getBoundedInputStreamMaxSize(){
        return config.get("web server", "input stream max size", 131072,
                "The maximum size of the data received from the Web Server").getInt();
    }
}
