package net.technochronicle.technochroniclecore;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.data.loading.DatagenModLoader;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.technochronicle.technochronicleapi.TechnoChronicleAPI;
import net.technochronicle.technochronicleapi.utils.FormattingUtil;
import net.technochronicle.technochroniclecore.api.TCAPI;
import net.technochronicle.technochroniclecore.common.CommonInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;

@Mod(TechnoChronicleCore.MOD_ID)
public class TechnoChronicleCore {
    public static final String MOD_ID = "technochroniclecore";

    public static final Logger LOGGER = LogManager.getLogger(TechnoChronicleCore.MOD_ID);
    public static final String NAME = "万机纪元";
    @ApiStatus.Internal
    public static IEventBus tcModBus;
    public TechnoChronicleCore(IEventBus modEventBus, ModContainer modContainer) {
        TCAPI.Instance = this;
        tcModBus = modEventBus;

        CommonInit.init(modEventBus);
    }

    // TODO: ResourceLocation 处理
    private static final ResourceLocation TEMPLATE_LOCATION = ResourceLocation.fromNamespaceAndPath(MOD_ID, "");

    public static ResourceLocation id(String path) {
        if (Strings.isBlank(path)) {
            return TEMPLATE_LOCATION;
        }
        return TEMPLATE_LOCATION.withPath(FormattingUtil.toLowerCaseUnder(path));
    }

    public static String appendIdString(String id) {
        return id.indexOf(':') == -1 ? (MOD_ID + ":" + id) : id;
    }

    public static ResourceLocation appendId(String id) {
        String[] strings = new String[]{MOD_ID, id};
        int i = id.indexOf(':');
        if (i >= 0) {
            strings[1] = id.substring(i + 1);
            if (i >= 1) {
                strings[0] = id.substring(0, i);
            }
        }
        return ResourceLocation.fromNamespaceAndPath(strings[0], strings[1]);
    }

    /**
     * @return if we're running in a production environment
     */
    public static boolean isProd() {
        return FMLLoader.isProduction();
    }

    /**
     * @return if we're not running in a production environment
     */
    public static boolean isDev() {
        return !isProd();
    }

    /**
     * @return if we're running data generation
     */
    public static boolean isDataGen() {
        return DatagenModLoader.isRunningDataGen();
    }

    /**
     * A friendly reminder that the server instance is populated on the server side only, so null/side check it!
     *
     * @return the current minecraft server instance
     */
    public static MinecraftServer getMinecraftServer() {
        return ServerLifecycleHooks.getCurrentServer();
    }

    /**
     * @param modId the mod id to check for
     * @return if the mod whose id is {@code modId} is loaded or not
     */
    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    /**
     * For async stuff use this, otherwise use {@link TechnoChronicleAPI isClientSide}
     *
     * @return if the current thread is the client thread
     */
    public static boolean isClientThread() {
        return isClientSide() && Minecraft.getInstance().isSameThread();
    }

    /**
     * @return if the FML environment is a client
     */
    public static boolean isClientSide() {
        return FMLEnvironment.dist.isClient();
    }

    /**
     * This check isn't the same for client and server!
     *
     * @return if it's safe to access the current instance {@link net.minecraft.world.level.Level Level} on client or if
     * it's safe to access any level on server.
     */
    public static boolean canGetServerLevel() {
        if (isClientSide()) {
            return Minecraft.getInstance().level != null;
        }
        var server = getMinecraftServer();
        return server != null &&
                !(server.isStopped() || server.isShutdown() || !server.isRunning() || server.isCurrentlySaving());
    }

    /**
     * @return the path to the minecraft instance directory
     */
    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }
}