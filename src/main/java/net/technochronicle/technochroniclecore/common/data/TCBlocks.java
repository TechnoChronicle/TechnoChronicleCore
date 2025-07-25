package net.technochronicle.technochroniclecore.common.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

import static net.technochronicle.technochroniclecore.common.registration.TCRegistration.REGISTRATE;

public class TCBlocks {
    static {
        REGISTRATE.creativeModeTab(() -> TCCreativeTabs.Decorative_Blocks);
    }

    public static BlockEntry<Block>[] Casts = new BlockEntry[2];
    public static BlockEntry<Block> Iron_Cast;
    public static BlockEntry<Block> Copper_Cast;

    static {
        Casts[0] = Iron_Cast = REGISTRATE.block("iron_cast", Block::new)
                .simpleItem()
                .lang("Iron Cast")
                .register();
        Casts[1] = Copper_Cast = REGISTRATE.block("copper_cast", Block::new)
                .simpleItem()
                .lang("Copper Cast")
                .register();
    }

    public static void init() {
    }
}