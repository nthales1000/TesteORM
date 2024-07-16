import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO {
    private Dao<Produto, Long> produtoDao;

    public ProdutoDAO(DatabaseHelper databaseHelper) {
        try {
            produtoDao = DaoManager.createDao(databaseHelper.getConnectionSource(), Produto.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Produto produto) {
        try {
            produtoDao.create(produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto retrieve(Long id) {
        try {
            return produtoDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produto> retrieveAll() {
        try {
            return produtoDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Produto produto) {
        try {
            produtoDao.update(produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            produtoDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

