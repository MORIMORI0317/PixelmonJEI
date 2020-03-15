package net.morimori.pixelmonjei.jei.ingredient;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.morimori.pixelmonjei.util.PokemonHelper;
import net.morimori.pixelmonjei.util.RenderHelper;

public class PokemonIngredientRender implements IIngredientRenderer<EnumPokemon> {

	@Override
	public void render(Minecraft var1, int var2, int var3, EnumPokemon var4) {

		if (var4 != null) {
			RenderHelper.drawPokemonSprite(var4, false, var1, var2, var3);
		}

	}

	@Override
	public List<String> getTooltip(Minecraft minecraft, EnumPokemon ingredient, ITooltipFlag tooltipFlag) {
		ArrayList<String> st = new ArrayList<String>();

		String name = PokemonHelper.getPokemonDisplayName(ingredient);

		if (minecraft.gameSettings.advancedItemTooltips)
			st.add(name + " (#" + ingredient.getNationalPokedexNumber() + ")");
		else
			st.add(name);

		if (PokemonHelper.getType1(ingredient) != null)
			st.add(PokemonHelper.getType1(ingredient).getLocalizedName());

		if (PokemonHelper.getType2(ingredient) != null)
			st.add(PokemonHelper.getType2(ingredient).getLocalizedName());

		return st;

	}

	@Override
	public FontRenderer getFontRenderer(Minecraft minecraft, EnumPokemon ingredient) {
		return minecraft.fontRenderer;
	}
}
