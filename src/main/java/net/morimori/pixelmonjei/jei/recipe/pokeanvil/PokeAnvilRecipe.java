package net.morimori.pixelmonjei.jei.recipe.pokeanvil;

import java.awt.Color;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTools;

import mezz.jei.Internal;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.gui.GuiHelper;
import mezz.jei.runtime.JeiHelpers;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PokeAnvilRecipe implements IRecipeWrapper {
	private boolean hiddenRecipes;
	private final IDrawable anvil;
	private final IDrawable hanmmer;
	private final ItemStack inputs;
	private final ItemStack output;

	public PokeAnvilRecipe(Item inputs, Item output) {
		this(new ItemStack(inputs), new ItemStack(output));
	}

	public PokeAnvilRecipe(ItemStack inputs, ItemStack output) {

		JeiHelpers jeiHelpers = Internal.getHelpers();
		GuiHelper guiHelper = jeiHelpers.getGuiHelper();
		anvil = guiHelper.createDrawableIngredient(new ItemStack(PixelmonBlocks.anvil));
		hanmmer = guiHelper.createDrawableIngredient(new ItemStack(PixelmonItemsTools.hammerIron));
		this.inputs = inputs;
		this.output = output;
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		anvil.draw(minecraft, 18, 37);
		hanmmer.draw(minecraft, 1, 0);
		minecraft.fontRenderer.drawString(minecraft.gameSettings.keyBindAttack.getDisplayName(), 35, 4,
				Color.gray.getRGB());
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(VanillaTypes.ITEM, inputs);
		ingredients.setOutput(VanillaTypes.ITEM, output);

	}

}