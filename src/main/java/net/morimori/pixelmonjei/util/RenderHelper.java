package net.morimori.pixelmonjei.util;

import com.pixelmongenerations.client.gui.GuiHelper;
import com.pixelmongenerations.client.gui.GuiResources;
import com.pixelmongenerations.core.enums.EnumSpecies;
import com.pixelmongenerations.core.enums.EnumType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

public class RenderHelper {
    public static void drawPokemonSprite(int num, boolean shiny, Minecraft mc, int x, int y) {

        GlStateManager.pushMatrix();
        GuiHelper.bindPokemonSprite(num, shiny, mc);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 16, 16, 16, 16);
        GlStateManager.popMatrix();

    }

    public static void drawPokemonSprite(EnumSpecies poke, boolean shiny, Minecraft mc, int x, int y) {
        drawPokemonSprite(poke.getNationalPokedexInteger(), shiny, mc, x, y);
    }

    public static void drawTypeSprite(EnumType type, Minecraft mc, int x, int y) {

        GlStateManager.pushMatrix();
        mc.getTextureManager().bindTexture(GuiResources.types);
        float tx = type.textureX;
        float ty = type.textureY;
        GuiHelper.drawImageQuad(x, y, 16.0D, 16.0F, (double) (tx / 495.0F),
                (double) (ty / 392.0F), (double) ((tx + 98.0F) / 495.0F), (double) ((ty + 98.0F) / 392.0F),
                1);
        //Gui.drawModalRectWithCustomSizedTexture(x, y, tx, ty, 16, 16, 16, 16);
        GlStateManager.popMatrix();

    }
}
