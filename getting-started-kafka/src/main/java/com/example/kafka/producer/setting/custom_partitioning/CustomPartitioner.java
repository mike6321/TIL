package com.example.kafka.producer.setting.custom_partitioning;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.internals.StickyPartitionCache;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 총 Partition 개수 : 5
 *
 * 대형매장 : "P001" - Partition 2개 할당
 *
 * 나머지매장 - Partition 3개 할당
 * "A001", "B001", "C001", "D001", "E001", "F001", "G001", "H001", "I001", "J001", "K001", "L001", "M001", "N001", "O001", "Q001"
 * */
public class CustomPartitioner implements Partitioner {

     public static final Logger logger = LoggerFactory.getLogger(CustomPartitioner.class.getName());
     private final StickyPartitionCache stickyPartitionCache = new StickyPartitionCache();
     private String specialKeyName;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        int numSpecialPartitions = (int)(numPartitions * 0.5);
        int partitionIndex = 0;

        if ((keyBytes == null) || (!(key instanceof String))) {
            stickyPartitionCache.partition(topic, cluster);
        }

        assert key instanceof String;
        if (((String)key).equals(this.specialKeyName)) {
            partitionIndex = Utils.toPositive(Utils.murmur2(valueBytes)) % numSpecialPartitions;
        } else {
            // [0, 1, 2] + 2
            assert keyBytes != null;
            partitionIndex = Utils.toPositive(Utils.murmur2(keyBytes)) % (numPartitions - numSpecialPartitions) + numSpecialPartitions;
        }

        logger.info("key:{} is sent to partition:{}", key.toString(), partitionIndex);
        return partitionIndex;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {
        this.specialKeyName = configs.get("specialKey").toString();
    }

}
