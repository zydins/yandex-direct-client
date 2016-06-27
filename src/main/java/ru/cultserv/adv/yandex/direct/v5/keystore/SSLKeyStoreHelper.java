package ru.cultserv.adv.yandex.direct.v5.keystore;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class SSLKeyStoreHelper {

    public static final String TYPE = "JKS";
    public static final String PROTOCOL = "TLS";
    public static final String PROVIDER = "SunJSSE";
    public static final String ALGORITHM = "SunX509";

    protected static final X509TrustManager TRUST_ALL_MANAGER = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    protected static final TrustManager[] TRUST_ALL_MANAGERS = new TrustManager[]{TRUST_ALL_MANAGER};

    protected static KeyStore getKeyStore(InputStream keystore, String keystorePassword) throws GeneralSecurityException, IOException {
        KeyStore ks = KeyStore.getInstance(TYPE);
        ks.load(keystore, keystorePassword.toCharArray());
        return ks;
    }

    protected static TrustManager[] getTrustManagers(KeyStore ks) throws GeneralSecurityException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(ALGORITHM, PROVIDER);
        factory.init(ks);
        return factory.getTrustManagers();
    }

    protected static KeyManager[] getKeyManagers(KeyStore ks, String password) throws GeneralSecurityException {
        KeyManagerFactory factory = KeyManagerFactory.getInstance(ALGORITHM);
        factory.init(ks, password.toCharArray());
        return factory.getKeyManagers();
    }
}
