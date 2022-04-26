package com.knoldus.kafka.connect.connector;

import com.knoldus.kafka.connect.connector.config.RandomLongSourceConnectorConfig;
import com.knoldus.kafka.connect.connector.util.Version;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;

public class RandomLongSourceConnector extends SourceConnector {

    private RandomLongSourceConnectorConfig randomLongSourceConnectorConfig;

    @Override
    public void start(Map<String, String> props) {
        randomLongSourceConnectorConfig = new RandomLongSourceConnectorConfig(props);
    }

    @Override
    public void stop() {}

    @Override
    public Class<? extends Task> taskClass() {
        return RandomLongSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> configs = new ArrayList<>(maxTasks);
        for (int i = 0; i < maxTasks; i++) {
            Map<String, String> config = new HashMap<>(3);
            config.put(RandomLongSourceConnectorConfig.API_URL_CONFIG, randomLongSourceConnectorConfig.getString(RandomLongSourceConnectorConfig.API_URL_CONFIG));
            config.put(RandomLongSourceConnectorConfig.SLEEP_CONFIG, Integer.toString(randomLongSourceConnectorConfig.getInt(RandomLongSourceConnectorConfig.SLEEP_CONFIG)));
            config.put(RandomLongSourceConnectorConfig.TOPIC_CONFIG, randomLongSourceConnectorConfig.getString(RandomLongSourceConnectorConfig.TOPIC_CONFIG));
            configs.add(config);
        }
        return configs;
    }

    @Override
    public ConfigDef config() {
        return RandomLongSourceConnectorConfig.config();
    }

    @Override
    public String version() {
        return Version.getVersion();
    }

}
