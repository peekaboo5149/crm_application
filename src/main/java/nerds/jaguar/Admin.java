package nerds.jaguar;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;

public class Admin {

    private Long id;
    private String role_name;

    public Admin() {
    }

    public Admin(Long id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public Admin(String role_name) {
        this.role_name = role_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public static Multi<Admin> findAll(PgPool client) {

        return client.query("SELECT id,role_name FROM G_ADM_ROLE ORDER BY role_name DESC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(Admin::from);

    }

    public static Uni<Integer> count(PgPool client) {
        return client.query("SELECT COUNT(*) FROM G_ADM_ROLE").execute()
                .onItem().transform(m -> m.iterator().hasNext() ? count(m.iterator().next()) : null);
    }

    private static Admin from(Row row) {
        return new Admin(row.getLong("id"), row.getString("role_name"));
    }

    private static Integer count(Row row) {
        return row.getInteger("count");
    }

}
