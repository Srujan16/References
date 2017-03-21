import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by srujant on 30/9/16.
 */
public class ResponseEncoder implements Encoder.Text<Response> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String encode(Response response) throws EncodeException {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonParsingException");
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
