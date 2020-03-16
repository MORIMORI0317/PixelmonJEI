package net.morimori.pixelmonjei.util;

import java.util.Arrays;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity1Base;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity3HasStats;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;

import net.minecraft.client.resources.I18n;
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

	public static String getPokemoDescription(EnumPokemon poke) {

		return I18n.format("pixelmon." + poke.name.toLowerCase() + ".description");
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

	public static String getTypeDisplayName(EnumType type) {
		String name = type.getLocalizedName();
		return name;
	}

	public static int getCatchRate(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().catchRate;
	}

	public static int getAttack(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().attack;
	}

	public static int getSpAtt(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().spAtt;
	}

	public static int getDefence(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().defence;
	}

	public static int getSpDef(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().spDef;
	}

	public static int getSpeed(EnumPokemon poke) {
		return Entity3HasStats.getBaseStats(poke).get().speed;
	}
}
