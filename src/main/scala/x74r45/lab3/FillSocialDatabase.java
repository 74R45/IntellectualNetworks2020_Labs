package x74r45.lab3;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;

public class FillSocialDatabase implements AutoCloseable {
    private final Driver driver;

    public FillSocialDatabase(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() {
        driver.close();
    }

    public void fillDB() {
        try (Session session = driver.session()) {
            session.writeTransaction(tx -> {
                Result result = tx.run(
                        "CREATE (u1:User {name:'Herleif Marković'})" +
                        "CREATE (u2:User {name:'César Fosse'})" +
                        "CREATE (u3:User {name:'Syarhey Willemse'})" +
                        "CREATE (u4:User {name:'Darrel Anjema'})" +
                        "CREATE (u5:User {name:'Svarog Michaud'})" +
                        "CREATE (u6:User {name:'Libbie Fashingbauer'})" +
                        "CREATE (u7:User {name:'Ashtoret Hofmann'})" +
                        "CREATE (u8:User {name:'Florencia Krall'})" +
                        "CREATE (u9:User {name:'Lucia Eriksson'})" +
                        "CREATE (u10:User {name:'Akbar Branković'})" +
                        "CREATE (u11:User {name:'Haris Hopper'})" +
                        "CREATE (u12:User {name:'Rebekka Krüger'})" +
                        "CREATE (u13:User {name:'Costache Barends'})" +
                        "CREATE (u14:User {name:'Inge Nikolaev'})" +
                        "CREATE (u15:User {name:'Daniyah Hansen'})" +
                        "CREATE (u16:User {name:'Frida Close'})" +
                        "CREATE (u17:User {name:'Dortha Ivers'})" +
                        "CREATE (u18:User {name:'Atahualpa Traverse'})" +
                        "CREATE (u19:User {name:'Nehir Martel'})" +
                        "CREATE (u20:User {name:'Wigheard Nigel'})" +
                        "CREATE" +
                        "  (u1)-[:FRIENDS]->(u2)," +
                        "  (u1)-[:FRIENDS]->(u3)," +
                        "  (u1)-[:FRIENDS]->(u4)," +
                        "  (u1)-[:FRIENDS]->(u5)," +
                        "  (u1)-[:FRIENDS]->(u6)," +
                        "  (u2)-[:FRIENDS]->(u7)," +
                        "  (u2)-[:FRIENDS]->(u8)," +
                        "  (u2)-[:FRIENDS]->(u9)," +
                        "  (u2)-[:FRIENDS]->(u10)," +
                        "  (u2)-[:FRIENDS]->(u11)," +
                        "  (u3)-[:FRIENDS]->(u6)," +
                        "  (u3)-[:FRIENDS]->(u8)," +
                        "  (u3)-[:FRIENDS]->(u12)," +
                        "  (u3)-[:FRIENDS]->(u13)," +
                        "  (u4)-[:FRIENDS]->(u2)," +
                        "  (u4)-[:FRIENDS]->(u6)," +
                        "  (u4)-[:FRIENDS]->(u7)," +
                        "  (u4)-[:FRIENDS]->(u14)," +
                        "  (u4)-[:FRIENDS]->(u15)," +
                        "  (u5)-[:FRIENDS]->(u8)," +
                        "  (u5)-[:FRIENDS]->(u3)," +
                        "  (u5)-[:FRIENDS]->(u16)," +
                        "  (u5)-[:FRIENDS]->(u17)," +
                        "  (u5)-[:FRIENDS]->(u18)," +
                        "  (u6)-[:FRIENDS]->(u10)," +
                        "  (u6)-[:FRIENDS]->(u13)," +
                        "  (u6)-[:FRIENDS]->(u4)," +
                        "  (u6)-[:FRIENDS]->(u19)," +
                        "  (u6)-[:FRIENDS]->(u20)");
                return result.toString();
            });
        }
    }

    public static void main(String... args) {
        try (FillSocialDatabase filler =
                      new FillSocialDatabase("bolt://localhost:7687", "neo4j", "password")) {
            filler.fillDB();
        }
    }
}
