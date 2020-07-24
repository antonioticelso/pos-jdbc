package Userpos;

import conexaojdbc.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserposjavaDao {

    private Connection connection;

    public UserposjavaDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar (Userposjava userposjava) {

        try {
            String sql = "insert into userposjava (id, nome, email)" +
                    " values (?, ?, ?)";

            PreparedStatement insert = connection
                    .prepareStatement(sql);
            insert.setLong(1, userposjava.getId());
            insert.setString(2, userposjava.getNome());
            insert.setString(3, userposjava.getEmail());
            insert.execute();
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public List<Userposjava> listar() throws Exception {
        List<Userposjava> list = new ArrayList<Userposjava>();

        String sql = "select  * from userposjava";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) {
            Userposjava userposjava = new Userposjava();
            userposjava.setId(resultado.getLong("id"));
            userposjava.setNome(resultado.getString("nome"));
            userposjava.setEmail(resultado.getString("email"));

            list.add(userposjava);
        }
        return list;
    }
}
