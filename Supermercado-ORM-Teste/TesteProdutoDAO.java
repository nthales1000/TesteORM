import java.util.List;

public class TesteProdutoDAO {
    public static void main(String[] args) throws Exception {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        ProdutoDAO produtoDAO = new ProdutoDAO(databaseHelper);

        // Criar um novo produto
        Produto produto = new Produto("Arroz", 5.99, 10);
        produtoDAO.create(produto);
        System.out.println("Produto criado: " + produto.getNome());

        // Recuperar produto pelo ID
        Produto produtoRecuperado = produtoDAO.retrieve(produto.getId());
        if (produtoRecuperado != null) {
            System.out.println("Produto Recuperado: " + produtoRecuperado.getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }

        // Atualizar produto
        if (produtoRecuperado != null) {
            produtoRecuperado.setPreco(6.49);
            produtoDAO.update(produtoRecuperado);
            System.out.println("Produto atualizado: " + produtoRecuperado.getNome() + " - Novo preço: " + produtoRecuperado.getPreco());
        }

        // Recuperar todos os produtos
        List<Produto> produtos = produtoDAO.retrieveAll();
        System.out.println("Lista de produtos:");
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome() + " - Preço: " + p.getPreco());
        }

        // Deletar produto
        if (produtoRecuperado != null) {
            produtoDAO.delete(produtoRecuperado.getId());
            System.out.println("Produto deletado: " + produtoRecuperado.getNome());
        }

        // Fechar conexão com o banco de dados
        databaseHelper.close();
    }
}
