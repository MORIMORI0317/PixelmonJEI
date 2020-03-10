package net.morimori.pixelmonjei.jei.pokemondrop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pixelmonmod.pixelmon.entities.npcs.registry.DropItemRegistry;
import com.pixelmonmod.pixelmon.entities.npcs.registry.PokemonDropInformation;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class PokemonDropRecipeMaker {
	public static List<PokemonDropRecipe> getPokemonDropRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();

		List<PokemonDropRecipe> recipes = new ArrayList<>();

		HashMap<EnumPokemon, PokemonDropInformation> pifl = ObfuscationReflectionHelper
				.getPrivateValue(DropItemRegistry.class, null, "pokemonDrops");

		for (EnumPokemon po : EnumPokemon.values()) {
			try {

				PokemonDropInformation pif = pifl.get(po);

				recipes.add(new PokemonDropRecipe(pif.getDrops(null), po.name));
			} catch (Exception e) {

			}
		}

		return recipes;
	}
}
