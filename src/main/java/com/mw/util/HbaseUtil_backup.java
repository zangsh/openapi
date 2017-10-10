package com.mw.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hbase工具类
 *
 * @author zangsh
 */
public class HbaseUtil_backup {

    private static final Logger logger = LoggerFactory.getLogger(HbaseUtil_backup.class);
    public static Configuration configuration;

    static {
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("hbase.zookeeper.quorum", "192.168.126.130");
    }

    public static void createTable(String tableNameParam) {
        List<String> list = new ArrayList<String>();
        list.add("AOKE");
        createTable(tableNameParam, list);
    }
    /**
     * 创建hbase表
     * 参数自动转大写
     * 默认列族为  澳客（AOKE）
     *
     * @param tableNameParam 表名
     * @param familyNames    列族
     */
    public static void createTable(String tableNameParam, List<String> familyNames) {
        logger.info("start create table");
        try {
            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
            TableName tableName = TableName.valueOf(tableNameParam.toUpperCase());
            // 如果需要新建的表已经存在
            if (hBaseAdmin.tableExists(tableName)) {
                logger.info(tableName + " 表已经存在.");
            } else {
                // 数据表描述对象
                HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
                if (familyNames.size() > 0) {
                    // 列族描述对象
                    Iterator<String> iterator = familyNames.iterator();
                    while (iterator.hasNext()) {
                        HColumnDescriptor family = new HColumnDescriptor(iterator.next().toUpperCase());
                        hTableDescriptor.addFamily(family);
                    }
                } else {
                    HColumnDescriptor family = new HColumnDescriptor("AOKE");
                    hTableDescriptor.addFamily(family);
                }
                // 新建数据表
                hBaseAdmin.createTable(hTableDescriptor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
