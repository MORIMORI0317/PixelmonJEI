package net.morimori.pixelmonjei.jei.recipe.pokedex;

import java.util.ArrayList;
import java.util.List;


import com.pixelmongenerations.core.enums.EnumSpecies;
import mezz.jei.api.IJeiHelpers;

public class PokeDexRecipeMaker {
	public static List<PokeDexRecipe> getPokeDexRecipes(IJeiHelpers helpers) {

		List<PokeDexRecipe> recipes = new ArrayList<>();

		for (EnumSpecies poke : EnumSpecies.values()) {
			recipes.add(new PokeDexRecipe(poke));
		}

		return recipes;

	}
}
