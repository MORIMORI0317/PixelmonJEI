package net.morimori.pixelmonjei.jei.recipe.pokeanvil;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.PixelmonJeiPlugin;

public class PokeAnvilRecipeCategory implements IRecipeCategory<PokeAnvilRecipe> {
	private final IDrawable background;
	private final IDrawable icon;

	public PokeAnvilRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation backgroundTexture = new ResourceLocation(PixelmonJei.MODID, "textures/gui/gui_pixelmon_1.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 0, 0, 116, 54)
				.build();

		icon = guiHelper.createDrawableIngredient(new ItemStack(PixelmonBlocks.anvil));
	}

	@Override
	public String getUid() {
		return PixelmonJeiPlugin.PokeAnvil;

	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public String getTitle() {
		return PixelmonBlocks.anvil.getLocalizedName();
	}

	@Override
	public String getModName() {
		return PixelmonJei.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawExtras(Minecraft minecraft) {

	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, PokeAnvilRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(0, true, 18, 18);
		guiItemStacks.init(2, false, 94, 18);

		guiItemStacks.set(ingredients);
	}

}