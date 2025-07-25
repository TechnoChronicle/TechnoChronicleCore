package net.technochronicle.technochroniclecore.common.registration;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.technochronicle.technochronicleapi.registrate.TCRegistrate;
import net.technochronicle.technochroniclecore.TechnoChronicleCore;

public class TCRegistration {
    public static final TCRegistrate REGISTRATE = TCRegistrate.create(TechnoChronicleCore.MOD_ID);

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }
    public static void init(){}
}