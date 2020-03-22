package net.morimori.pixelmonjei.jei.recipe.evolutions;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.PixelmonJeiPlugin;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;

public class EvolutionsRecipeCategory implements IRecipeCategory<EvolutionsRecipe> {
	private final IDrawable background;

	public EvolutionsRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation backgroundTexture = new ResourceLocation(PixelmonJei.MODID, "textures/gui/gui_pixelmon_1.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 117, 0, 58, 17)
				.build();
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public String getModName() {
		return PixelmonJei.NAME;
	}

	@Override
	public String getTitle() {
		return "evo";
	}

	@Override
	public String getUid() {
		return PixelmonJeiPlugin.Evolutions;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, EvolutionsRecipe recipeWrapper, IIngredients ingredients) {
		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).init(1, false, 1, 1);
		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).set(1,
				ingredients.getInputs(PixelmonTypes.POKEMON).get(0));

		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).init(2, true, 41, 1);
		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).set(2,
				ingredients.getOutputs(PixelmonTypes.POKEMON).get(0));

	}

}
