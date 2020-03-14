package net.morimori.pixelmonjei.jei.pokemondrop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pixelmonmod.pixelmon.entities.npcs.registry.DropItemRegistry;
import com.pixelmonmod.pixelmon.entities.npcs.registry.PokemonDropInformation;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class PokemonDropRecipeMaker {
	public static List<PokemonDropRecipe> getPokemonDropRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();

		List<PokemonDropRecipe> recipes = new ArrayList<>();

		HashMap<EnumPokemon, PokemonDropInformation> pifl = ObfuscationReflectionHelper
				.getPrivateValue(DropItemRegistry.class, null, "pokemonDrops");

		ArrayList<ItemStack> tier1 = ObfuscationReflectionHelper
				.getPrivateValue(DropItemRegistry.class, null, "megaDrops");

		//	recipes.add(new PokemonDropRecipe(tier1, "naidesu"));

		for (EnumPokemon po : EnumPokemon.values()) {
			try {

				PokemonDropInformation pif = pifl.get(po);

				recipes.add(new PokemonDropRecipe(po.name, getDropItem(pif, "mainDrop"), getDropItem(pif, "rareDrop"),
						getDropItem(pif, "optDrop1"), getDropItem(pif, "optDrop2")));
			} catch (Exception e) {

			}
		}

		return recipes;
	}

	private static ItemStack getDropItem(PokemonDropInformation dropinfo, String name) {

		try {
			ItemStack stack = ObfuscationReflectionHelper
					.getPrivateValue(PokemonDropInformation.class, dropinfo, name);
			stack.setCount(ObfuscationReflectionHelper
					.getPrivateValue(PokemonDropInformation.class, dropinfo, name + "Max"));
			return stack;
		} catch (Exception e) {
			return ItemStack.EMPTY;
		}

	}
}
