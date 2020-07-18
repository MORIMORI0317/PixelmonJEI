package net.morimori.pixelmonjei;

import com.pixelmongenerations.core.Pixelmon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

@Mod(modid = PixelmonJei.MODID, name = PixelmonJei.NAME, version = PixelmonJei.VERSION, dependencies = "required-after:" + Pixelmon.MODID)
public class PixelmonJei {
    public static final String MODID = "pixelmonjei";
    public static final String NAME = "Pixelmon Jei";
    public static final String VERSION = "1.5";
    public static int DexCont;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void posInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public void onClick(ClientTickEvent e) {

        if (DexCont >= 200)
            DexCont = 0;

        DexCont++;

    }
	/*
	@SubscribeEvent
	public void onClick(GuiOpenEvent e) {

		if (Minecraft.getMinecraft().gameSettings.showDebugInfo)
			System.out.println(e.getGui().getClass().toString());
	}*/
}
