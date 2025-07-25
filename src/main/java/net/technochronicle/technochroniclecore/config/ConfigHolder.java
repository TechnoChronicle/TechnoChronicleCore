package net.technochronicle.technochroniclecore.config;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;
import net.technochronicle.technochroniclecore.TechnoChronicleCore;
import org.jetbrains.annotations.ApiStatus;

@Config(id = TechnoChronicleCore.MOD_ID)
public class ConfigHolder {
    public static ConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    @ApiStatus.Internal
    public static dev.toma.configuration.config.ConfigHolder<ConfigHolder> INTERNAL_INSTANCE;

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null || INTERNAL_INSTANCE == null) {
                INTERNAL_INSTANCE = Configuration.registerConfig(ConfigHolder.class, ConfigFormats.YAML);
                INSTANCE = INTERNAL_INSTANCE.getConfigInstance();
            }
        }
    }

    @Configurable
    public GlobalConfig globalConfig = new GlobalConfig();

    public static class GlobalConfig {
        public enum Difficulty {
            Easy,
            Normal,
            Hard,
            Expert
        }

        @Configurable
        public Difficulty difficulty = Difficulty.Normal;
    }
}