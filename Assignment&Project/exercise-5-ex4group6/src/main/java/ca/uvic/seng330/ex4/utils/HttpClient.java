package ca.uvic.seng330.ex4.utils;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClient {

    public static HttpRequestFactory FACTORY = new NetHttpTransport().createRequestFactory();

    private String url;
    private Map<String, Object> defaultParams;

    public HttpClient(String url) {
        this(url, null);
    }

    public HttpClient(String url, Map<String, Object> defaultParams) {
        this.url = url;
        this.defaultParams = defaultParams;
    }

    private static GenericUrl setParams(GenericUrl url, Map<String, Object> params) {
        if (params == null) return url;
        for (Entry<String, Object> pair : params.entrySet()) {
            url = url.set(pair.getKey(), pair.getValue());
        }
        return url;
    }

    private GenericUrl buildUrl(String path, Map<String, Object> params) {
        GenericUrl url = new GenericUrl(this.url + path);
        url = setParams(url, defaultParams);
        url = setParams(url, params);
        return url;
    }

    public HttpRequest get(String path) throws IOException {
        return get(path, null);
    }

    public HttpRequest get(String path, Map<String, Object> params) throws IOException {
        return FACTORY.buildGetRequest(buildUrl(path, params));
    }
}
