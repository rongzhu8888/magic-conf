package pers.zr.magic.conf.common.httpclient;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * HTTPS请求
 */
public class SimpleHttpsClient extends SimpleHttpCore {

    private static SimpleHttpsClient simpleHttpsClient = new SimpleHttpsClient();
    private SimpleHttpsClient(){}

    public static SimpleHttpsClient getInstance() {
        return simpleHttpsClient;
    }

    @Override
    protected CloseableHttpClient createHttpClient() throws SimpleHttpException {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true; //信任所有
                }

            }).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new SimpleHttpException(e);
        }
    }


}
