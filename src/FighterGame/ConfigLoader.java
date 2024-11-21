package FighterGame;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Scanner;


public class ConfigLoader {



    public ConfigLoader() {
        loadConfigFile();


        loadConfig();
    }

    private void loadConfigFile() {
        SimpleModule deserializerModule = new SimpleModule("CustomDeserializer", new Version(1, 0, 0, null, null, null));
        deserializerModule.addDeserializer(Fighter.class, new CustomDeserializer(Fighter.class));
    }

    private void loadConfig() {

    }


}
