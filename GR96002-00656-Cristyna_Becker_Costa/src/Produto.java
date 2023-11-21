public class Produto {
    private String nome;
    private int preco;
    private Data dataValidade;

    public Produto(String nome, int preco, Data dataDeValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + "\nPreço: " + preco + "\nData de validade: " + dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(Data dataAtual) {
        if (dataAtual.getAno() > dataValidade.getAno()) {
            return true;
        } else if (dataAtual.getAno() == dataValidade.getAno() && dataAtual.getMes() > dataValidade.getMes()) {
            return true;
        } else return dataAtual.getAno() == dataValidade.getAno() && dataAtual.getMes() == dataValidade.getMes() &&
                dataAtual.getDia() > dataValidade.getDia();
    }

}
