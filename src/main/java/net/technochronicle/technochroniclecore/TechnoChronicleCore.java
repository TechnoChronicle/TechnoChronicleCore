package net.technochronicle.technochroniclecore;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.ApiStatus;

@Mod(TechnoChronicleCore.MOD_ID)
public class TechnoChronicleCore {
    public static final String MOD_ID = "technochroniclecore";

    public static final Logger LOGGER = LogManager.getLogger(TechnoChronicleCore.MOD_ID);
    public static final String NAME = "万机纪元";
    @ApiStatus.Internal
    public static IEventBus tcModBus;
    public TechnoChronicleCore(IEventBus modEventBus, ModContainer modContainer) {
        tcModBus = modEventBus;
    }
}