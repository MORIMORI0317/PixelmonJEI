package net.morimori.pixelmonjei.jei.recipe.pokedex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;
import net.morimori.pixelmonjei.util.PokemonHelper;
import net.morimori.pixelmonjei.util.RenderHelper;

public class PokeDexRecipe implements IRecipeWrapper {
	private final EnumPokemon pokemon;

	public PokeDexRecipe(EnumPokemon poke) {
		this.pokemon = poke;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(PixelmonTypes.POKEMON, pokemon);

		List<EnumType> types = new ArrayList<>();

		types.add(PokemonHelper.getType1(pokemon));
		types.add(PokemonHelper.getType2(pokemon));

		ingredients.setInputs(PixelmonTypes.TYPE, types);

	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

		GlStateManager.pushMatrix();
		minecraft.fontRenderer.drawString(
				PokemonHelper.getPokemonDisplayName(pokemon), 30, 15,
				Color.WHITE.getRGB());
		minecraft.fontRenderer.drawString("No, " + pokemon.getNationalPokedexNumber(), 160, 15,
				Color.WHITE.getRGB());
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.scale(2.3f, 2.3f, 2.3f);
		RenderHelper.drawPokemonSprite(pokemon, false, minecraft, 59, 16);
		RenderHelper.drawPokemonSprite(pokemon, true, minecraft, 76, 16);
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		if (PixelmonJei.DexCont >= 0 && PixelmonJei.DexCont <= 100) {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.baseattack") + " " + PokemonHelper.getAttack(pokemon),
					11, 34, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.basespattack") + " " + PokemonHelper.getSpAtt(pokemon),
					11, 44, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.basedefence") + " " + PokemonHelper.getDefence(pokemon),
					11, 54, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.basespdefence") + " " + PokemonHelper.getSpDef(pokemon),
					11, 64, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(I18n.format("gui.jei.basespeed") + " " + PokemonHelper.getSpeed(pokemon),
					11, 74, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(I18n.format("gui.jei.basehp") + " " + PokemonHelper.getHp(pokemon), 11,
					84, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(I18n.format("gui.jei.baseexp") + " " + PokemonHelper.getBaseExp(pokemon),
					11, 94, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.crate") + " " + PokemonHelper.getCatchRate(pokemon),
					11, 104, Color.WHITE.getRGB());
		} else if (PixelmonJei.DexCont >= 101 && PixelmonJei.DexCont <= 200) {

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.malepercent") + " " + PokemonHelper.getMalePercent(pokemon),
					11, 34, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.spawnlevel") + " " + PokemonHelper.getSpawnLevel(pokemon),
					11, 44, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.spawnlevelrange") + " " + PokemonHelper.getSpawnLevelRange(pokemon),
					11, 54, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.basefriendship") + " " + PokemonHelper.getBaseFriendship(pokemon),
					11, 64, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.height") + " " + PokemonHelper.getHeight(pokemon),
					11, 74, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.width") + " " + PokemonHelper.getWidth(pokemon),
					11, 84, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.length") + " " + PokemonHelper.getWidth(pokemon),
					11, 94, Color.WHITE.getRGB());

			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.giScale") + " " + PokemonHelper.getGiScale(pokemon),
					11, 104, Color.WHITE.getRGB());

		}

		GlStateManager.popMatrix();

		String deco = PokemonHelper.getPokemoDescription(pokemon);
		int fontsizes = minecraft.fontRenderer.getStringWidth(deco);

		GlStateManager.pushMatrix();

		if (fontsizes >= 201) {
			float scale = 1 / ((float) fontsizes / 201);
			GlStateManager.scale(scale, scale, scale);

			minecraft.fontRenderer.drawString(deco, (int) (11 / scale), (int) (120 / scale),
					Color.WHITE.getRGB());

		} else
			minecraft.fontRenderer.drawString(deco, 11, 120, Color.WHITE.getRGB());
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();

		if (PokemonHelper.getType1(pokemon) != null) {
			String typename = PokemonHelper.getTypeDisplayName(PokemonHelper.getType1(pokemon));
			int fontsize = minecraft.fontRenderer.getStringWidth(typename);
			GlStateManager.scale(0.5f, 0.5f, 0.5f);
			minecraft.fontRenderer.drawString(typename, 160 * 2 - fontsize / 2, 105 * 2, Color.WHITE.getRGB());

		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		if (PokemonHelper.getType2(pokemon) != null) {
			String typename = PokemonHelper.getTypeDisplayName(PokemonHelper.getType2(pokemon));
			int fontsize = minecraft.fontRenderer.getStringWidth(typename);
			GlStateManager.scale(0.5f, 0.5f, 0.5f);
			minecraft.fontRenderer.drawString(typename, 193 * 2 - fontsize / 2, 105 * 2,
					Color.WHITE.getRGB());

		}
		GlStateManager.popMatrix();

	}
}
