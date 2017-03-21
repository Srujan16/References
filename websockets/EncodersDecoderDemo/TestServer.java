import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by srujant on 29/9/16.
 */

@ServerEndpoint(value = "/echoServer_Db",
        encoders = {ResponseEncoder.class},
        decoders = {TextMessageDecoder.class, BinaryMessageDecoder.class})
public class TestServer {

    @OnOpen
    public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText("Connected to network");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void onMessage(Request request, Session session) {
        try {
            session.getBasicRemote().sendObject(new Response(request.getResponse()));
        } catch (IOException e) {
            throw new RuntimeException("e");
        } catch (EncodeException e) {
            throw new RuntimeException("Failed to encode String to object");
        }
    }

    @OnClose
    public void onClose(Session session) {
        try {
            session.getBasicRemote().sendText("Connection Disconnected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
