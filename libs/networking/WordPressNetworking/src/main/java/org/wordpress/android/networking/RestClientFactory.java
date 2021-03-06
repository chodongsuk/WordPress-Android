package org.wordpress.android.networking;

import com.android.volley.RequestQueue;
import com.wordpress.rest.RestClient;

import org.wordpress.android.util.AppLog;
import org.wordpress.android.util.AppLog.T;

public class RestClientFactory {
    public static RestClientFactoryAbstract sFactory;

    public static RestClient instantiate(RequestQueue queue) {
        return instantiate(queue, RestClient.REST_CLIENT_VERSIONS.V1);
    }

    public static RestClient instantiate(RequestQueue queue, RestClient.REST_CLIENT_VERSIONS version) {
        if (sFactory == null) {
            sFactory = new RestClientFactoryDefault();
        }
        AppLog.v(T.UTILS, "instantiate RestClient using sFactory: " + sFactory.getClass());
        return sFactory.make(queue, version);
    }
}
