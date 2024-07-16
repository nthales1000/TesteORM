import java.util.List;

public class TesteProdutoDAO {
    public static void main(String[] args) throws Exception {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        ProdutoDAO produtoDAO = new ProdutoDAO(databaseHelper);

        // Criar um novo produto
        Produto produto = new Produto("Arroz", 5.99, 10);
        produtoDAO.create(produto);

        // Recuperar produto pelo ID
        Produto produtoRecuperado = produtoDAO.retrieve(produto.getId());
        System.out.println("Produto Recuperado: " + produtoRecuperado.getNome());

        // Atualizar produto
        produtoRecuperado.setPreco(6.49);
        produtoDAO.update(produtoRecuperado);

        // Recuperar todos os produtos
        List<Produto> produtos = produtoDAO.retrieveAll();
        produtos.forEach(p -> System.out.println("Produto: " + p.getNome() + " - Preço: " + p.getPreco()));

        // Deletar produto
        produtoDAO.delete(produtoRecuperado.getId());

        // Fechar conexão com o banco de dados
        databaseHelper.close();
    }
}

