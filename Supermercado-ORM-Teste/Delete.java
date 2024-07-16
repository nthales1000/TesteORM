public class Delete {
    public static void main(String[] args) throws Exception {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        ProdutoDAO produtoDAO = new ProdutoDAO(databaseHelper);

        // Deletar produto pelo ID
        produtoDAO.delete(1L); // Supondo que o ID seja 1

        // Fechar conexão com o banco de dados
        databaseHelper.close();
    }
}
