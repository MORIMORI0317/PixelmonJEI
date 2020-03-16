package net.morimori.pixelmonjei.jei.recipe.pokemondrop;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.util.ResourceLocation;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.PixelmonJeiPlugin;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;

public class PokemonDropRecipeCategory implements IRecipeCategory<PokemonDropRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;

	public PokemonDropRecipeCategory(IGuiHelper guiHelper) {

		ResourceLocation backgroundTexture = new ResourceLocation(PixelmonJei.MODID, "textures/gui/gui_pixelmon_1.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 0, 54, 208, 129)
				.build();
		ResourceLocation iconTexture = new ResourceLocation("pixelmonjei", "textures/gui/pokemon_drop_icon.png");
		icon = guiHelper.drawableBuilder(iconTexture, 0, 0, 16, 16)
				.build();

		localizedName = Translator.translateToLocal("gui.jei.category." + PixelmonJeiPlugin.PokemonDrop);
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public String getUid() {

		return PixelmonJeiPlugin.PokemonDrop;
	}

	@Override
	public String getTitle() {

		return localizedName;
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
	public void setRecipe(IRecipeLayout recipeLayout, PokemonDropRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(1, false, 10, 33);

		guiItemStacks.init(2, false, 10, 54);

		guiItemStacks.init(3, false, 10, 75);

		guiItemStacks.init(4, false, 10, 96);

		guiItemStacks.set(ingredients);

		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).init(1, false, 11, 11);
		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).set(1,
				ingredients.getInputs(PixelmonTypes.POKEMON).get(0));

	}

}
