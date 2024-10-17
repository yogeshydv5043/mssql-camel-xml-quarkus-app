package org.tech.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;

@ApplicationScoped
public class JmsConfiguration {

    @Inject
    @ConfigProperty(name = "jsm.config.broker.url")
    String brokerUrl;

    @Inject
    @ConfigProperty(name = "jsm.config.username")
    String username;

    @Inject
    @ConfigProperty(name = "jsm.config.password")
    String password;

    @Inject
    @ConfigProperty(name = "jsm.config.max.connections")
    int maxConnections;

    @Inject
    @ConfigProperty(name = "jsm.config.max.sessions.per.connection")
    int maxSessionsPerConnection;

    @Produces
    public JmsPoolConnectionFactory createPooledConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        activeMQConnectionFactory.setUserName(username);
        activeMQConnectionFactory.setPassword(password);

        JmsPoolConnectionFactory pooledConnectionFactory = new JmsPoolConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
        pooledConnectionFactory.setMaxConnections(maxConnections);
        pooledConnectionFactory.setMaxSessionsPerConnection(maxSessionsPerConnection);
        pooledConnectionFactory.start();
        return pooledConnectionFactory;
    }


}
