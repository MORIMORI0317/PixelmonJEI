package net.morimori.pixelmonjei.jei.pokemondrop;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

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

	public PokemonDropRecipe(String name, ItemStack main, ItemStack rare, ItemStack opt1, ItemStack opt2) {

		this.main = main;
		this.rare = rare;
		this.option1 = opt1;
		this.option2 = opt2;

		this.name = name;

	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		try {
			EntityPixelmon po = (EntityPixelmon) PixelmonEntityList.createEntityByName(name,
					Minecraft.getMinecraft().world);

			GuiInventory.drawEntityOnScreen(155, 110, 30, 150 - mouseX, 60 - mouseY, po);

			minecraft.fontRenderer.drawString(po.getName(), 12, 15,
					Color.WHITE.getRGB());

		} catch (Exception e) {

		}
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
					I18n.format("gui.jei.mindrop", mainmin) + " - " + I18n.format("gui.jei.maxdrop", main.getCount()),
					31, 40, Color.WHITE.getRGB());
		}
		if (rare.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 61,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", raremin) + " - " + I18n.format("gui.jei.maxdrop", rare.getCount()),
					31, 61, Color.WHITE.getRGB());
		}
		if (option1.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 82,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", option1min) + " - "
							+ I18n.format("gui.jei.maxdrop", option1.getCount()),
					31, 82, Color.WHITE.getRGB());
		}
		if (option2.isEmpty()) {
			minecraft.fontRenderer.drawString(I18n.format("gui.jei.nodrop"), 31, 103,
					Color.WHITE.getRGB());
		} else {
			minecraft.fontRenderer.drawString(
					I18n.format("gui.jei.mindrop", option2min) + " - "
							+ I18n.format("gui.jei.maxdrop", option2.getCount()),
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
	}

}
