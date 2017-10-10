/*
package com.mw.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BaseTest {
    // 与HBase数据库的连接对象
    Connection connection;

    // 数据库元数据操作对象
    Admin admin;

    @Before
    public void setUp() throws Exception {
        // 取得一个数据库连接的配置参数对象
        Configuration conf = HBaseConfiguration.create();
        // 设置连接参数：HBase数据库所在的主机IP
        conf.set("hbase.zookeeper.quorum", "192.168.126.130");
        // 设置连接参数：HBase数据库使用的端口
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        // 取得一个数据库连接对象
        connection = ConnectionFactory.createConnection(conf);
        // 取得一个数据库元数据操作对象
        admin = connection.getAdmin();
    }

    */
/**
     * 创建表
     *//*

    @Test
    public void createTable() throws IOException {
        System.out.println("---------------创建表 START-----------------");
        // 数据表表名
        String tableNameString = "javahbase";
        // 新建一个数据表表名对象
        TableName tableName = TableName.valueOf(tableNameString);
        // 如果需要新建的表已经存在
        if(admin.tableExists(tableName)){
            System.out.println("表已经存在！");
        } else{
            // 数据表描述对象
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            // 列族描述对象
            HColumnDescriptor family= new HColumnDescriptor("base");
            // 在数据表中新建一个列族
            hTableDescriptor.addFamily(family);
            // 新建数据表
            admin.createTable(hTableDescriptor);
        }
        System.out.println("---------------创建表 END-----------------");
    }

    */
/**
     * 插入数据
     *//*

    @Test
    public void insert() throws IOException{
        System.out.println("---------------插入数据 START-----------------");
        // 取得一个数据表对象
        Table table = connection.getTable(TableName.valueOf("t_book"));
        // 需要插入数据库的数据集合
        List<Put> putList = new ArrayList<Put>();
        Put put;
        // 生成数据集合
        for(int i = 0; i < 10; i++){
            put = new Put(Bytes.toBytes("row" + i));
            put.addColumn(Bytes.toBytes("base"), Bytes.toBytes("name"), Bytes.toBytes("bookName" + i));

            putList.add(put);
        }
        // 将数据集合插入到数据库
        table.put(putList);
        System.out.println("---------------插入数据 END-----------------");
    }

    */
/**
     * 查询整表数据
     *//*

    @Test
    public void queryTable() throws IOException{
        System.out.println("---------------查询整表数据 START-----------------");
        // 取得数据表对象
        Table table = connection.getTable(TableName.valueOf("t_book"));
        // 取得表中所有数据
        ResultScanner scanner = table.getScanner(new Scan());
        // 循环输出表中的数据
        for (Result result : scanner) {
            byte[] row = result.getRow();
            System.out.println("row key is:" + new String(row));
            List<Cell> listCells = result.listCells();
            for (Cell cell : listCells) {
                byte[] familyArray = cell.getFamilyArray();
                byte[] qualifierArray = cell.getQualifierArray();
                byte[] valueArray = cell.getValueArray();
                System.out.println("row value is:" + new String(familyArray) + new String(qualifierArray)
                        + new String(valueArray));
            }
        }
        System.out.println("---------------查询整表数据 END-----------------");
    }
}
*/
