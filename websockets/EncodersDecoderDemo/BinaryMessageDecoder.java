import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.nio.ByteBuffer;

/**
 * Created by srujant on 29/9/16.
 */
public class BinaryMessageDecoder implements Decoder.Binary<Request> {
    @Override
    public Request decode(ByteBuffer byteBuffer) {
        String message = new String(byteBuffer.array());
        return DecoderUtil.getObject(message);
    }

    @Override
    public boolean willDecode(ByteBuffer byteBuffer) {
        return byteBuffer != null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }
}
