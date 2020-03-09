package io.daff.start;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * 新增操作
 *
 * @author daffupman
 * @since 2020/3/9
 */
public class Create {

    public static void main(String[] args) {
        try (
                MongoClient client = new MongoClient("127.0.0.1")
        ){
            MongoDatabase daff = client.getDatabase("daff");
            MongoCollection<Document> user = daff.getCollection("user");

            // 写入
            ArrayList<Student> students = Lists.newArrayList(
                    Student.builder()
                            .name("A")
                            .score(80)
                            .build(),

                    Student.builder()
                            .name("B")
                            .score(90)
                            .build(),

                    Student.builder()
                            .name("C")
                            .score(95)
                            .build()
            );

            students.forEach(each -> {
                Document d = new Document();
                d.put("name", each.getName());
                d.put("score", each.getScore());
                user.insertOne(d);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
