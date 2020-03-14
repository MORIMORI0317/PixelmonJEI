package net.morimori.pixelmonjei.jei.pokemondrop;

import java.awt.Color;
import java.util.List;

import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.ItemStack;

public class PokemonDropRecipe implements IRecipeWrapper {
	private final List<ItemStack> itemlist;
	private final String name;

	public PokemonDropRecipe(List<ItemStack> list, String name) {

		this.name = name;
		this.itemlist = list;

	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		try {
			EntityPixelmon po = (EntityPixelmon) PixelmonEntityList.createEntityByName(name,
					Minecraft.getMinecraft().world);

			GuiInventory.drawEntityOnScreen(155, 110, 30, 150 - mouseX, 60 - mouseY, po);
			
			minecraft.fontRenderer.drawString(po.getName(), 12, 15,
					Color.BLACK.getRGB());

		} catch (Exception e) {

		}

	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setOutputs(VanillaTypes.ITEM, itemlist);
	}

}
