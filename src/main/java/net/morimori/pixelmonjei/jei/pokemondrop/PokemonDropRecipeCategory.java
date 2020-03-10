package net.morimori.pixelmonjei.jei.pokemondrop;

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

public class PokemonDropRecipeCategory implements IRecipeCategory<PokemonDropRecipe> {
	public static final int RECIPE_WIDTH = 160;
	public static final int RECIPE_HEIGHT = 60;
	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;

	public PokemonDropRecipeCategory(IGuiHelper guiHelper) {

		ResourceLocation backgroundTexture = new ResourceLocation("pixelmonjei", "textures/gui/gui_pixelmon.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 0, 54, 208, 144)
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

		for (int i = 0; i < 24; i++) {
			guiItemStacks.init(i, false, (int) ((10 + (18 * i)) - (18 * Math.floor(i / 6) * 6)),
					(int) (35 + (18 * Math.floor(i / 6))));
		}
		guiItemStacks.set(ingredients);
	}

}