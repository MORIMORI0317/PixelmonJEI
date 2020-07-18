package net.morimori.pixelmonjei.jei.ingredient;

import java.util.ArrayList;
import java.util.List;


import com.pixelmongenerations.core.enums.EnumSpecies;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.morimori.pixelmonjei.util.PokemonHelper;
import net.morimori.pixelmonjei.util.RenderHelper;

public class PokemonIngredientRender implements IIngredientRenderer<EnumSpecies> {

	@Override
	public void render(Minecraft var1, int var2, int var3, EnumSpecies var4) {

		if (var4 != null) {
			RenderHelper.drawPokemonSprite(var4, false, var1, var2, var3);
		}

	}

	@Override
	public List<String> getTooltip(Minecraft minecraft, EnumSpecies ingredient, ITooltipFlag tooltipFlag) {
		ArrayList<String> st = new ArrayList<String>();

		String name = PokemonHelper.getPokemonDisplayName(ingredient);

		if (minecraft.gameSettings.advancedItemTooltips)
			st.add(name + " (#" + ingredient.getNationalPokedexNumber() + ")");
		else
			st.add(name);

		String type = I18n.format("gui.battle.type");

		if (PokemonHelper.getType1(ingredient) != null)
			type += " " + PokemonHelper.getTypeDisplayName(PokemonHelper.getType1(ingredient));

		if (PokemonHelper.getType2(ingredient) != null)
			type += " " + PokemonHelper.getTypeDisplayName(PokemonHelper.getType2(ingredient));

		st.add(type);

		return st;

	}

	@Override
	public FontRenderer getFontRenderer(Minecraft minecraft, EnumSpecies ingredient) {
		return minecraft.fontRenderer;
	}
}
