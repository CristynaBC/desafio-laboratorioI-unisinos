public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (mes == 2) {
            if (!verificaAnoBissexto()) {
                if (dia >= 1 && dia <= 28) {
                    this.dia = dia;
                    this.mes = mes;
                    this.ano = ano;
                } else {
                    System.out.println("Data inválida");
                    this.dia = 1;
                    this.mes = 1;
                    this.ano = 2000;
                }
            }
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia >= 1 && dia <= 31) {
                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia >= 1 && dia <= 30) {
                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
            }
        }

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean verificaAnoBissexto() {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }
}
