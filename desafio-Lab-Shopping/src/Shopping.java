import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "Nome do Shopping: " + nome + "\nEndereço do Shopping: " + endereco + "\nLojas do Shopping: " + Arrays.toString(lojas);
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;

    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoDeLoja) {
        if (tipoDeLoja.equals("Informática")) {
            tipoDeLoja = "Informatica";
        }
        int total = 0;
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i].getClass().getSimpleName().equals(tipoDeLoja)) {
                total++;

            }
        }
        if (total != 0) {
            return total;
        }
        return -1;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojamaisCara = null;
        double maiorValorSeguro = 0;
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getClass().getSimpleName().equals("Informatica")) {
                Informatica lojaInformatica = (Informatica) lojas[i];
                if (lojaInformatica.getSeguroEletronicos() > maiorValorSeguro) {
                    maiorValorSeguro = lojaInformatica.getSeguroEletronicos();
                    lojamaisCara = lojaInformatica;
                }
            }

        }
        return lojamaisCara;
    }
}
