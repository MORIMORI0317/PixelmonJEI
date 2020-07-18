package net.morimori.pixelmonjei.util;

import com.pixelmongenerations.common.entity.pixelmon.Entity1Base;
import com.pixelmongenerations.common.entity.pixelmon.Entity3HasStats;
import com.pixelmongenerations.common.entity.pixelmon.stats.evolution.Evolution;
import com.pixelmongenerations.core.enums.EnumSpecies;
import com.pixelmongenerations.core.enums.EnumType;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;

import java.util.Arrays;

public class PokemonHelper {
    public static String getPokemonDisplayName(String pokename) {

        String name = Entity1Base.getLocalizedName(EnumSpecies.get(pokename));

        if (PokemonHelper.isLegendary(EnumSpecies.get(pokename)))
            name = TextFormatting.AQUA + name;

        return name;
    }

    public static String getPokemonDisplayName(EnumSpecies poke) {
        return getPokemonDisplayName(poke.name);
    }

    public static String getPokemoDescription(EnumSpecies poke) {

        return I18n.format("pixelmon." + poke.name.toLowerCase() + ".description");
    }

    public static boolean isLegendary(EnumSpecies poke) {
        return Arrays.asList(EnumSpecies.LEGENDARY_ENUMS).contains(poke);
    }

    public static EnumType getType1(EnumSpecies poke) {

        return Entity3HasStats.getBaseStats(poke).get().type1;

    }

    public static EnumType getType2(EnumSpecies poke) {

        return Entity3HasStats.getBaseStats(poke).get().type2;

    }

    public static String getTypeDisplayName(EnumType type) {
        String name = type.getLocalizedName();
        return name;
    }

    public static int getCatchRate(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().catchRate;
    }

    public static int getAttack(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().attack;
    }

    public static int getSpAtt(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().spAtt;
    }

    public static int getDefence(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().defence;
    }

    public static int getSpDef(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().spDef;
    }

    public static int getSpeed(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().speed;
    }

    public static int getBaseExp(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().baseExp;
    }

    public static int getHp(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().hp;
    }

    public static int getMalePercent(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().malePercent;
    }

    public static int getSpawnLevel(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().spawnLevel;
    }

    public static int getSpawnLevelRange(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().spawnLevelRange;
    }

    public static int getBaseFriendship(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().baseFriendship;
    }

    public static float getHeight(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().height;
    }

    public static float getWidth(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().width;
    }

    public static float getLength(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().length;
    }

    public static float getGiScale(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().giScale;
    }

    public static EnumSpecies[] getPreEvolutions(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().preEvolutions;
    }

    public static Evolution[] getEvolutions(EnumSpecies poke) {
        return Entity3HasStats.getBaseStats(poke).get().evolutions;
    }
}
