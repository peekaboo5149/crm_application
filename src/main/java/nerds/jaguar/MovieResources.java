package nerds.jaguar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;

@Path("admin")
public class MovieResources {

    @Inject
    PgPool client;

    @PostConstruct
    void config() {
        initDb();
    }

    @GET
    @Path("all")
    public Multi<Admin> getAll() {
        return Admin.findAll(client);
    }

    @GET
    @Path("count")
    public Uni<Integer> count() {
        return Admin.count(client);
    }

    private void initDb() {

        client.query("DROP TABLE IF EXISTS G_ADM_ROLE").execute()
                .flatMap(m -> client.query("CREATE TABLE G_ADM_ROLE (id SERIAL PRIMARY KEY,role_name TEXT NOT NULL)")
                        .execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('G.Thomas Kennedy')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Nutan Shah')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Dreick Brain')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Peter Patrick')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Cramelia N. Nathan')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('P.T.Thomas')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Israel Benedict')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Piyush Mehta')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Rajiv Gandhi')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Pragya Thakur')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Alok Ranjan')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Harry Potter')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Patrick P. Jackson')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Samuel L Jackson')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('J.D.Lee')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('King Harris')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('India Jones')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Jonas Samuel')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Jack Darwin')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Danny Jade')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Karina Olson')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Scarllet Johnsan')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Tony W Stark')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Tom Mario Riddle')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Ashutosh Gawrikar')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('G.M Noss')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Ponter Picle')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Lesli Oker')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Thomas N Jackus')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Dericl Brick')").execute())
                .flatMap(m -> client.query("INSERT INTO G_ADM_ROLE (role_name) VALUES('Adam Apple')").execute())
                .await()
                .indefinitely();
    }

}