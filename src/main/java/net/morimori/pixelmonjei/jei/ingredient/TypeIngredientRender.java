package net.morimori.pixelmonjei.jei.ingredient;

import com.pixelmongenerations.core.enums.EnumType;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.morimori.pixelmonjei.util.PokemonHelper;
import net.morimori.pixelmonjei.util.RenderHelper;

import java.util.ArrayList;
import java.util.List;

public class TypeIngredientRender implements IIngredientRenderer<EnumType> {

    @Override
    public void render(Minecraft var1, int var2, int var3, EnumType var4) {

        if (var4 != null) {
            RenderHelper.drawTypeSprite(var4, var1, var2, var3);
            //var1.fontRenderer.drawString(PokemonHelper.getTypeDisplayName(var4), var2, var3, Color.WHITE.getRGB());
        }

    }

    @Override
    public List<String> getTooltip(Minecraft minecraft, EnumType ingredient, ITooltipFlag tooltipFlag) {
        ArrayList<String> st = new ArrayList<String>();

        String name = PokemonHelper.getTypeDisplayName(ingredient);

        if (minecraft.gameSettings.advancedItemTooltips)
            st.add(name + " (#" + ingredient.getIndex() + ")");
        else
            st.add(name);

        return st;

    }

    @Override
    public FontRenderer getFontRenderer(Minecraft minecraft, EnumType ingredient) {
        return minecraft.fontRenderer;
    }

}
