package net.technochronicle.technochroniclecore.common;

import net.neoforged.bus.api.IEventBus;
import net.technochronicle.technochroniclecore.common.data.*;
import net.technochronicle.technochroniclecore.common.registration.TCRegistration;

public class CommonInit {
    public static void init(IEventBus modEventBus) {
        TCRegistration.init();

        TCCreativeTabs.init();
        
        TCItems.init();
        TCBlocks.init();
        TCFluids.init();
        TCMachines.init();
    }
}
