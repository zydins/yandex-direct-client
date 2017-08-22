package ru.cultserv.adv.yandex.direct.v5.impl;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ProxyServer;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.YandexDirect;
import ru.cultserv.adv.yandex.direct.v5.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.v5.util.requests.YandexDirectMethodCaller;

import javax.net.ssl.SSLContext;

/**
 * @author Sergey Zudin
 * @since 26.10.15.
 */
public class YandexDirectFactory {

    public interface InitialBuilder {
        ProxyBuilder sslContext(SSLContext context);
        ProxyBuilder token(AuthToken token);
    }

    public interface ProxyBuilder extends FinalBuilder {
        FinalBuilder proxy(ProxyServer server);
    }

    public interface FinalBuilder {
        FinalBuilder timeout(int millis);
        FinalBuilder client(String clientLogin);
        YandexDirect build();
    }

    public static class YandexDirectBuilder implements InitialBuilder, ProxyBuilder, FinalBuilder {

        private AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        private AuthToken token;
        private String clientLogin = null;

        @Override
        public ProxyBuilder sslContext(SSLContext context) {
            builder.setSSLContext(context);
            token = new AuthToken(null);
            return this;
        }

        @Override
        public ProxyBuilder token(AuthToken token) {
            this.token = token;
            return this;
        }

        @Override
        public FinalBuilder proxy(ProxyServer server) {
            builder.setProxyServer(server);
            return this;
        }

        @Override
        public FinalBuilder timeout(int millis) {
            builder.setRequestTimeoutInMs(millis);
            builder.setConnectionTimeoutInMs(millis);
            builder.setIdleConnectionInPoolTimeoutInMs(millis);
            builder.setIdleConnectionTimeoutInMs(millis);
            return this;
        }

        /**
         * Вызов данного параметра подразумевает, что данный объект будет использоваться как агентский аккаунт
         * Он будет тратить свои баллы на вызов методов под видом аккаунта, логин которого передается в качестве
         * параметра.
         */
        @Override
        public FinalBuilder client(String login) {
            clientLogin = login;
            return this;
        }

        @Override
        public YandexDirect build() {
            AsyncHttpClientConfig config = builder.build();
            AsyncHttpClient httpClient = AsyncClientFactory.createHttpClient(config);
            YandexDirectMethodCaller methodCaller = YandexDirectMethodCaller.prepared(token, clientLogin, httpClient);
            return new YandexDirectImpl(methodCaller);
        }
    }

    public static InitialBuilder builder() {
        return new YandexDirectBuilder();
    }

}
