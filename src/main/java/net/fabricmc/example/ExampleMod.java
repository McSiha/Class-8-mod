package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.Enchant.Bleeding_blade;
import net.fabricmc.example.Item.Item;
import net.fabricmc.example.Item.weapons.watch_sword;
import net.fabricmc.example.block.TEST_SihaModTestBlock;
import net.fabricmc.example.effects.BLOOD;
import net.fabricmc.example.entity.Chest_Monster;
import net.fabricmc.example.sound.Sounds;
import net.fabricmc.example.world.structure.laoda_temple;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.structure.StructureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final String Version = "alpha 0.1.0";
	public static final String Mod_Name = "Class 8 Mod";
	//食物引用
	public static final net.minecraft.item.Item WATCH = new net.minecraft.item.Item(new FabricItemSettings().food(Item.WATCH));	//手表
	//基尼太美唱片
	public static final net.minecraft.item.Item MUSIC_DISC_CXK = new MusicDiscItem(13, Sounds.CXK_MUSIC, new net.minecraft.item.Item.Settings().maxCount(1).rarity(Rarity.RARE), 149);
	public static final net.minecraft.item.Item ENCH_GOLD_WATCH = new net.minecraft.item.Item(new FabricItemSettings().food(Item.ENCH_GOLD_WATCH)); //附魔金手表
	public static final net.minecraft.item.Item SHOU_ZE = new net.minecraft.item.Item(new FabricItemSettings().food(Item.SHOU_ZE));  //守则
	public static final ItemGroup MOD_GROUP = FabricItemGroup.builder(new Identifier("modid","mod_group")).icon(() -> new ItemStack(WATCH)).build();
	public static Enchantment BLEEDING_BLADE = new Bleeding_blade();  //出血附魔
	public static final StatusEffect BLOOD = new BLOOD();
	public static final TEST_SihaModTestBlock TEST = new TEST_SihaModTestBlock(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).hardness(1.14f));
	//测试矿石
	public static final RegistryKey<PlacedFeature> TEST_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("modid","test_ore"));
	//手表碎片
	public static final net.minecraft.item.Item WATCH_PIECE = new net.minecraft.item.Item(new FabricItemSettings());
	//手表剑
	public static ToolItem WATCH_SWORD = new SwordItem(watch_sword.INSTANCE, 4, 3F, new net.minecraft.item.Item.Settings());
	//TEST箱子怪实体
	public static final EntityType<Chest_Monster> CHEST_MONSTER = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("modid", "chest_monster"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Chest_Monster::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build()
	);
	public static final SpawnEggItem CHEST_MONSTER_SPAWN_EGG = new SpawnEggItem(CHEST_MONSTER, 0x10c, 0x10c, new FabricItemSettings());
	//牢大神殿
	public static  StructureType<laoda_temple> LAODA_TEMPLE;
	@Override
	public void onInitialize() {
		//Watch主程序注册
		Registry.register(Registries.ITEM, new Identifier("modid","watch"), WATCH);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.addAfter(Items.GOLDEN_CARROT,WATCH);
		});
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(WATCH);
		});
		//EnchGoldenWatch主程序注册
		Registry.register(Registries.ITEM,new Identifier("modid","ench_gold_watch"),ENCH_GOLD_WATCH);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
					content.addAfter(Items.ENCHANTED_GOLDEN_APPLE,ENCH_GOLD_WATCH);
		});
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(ENCH_GOLD_WATCH);
		});
		//守则主程序注册
		Registry.register(Registries.ITEM,new Identifier("modid","shou_ze"),SHOU_ZE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.addAfter(Items.ROTTEN_FLESH,SHOU_ZE);
		});
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(SHOU_ZE);
		});
		//手表碎片
		Registry.register(Registries.ITEM, new Identifier("modid", "watch_piece"), WATCH_PIECE);
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(WATCH_PIECE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.NETHERITE_INGOT, WATCH_PIECE);
		});
		//手表剑
		Registry.register(Registries.ITEM, new Identifier("modid", "watch_sword"), WATCH_SWORD);
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(WATCH_SWORD);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addAfter(Items.NETHERITE_SWORD, WATCH_SWORD);
		});
		//远古手表对应物品注册
		Registry.register(Registries.ITEM, new Identifier("modid", "test"), new BlockItem(TEST, new FabricItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(TEST);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
			content.addAfter(Items.DEEPSLATE_DIAMOND_ORE, TEST);
		});
		//箱子怪对应刷怪蛋注册
		Registry.register(Registries.ITEM, new Identifier("modid", "chest_monster_spawn_egg"), CHEST_MONSTER_SPAWN_EGG);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
			content.addAfter(Items.WARDEN_SPAWN_EGG, CHEST_MONSTER_SPAWN_EGG);
		});
		//基尼太美
		Registry.register(Registries.ITEM, new Identifier("modid", "music_disc_cxk"), MUSIC_DISC_CXK);
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.addAfter(TEST, MUSIC_DISC_CXK);
		});

		//Mod_Item物品组注册
		ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
			content.add(WATCH);
		});


		//血之利刃附魔注册
		Registry.register(Registries.ENCHANTMENT, new Identifier("modid", "bleeding_blade"),BLEEDING_BLADE);


		//流血效果注册
		Registry.register(Registries.STATUS_EFFECT, new Identifier("modid","blood"),BLOOD);


		//远古手表方块注册
		Registry.register(Registries.BLOCK, new Identifier("modid", "test"), TEST);


		//Watch_World注册
		RegistryKey<World> TUTORIAL_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD,
				new Identifier("modid","watch_world"));
		RegistryKey<DimensionType> TUTORIAL_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
				new Identifier("modid","watch_world"));


		//远古手表矿石生成注册
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TEST_ORE);
		LOGGER.info("Console:梦开始的地方");


		//箱子怪实体注册
		FabricDefaultAttributeRegistry.register(CHEST_MONSTER, Chest_Monster.createMobAttributes());


		//牢大神殿
		LAODA_TEMPLE = Registry.register(Registries.STRUCTURE_TYPE, new Identifier("modid", "laoda_temple"), () -> laoda_temple.CODEC);
	}
}
