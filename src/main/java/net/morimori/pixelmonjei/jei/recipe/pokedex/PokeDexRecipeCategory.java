package net.morimori.pixelmonjei.jei.recipe.pokedex;

import com.pixelmonmod.pixelmon.config.PixelmonItems;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.PixelmonJeiPlugin;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;

public class PokeDexRecipeCategory implements IRecipeCategory<PokeDexRecipe> {
	private final IDrawable background;
	private final IDrawable icon;

	public PokeDexRecipeCategory(IGuiHelper guiHelper) {

		ResourceLocation backgroundTexture = new ResourceLocation(PixelmonJei.MODID, "textures/gui/gui_pixelmon_2.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 0, 0, 223, 139)
				.build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(PixelmonItems.pokedex));
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public String getModName() {
		return PixelmonJei.NAME;
	}

	@Override
	public String getTitle() {
		return new ItemStack(PixelmonItems.pokedex).getDisplayName();
	}

	@Override
	public String getUid() {
		return PixelmonJeiPlugin.PokeDex;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, PokeDexRecipe recipeWrapper, IIngredients ingredients) {

		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).init(1, false, 11, 11);
		recipeLayout.getIngredientsGroup(PixelmonTypes.POKEMON).set(1,
				ingredients.getInputs(PixelmonTypes.POKEMON).get(0));

		recipeLayout.getIngredientsGroup(PixelmonTypes.TYPE).init(1, false, 152, 87);
		recipeLayout.getIngredientsGroup(PixelmonTypes.TYPE).set(1,
				ingredients.getInputs(PixelmonTypes.TYPE).get(0));

		recipeLayout.getIngredientsGroup(PixelmonTypes.TYPE).init(2, false, 184, 87);
		recipeLayout.getIngredientsGroup(PixelmonTypes.TYPE).set(2,
				ingredients.getInputs(PixelmonTypes.TYPE).get(1));

	}

}
