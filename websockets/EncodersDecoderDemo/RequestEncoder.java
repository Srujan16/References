import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by srujant on 29/9/16.
 */
public class RequestEncoder implements Encoder.Text<Request> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String encode(Request request) throws EncodeException {
        try {
            return objectMapper.writeValueAsString(request);
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
