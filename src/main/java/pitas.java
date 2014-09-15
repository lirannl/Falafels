import com.liran.pitas.proxy.IProxy;
import com.liran.pitas.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class pitas
{
    public static Configuration configFile;
 @Mod.Instance(Reference.MOD_ID)
 public static pitas instance;

 @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
 public static IProxy proxy;
  {

  }

 @Mod.EventHandler
 public void preInit(FMLPreInitializationEvent event)
 {
  File file = event.getSuggestedConfigurationFile();
     configFile = new Configuration(event.getSuggestedConfigurationFile());

     syncConfig();
 }
    public static void syncConfig() {
        myConfigInteger = configFile.getInt("My Config Integer", Configuration.CATEGORY_GENERAL, myConfigInteger, 0, Integer.MAX_VALUE, "An Integer!");
        myConfigString = configFile.getString("My Config String", Configuration.CATEGORY_GENERAL, myConfigString, "A String!");
        myConfigBool = configFile.getBoolean("My Config Bool", Configuration.CATEGORY_GENERAL, myConfigBool, "A Boolean!");

        if(configFile.hasChanged())
            configFile.save();
    }
 @Mod.EventHandler
 public void init(FMLInitializationEvent event)
 {

 }
 @Mod.EventHandler
 public void postInit(FMLPostInitializationEvent event)
 {

 }
}
