package net.morimori.pixelmonjei.jei.recipe.evolutions;

import java.util.ArrayList;
import java.util.List;


import com.pixelmongenerations.common.entity.pixelmon.stats.evolution.Evolution;
import com.pixelmongenerations.core.enums.EnumSpecies;
import mezz.jei.api.IJeiHelpers;
import net.morimori.pixelmonjei.util.PokemonHelper;

public class EvolutionsRecipeMaker {
	public static List<EvolutionsRecipe> getEvolutionsRecipes(IJeiHelpers helpers) {
		List<EvolutionsRecipe> recipes = new ArrayList<>();

		for (EnumSpecies pkm : EnumSpecies.values()) {

			for (Evolution po : PokemonHelper.getEvolutions(pkm)) {

				if (po != null)
					recipes.add(new EvolutionsRecipe(pkm, po.to.getSpecies(), po.conditions));

			}
		}

		return recipes;
	}

}
