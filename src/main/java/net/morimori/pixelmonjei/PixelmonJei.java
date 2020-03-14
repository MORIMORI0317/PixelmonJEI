package net.morimori.pixelmonjei;

import com.pixelmonmod.pixelmon.Pixelmon;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PixelmonJei.MODID, name = PixelmonJei.NAME, version = PixelmonJei.VERSION, dependencies = "required-after:"
		+ Pixelmon.MODID)
public class PixelmonJei {
	public static final String MODID = "pixelmonjei";
	public static final String NAME = "Pixelmon Jei";
	public static final String VERSION = "1.3";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void posInit(FMLPostInitializationEvent event) {

	}
}
