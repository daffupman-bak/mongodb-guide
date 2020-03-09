package io.daff.start;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Mongo的删除操作
 *
 * @author daffupman
 * @since 2020/3/9
 */
public class Remove {

    public static void main(String[] args) {
        try (MongoClient client = new MongoClient("127.0.0.1")){
            MongoCollection<Document> user = client.getDatabase("daff").getCollection("user");
            user.deleteOne(new BasicDBObject("name", "C"));
            user.deleteOne(Filters.eq("name", "B"));
        }
    }
}
