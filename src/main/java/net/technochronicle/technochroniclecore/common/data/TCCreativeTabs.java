package net.technochronicle.technochroniclecore.common.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.technochronicle.technochronicleapi.misc.RegistrateDisplayItemsGenerator;
import net.technochronicle.technochroniclecore.TechnoChronicleCore;

import static net.technochronicle.technochroniclecore.common.registration.TCRegistration.REGISTRATE;

public class TCCreativeTabs {
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> Decorative_Blocks = REGISTRATE
            .defaultCreativeTab("decorative_blocks",
                    builder -> builder
                            .displayItems(new RegistrateDisplayItemsGenerator("decorative_blocks", REGISTRATE))
                            .build())
            .register();

    public static RegistryEntry<CreativeModeTab, CreativeModeTab> Buckets = REGISTRATE
            .defaultCreativeTab("buckets",
                    builder -> builder
                            .icon(Items.BUCKET::getDefaultInstance)
                            .displayItems(new RegistrateDisplayItemsGenerator("buckets", REGISTRATE))
                            .title(REGISTRATE.addLang("itemsGroup", TechnoChronicleCore.id("buckets"), TechnoChronicleCore.NAME + "|Buckets"))
                            .build())
            .register();

    public static void init() {
    }
}
