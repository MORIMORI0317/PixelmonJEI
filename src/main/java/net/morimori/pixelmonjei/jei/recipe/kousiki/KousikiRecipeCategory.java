package net.morimori.pixelmonjei.jei.recipe.kousiki;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.util.ResourceLocation;
import net.morimori.pixelmonjei.PixelmonJei;
import net.morimori.pixelmonjei.jei.PixelmonJeiPlugin;

public class KousikiRecipeCategory implements IRecipeCategory<KousikiRecipe> {
	private final IDrawable background;

	public KousikiRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation backgroundTexture = new ResourceLocation(PixelmonJei.MODID, "textures/gui/gui_pixelmon_1.png");
		background = guiHelper.drawableBuilder(backgroundTexture, 0, 183, 247, 56).build();
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

		return Translator.translateToLocal("gui.jei.category." + PixelmonJeiPlugin.Kousiki);
	}

	@Override
	public String getUid() {

		return PixelmonJeiPlugin.Kousiki;
	}

	@Override
	public void setRecipe(IRecipeLayout arg0, KousikiRecipe arg1, IIngredients arg2) {

	}

}
