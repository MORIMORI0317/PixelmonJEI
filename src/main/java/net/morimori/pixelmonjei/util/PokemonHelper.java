package net.morimori.pixelmonjei.util;

import java.util.Arrays;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity1Base;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity3HasStats;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;

import net.minecraft.util.text.TextFormatting;

public class PokemonHelper {
	public static String getPokemonDisplayName(String pokename) {

		String name = Entity1Base.getLocalizedName(EnumPokemon.get(pokename));

		if (PokemonHelper.isLegendary(EnumPokemon.get(pokename)))
			name = TextFormatting.AQUA + name;

		return name;
	}

	public static String getPokemonDisplayName(EnumPokemon poke) {
		return getPokemonDisplayName(poke.name);
	}

	public static boolean isLegendary(EnumPokemon poke) {
		return Arrays.asList(EnumPokemon.LEGENDARY_ENUMS).contains(poke);
	}

	public static EnumType getType1(EnumPokemon poke) {

		return Entity3HasStats.getBaseStats(poke).get().type1;

	}

	public static EnumType getType2(EnumPokemon poke) {

		return Entity3HasStats.getBaseStats(poke).get().type2;

	}
}
