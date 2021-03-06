import Userpos.Userposjava;
import Userpos.UserposjavaDao;
import org.junit.Test;

import java.util.List;

public class SingleConnectionTest {

    @Test
    public void initBanco() {
        UserposjavaDao userposDao = new UserposjavaDao();
        Userposjava userposjava = new Userposjava();

        userposjava.setId(8L);
        userposjava.setNome("tototonho");
        userposjava.setEmail("tototonho@gmail.com");

        userposDao.salvar(userposjava);

    }

    @Test
    public void initListar() {
        UserposjavaDao dao = new UserposjavaDao();
        try {
            List<Userposjava> list = dao.listar();
            for (Userposjava userposjava : list) {
                System.out.println(userposjava);
                System.out.println("**********************************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
