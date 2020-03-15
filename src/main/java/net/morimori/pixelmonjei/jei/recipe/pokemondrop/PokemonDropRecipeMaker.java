package net.morimori.pixelmonjei.jei.recipe.pokemondrop;

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

				recipes.add(new PokemonDropRecipe(po.name,
						getDropItem(pif, "mainDrop"), getDropItem(pif, "rareDrop"),
						getDropItem(pif, "optDrop1"), getDropItem(pif, "optDrop2"),
						getDropItemMin(pif, "mainDrop"), getDropItemMax(pif, "mainDrop"),
						getDropItemMin(pif, "rareDrop"), getDropItemMax(pif, "rareDrop"),
						getDropItemMin(pif, "optDrop1"), getDropItemMax(pif, "optDrop1"),
						getDropItemMin(pif, "optDrop2"), getDropItemMax(pif, "optDrop2")));

			} catch (Exception e) {

			}
		}

		return recipes;
	}

	private static ItemStack getDropItem(PokemonDropInformation dropinfo, String name) {

		try {
			ItemStack stack = ObfuscationReflectionHelper
					.getPrivateValue(PokemonDropInformation.class, dropinfo, name);
			stack.setCount(1);
			return stack;
		} catch (Exception e) {
			return ItemStack.EMPTY;
		}

	}

	private static int getDropItemMin(PokemonDropInformation dropinfo, String name) {
		try {
			return ObfuscationReflectionHelper
					.getPrivateValue(PokemonDropInformation.class, dropinfo, name + "Min");
		} catch (Exception e) {
			return 0;
		}
	}

	private static int getDropItemMax(PokemonDropInformation dropinfo, String name) {
		try {
			return ObfuscationReflectionHelper
					.getPrivateValue(PokemonDropInformation.class, dropinfo, name + "Max");
		} catch (Exception e) {
			return 0;
		}
	}
}
