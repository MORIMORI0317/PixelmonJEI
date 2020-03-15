package net.morimori.pixelmonjei.jei.recipe.pokemondrop;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;
import net.morimori.pixelmonjei.util.PokemonHelper;
import net.morimori.pixelmonjei.util.RenderHelper;

public class PokemonDropRecipe implements IRecipeWrapper {
	private final String name;

	private final ItemStack main;
	private final ItemStack rare;
	private final ItemStack option1;
	private final ItemStack option2;

	private int mainmin;
	private int raremin;
	private int option1min;
	private int option2min;

	private int mainmax;
	private int raremax;
	private int option1max;
	private int option2max;

	public PokemonDropRecipe(String name, ItemStack main, ItemStack rare, ItemStack opt1, ItemStack opt2, int mainmin,
			int mainmax, int raremin, int raremax, int opt1min, int opt1max, int opt2min, int opt2max) {

		this.main = main;
		this.rare = rare;
		this.option1 = opt1;
		this.option2 = opt2;

		this.mainmin = mainmin;
		this.raremin = raremin;
		this.option1min = opt1min;
		this.option2min = opt2min;

		this.mainmax = mainmax;
		this.raremax = raremax;
		this.option1max = opt1max;
		this.option2max = opt2max;

		this.name = name;

	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

		GlStateManager.pushMatrix();
		GlStateManager.scale(4.6f, 4.6f, 4.6f);
		RenderHelper.drawPokemonSprite(EnumPokemon.get(name), false, minecraft, 26, 8);
		GlStateManager.popMatrix();

		minecraft.fontRenderer.drawString(PokemonHelper.getPokemonDisplayName(name), 30, 15,
				Color.WHITE.getRGB());

		GlStateManager.pushMatrix();
		GlStateManager.scale(0.5f, 0.5f, 0.5f);
		minecraft.fontRenderer.drawString(I18n.format("gui.jei.maindrop"), 60, 68,
				Color.WHITE.getRGB());
		minecraft.fontRenderer.drawString(I18n.format("gui.jei.raredrop"), 60, 110,
				Color.WHITE.getRGB());
		minecraft.fontRenderer.drawString(I18n.format("gui.jei.opt1drop"), 60, 152,
				Color.WHITE.getRGB());
		minecraft.fontRenderer.drawString(I18n.format("gui.jei.opt2drop"), 60, 194,
				Color.WHITE.getRGB());
		GlStateManager.popMatrix();

		if (main.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 40,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", mainmin) + " - " + I18n.format("gui.jei.maxdrop", mainmax),
					31, 40, Color.WHITE.getRGB());
		}
		if (rare.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 61,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", raremin) + " - " + I18n.format("gui.jei.maxdrop", raremax),
					31, 61, Color.WHITE.getRGB());
		}
		if (option1.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 82,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", option1min) + " - "
							+ I18n.format("gui.jei.maxdrop", option1max),
					31, 82, Color.WHITE.getRGB());
		}
		if (option2.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 103,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", option2min) + " - "
							+ I18n.format("gui.jei.maxdrop", option2max),
					31, 103, Color.WHITE.getRGB());
		}
	}

	@Override
	public void getIngredients(IIngredients ingredients) {

		List<ItemStack> items = new ArrayList<>();
		items.add(main);
		items.add(rare);
		items.add(option1);
		items.add(option2);

		ingredients.setOutputs(VanillaTypes.ITEM, items);
		ingredients.setInput(PixelmonTypes.POKEMON, EnumPokemon.get(name));
	}

}
