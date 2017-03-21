
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by srujant on 29/9/16.
 */
public class Request {
    private String table;
    private String method;
    private String action;
    private String pathParam;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getResponse() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            if (RequestUtil.GET.equalsIgnoreCase(method)) {
                response = httpClient.execute(new HttpGet(getRequestUrl()));
            } else if (RequestUtil.POST.equalsIgnoreCase(method)) {
                response = httpClient.execute(new HttpPost(getRequestUrl()));
            } else if (RequestUtil.DELETE.equalsIgnoreCase(method)) {
                response = httpClient.execute(new HttpDelete(getRequestUrl()));
            } else if (RequestUtil.PUT.equalsIgnoreCase(method)) {
                response = httpClient.execute(new HttpPut(getRequestUrl()));
            } else {
                throw new RuntimeException("Unknown method type");
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer stringBuffer = new StringBuffer();
            String message;

            while ((message = bufferedReader.readLine()) != null) {
                stringBuffer.append(message);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRequestUrl() {

        if ("".equals(action) && "".equals(pathParam)) {
            return RequestUtil.CONTEXT_PATH;
        } else if (!"".equals(action) && "".equals(pathParam)) {
            return RequestUtil.CONTEXT_PATH + "/" + action;
        } else if ("".equals(action) && !"".equals(pathParam)) {
            return RequestUtil.CONTEXT_PATH + "/" + pathParam;
        } else {
            return RequestUtil.CONTEXT_PATH + "/" + pathParam + "/" + action;
        }
    }
}
