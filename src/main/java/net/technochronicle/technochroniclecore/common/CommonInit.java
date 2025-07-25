package net.technochronicle.technochroniclecore.common;

import net.neoforged.bus.api.IEventBus;
import net.technochronicle.technochroniclecore.common.registration.TCRegistration;

public class CommonInit {
    public static void init(IEventBus modEventBus) {
        TCRegistration.init();
    }
}
