package net.morimori.pixelmonjei.jei.recipe.pokeanvil;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelmonmod.pixelmon.items.ItemPokeballLid;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PokeAnvilRecipeMaker {
	public static List<PokeAnvilRecipe> getPokeAnvilRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();

		List<PokeAnvilRecipe> recipes = new ArrayList<>();

		PokeAnvilRecipe recipe1 = new PokeAnvilRecipe(PixelmonItems.aluminiumIngot, PixelmonItems.aluminiumPlate);
		PokeAnvilRecipe recipe2 = new PokeAnvilRecipe(PixelmonItemsPokeballs.aluDisc, PixelmonItemsPokeballs.aluBase);
		PokeAnvilRecipe recipe3 = new PokeAnvilRecipe(PixelmonItemsPokeballs.ironDisc, PixelmonItemsPokeballs.ironBase);

		recipes.add(recipe1);
		recipes.add(recipe2);
		recipes.add(recipe3);

		for (Item itm : ForgeRegistries.ITEMS) {

			if (itm instanceof ItemPokeballLid) {
				PokeAnvilRecipe recipe = new PokeAnvilRecipe(
						PixelmonItemsPokeballs.getDiscFromEnum(((ItemPokeballLid) itm).pokeball),
						itm);
				recipes.add(recipe);
			}

		}

		return recipes;
	}
}
