import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by srujant on 29/9/16.
 */
public class DecoderUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Request getObject(String message) {
        try {
            return objectMapper.readValue(message, Request.class);
        } catch (IOException e) {
            throw new RuntimeException("JsonCasting exception");
        }
    }

}
