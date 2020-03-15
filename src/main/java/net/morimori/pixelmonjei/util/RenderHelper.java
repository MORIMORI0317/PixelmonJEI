package net.morimori.pixelmonjei.util;

import com.pixelmonmod.pixelmon.client.gui.GuiHelper;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

public class RenderHelper {
	public static void drawPokemonSprite(int num, boolean shiny, Minecraft mc, int x, int y) {

		GlStateManager.pushMatrix();
		GuiHelper.bindPokemonSprite(num, false, mc);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 16, 16, 16, 16);
		GlStateManager.popMatrix();

	}

	public static void drawPokemonSprite(EnumPokemon poke, boolean shiny, Minecraft mc, int x, int y) {
		drawPokemonSprite(poke.getNationalPokedexInteger(), shiny, mc, x, y);
	}
}
