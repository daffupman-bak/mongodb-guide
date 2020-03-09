package io.daff.start;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * mongdb的更新最终
 *
 * @author daffupman
 * @since 2020/3/9
 */
public class Update {

    public static void main(String[] args) {
        try (MongoClient client = new MongoClient("127.0.0.1")){
            MongoCollection<Document> user = client.getDatabase("daff").getCollection("user");
            user.updateMany(
                    Filters.eq("name", "A"),
                    new Document("$set", new Document("name", "a"))
            );
        }
    }
}
