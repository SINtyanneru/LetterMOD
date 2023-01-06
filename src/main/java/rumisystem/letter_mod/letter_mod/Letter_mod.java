package rumisystem.letter_mod.letter_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Objects;
import java.util.logging.Logger;

@Mod(
        modid = Letter_mod.MOD_ID,
        name = Letter_mod.MOD_NAME,
        version = Letter_mod.VERSION
)
public class Letter_mod {

    public static final String MOD_ID = "letter_mod";
    public static final String MOD_NAME = "Letter_mod";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Letter_mod INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Letter MOD By RumiSystem and Rumisan:" + MOD_ID);
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
        /*
            public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
        */
        public static Block LatinLetter_A = new Block(Material.ROCK)
                .setRegistryName(MOD_ID, "latin_letter_A_block")/*登録名の設定*/
                .setCreativeTab(CreativeTabs.MISC)/*クリエのタブ*/
                .setTranslationKey("block_latin_letter_A")/*システム名の設定*/
                .setHardness(1.5F)/*硬さ*/
                .setResistance(1.0F)/*爆破耐性*/;                                                 //ラテン文字のA
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
        /*
            public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
            public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
        */
        public static ItemBlock LatinLetter_A = (ItemBlock) new ItemBlock(Blocks.LatinLetter_A).setRegistryName("latin_letter_A");//ラテン文字のA
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
           /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
            event.getRegistry().registerAll(Items.LatinLetter_A);
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
           /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */

            event.getRegistry().registerAll(Blocks.LatinLetter_A);
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event){
            ModelLoader.setCustomModelResourceLocation(Items.LatinLetter_A, 0, new ModelResourceLocation(Items.LatinLetter_A.getRegistryName(), "inventory"));
        }
    }

    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
