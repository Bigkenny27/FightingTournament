package FighterGame;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


public class CustomDeserializer extends StdDeserializer<Fighter> {
    public CustomDeserializer(Class<Fighter> fighter) {
        super(fighter);
    }


    @Override
    public Fighter deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        String fighterName = node.get("name").asText();
        JsonNode fighterStatlineNode = node.get("statline");
        if (fighterStatlineNode.isArray()) {
            // TODO: add a check

            //search through all values and append them to a list 
        }
        


        
    }

}