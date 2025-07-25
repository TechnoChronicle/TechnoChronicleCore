package net.technochronicle.technochroniclecore.common.data;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.technochronicle.technochronicleapi.misc.FluidTypeExtensions;

import static net.technochronicle.technochroniclecore.common.registration.TCRegistration.REGISTRATE;

public class TCFluids {
    static {
        REGISTRATE.creativeModeTab(() -> TCCreativeTabs.Buckets);
    }

    public static FluidEntry<BaseFlowingFluid.Flowing> Oxygen_Gas = REGISTRATE.tcFluid("oxygen_gas",
                    () -> FluidTypeExtensions.create()
                            .LiquidBase()
                            .setTintColor(0xff94deff)
                            .build())
            .renderType(()->()-> RenderType.TRANSLUCENT)
            .register();
    public static FluidEntry<BaseFlowingFluid.Flowing> Oxygen_Liquid = REGISTRATE.tcFluid("oxygen_liquid",
                    () -> FluidTypeExtensions.create()
                            .LiquidBase()
                            .setTintColor(0xff2dbbfb)
                            .build())
            .renderType(()->()-> RenderType.TRANSLUCENT)
            .register();

    public static void init() {
    }
}