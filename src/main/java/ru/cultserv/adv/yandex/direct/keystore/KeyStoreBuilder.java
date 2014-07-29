package ru.cultserv.adv.yandex.direct.keystore;

import com.google.common.base.Preconditions;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class KeyStoreBuilder {

    public static interface CertificateResourceBuilder {
        CertificatePasswordBuilder certificate(String fileName);
        CertificatePasswordBuilder certificate(InputStream stream);
        KeyStoreResourceBuilder trusted();
    }

    public static interface CertificatePasswordBuilder {
        KeyStoreResourceBuilder certificatePassword(String password);
    }

    public static interface KeyStoreResourceBuilder {
        KeyStorePasswordBuilder resource(String fileName);
        KeyStorePasswordBuilder resource(InputStream stream);
    }

    public static interface KeyStorePasswordBuilder {
        KeyStorePreparedBuilder password(String password);
    }

    public static interface KeyStorePreparedBuilder {
        SSLContext build();
    }

    public static class Builder implements CertificateResourceBuilder, CertificatePasswordBuilder, KeyStoreResourceBuilder, KeyStorePasswordBuilder, KeyStorePreparedBuilder {

        private TrustManager[] trustManagers;
        private KeyManager[] keyManagers;
        private InputStream keyStoreStream;
        private InputStream certificateStream;

        @Override
        public CertificatePasswordBuilder certificate(String fileName) {
            this.certificateStream = load(fileName);
            return this;
        }

        @Override
        public CertificatePasswordBuilder certificate(InputStream stream) {
            Preconditions.checkNotNull(stream);
            this.certificateStream = stream;
            return this;
        }

        @Override
        public KeyStoreResourceBuilder trusted() {
            this.trustManagers = SSLKeyStoreHelper.TRUST_ALL_MANAGERS;
            return this;
        }

        @Override
        public KeyStoreResourceBuilder certificatePassword(String password) {
            Preconditions.checkNotNull(certificateStream);
            Preconditions.checkNotNull(password);

            try {
                KeyStore keyStore = SSLKeyStoreHelper.getKeyStore(certificateStream, password);
                this.trustManagers = SSLKeyStoreHelper.getTrustManagers(keyStore);
                return this;
            } catch (GeneralSecurityException | IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public KeyStorePreparedBuilder password(String password) {
            Preconditions.checkNotNull(password);

            try {
                KeyStore keyStore = SSLKeyStoreHelper.getKeyStore(keyStoreStream, password);
                this.keyManagers = SSLKeyStoreHelper.getKeyManagers(keyStore, password);
                return this;
            } catch (GeneralSecurityException | IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public KeyStorePasswordBuilder resource(String fileName) {
            this.keyStoreStream = load(fileName);
            return this;
        }

        @Override
        public KeyStorePasswordBuilder resource(InputStream stream) {
            Preconditions.checkNotNull(stream);
            this.keyStoreStream = stream;
            return this;
        }

        @Override
        public SSLContext build() {
            Preconditions.checkNotNull(keyManagers);
            Preconditions.checkNotNull(trustManagers);

            try {
                SSLContext sslContext = SSLContext.getInstance(SSLKeyStoreHelper.PROTOCOL);
                sslContext.init(keyManagers, trustManagers, new SecureRandom());
                return sslContext;
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static InputStream load(String fileName) {
        Preconditions.checkNotNull(fileName);

        try {
            return new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public static CertificateResourceBuilder builder() {
        return new Builder();
    }
}
