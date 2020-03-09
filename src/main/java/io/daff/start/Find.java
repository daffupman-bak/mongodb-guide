package io.daff.start;

import com.google.common.collect.Maps;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;

/**
 * mongodb：查询操作
 *
 * @author daffupman
 * @since 2020/3/9
 */
public class Find {

    public static void main(String[] args) {
        // 创建连接
        MongoClient client = new MongoClient("127.0.0.1");
        // 获取操作的数据库
        MongoDatabase daff = client.getDatabase("daff");
        // 获取集合
        MongoCollection<Document> user = daff.getCollection("user");
        // 查询所有文档
        FindIterable<Document> documents = user.find();
        for (Document document : documents) {
            System.out.println(document.toJson());
        }

        // 按添加查询,一个条件
        BasicDBObject bson = new BasicDBObject("name", "A");
        FindIterable<Document> targetDocument = user.find(bson);
        for (Document document : targetDocument) {
            System.out.println(document.toJson());
        }
        final Document first = user.find().first();
        System.out.println(first.toJson());
        // 按添加查询,多个条件
        HashMap<Object, Object> conditions = Maps.newHashMap();
        conditions.put("name", "zj");
        conditions.put("age", 19);
        Document zj = user.find(new BasicDBObject(conditions)).first();
        System.out.println(zj.toJson());
        client.close();
    }
}
