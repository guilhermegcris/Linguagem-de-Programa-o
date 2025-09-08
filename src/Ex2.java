class Ex2 {
    public static void main(String[] args) {
// ======================
// MÚSICA: Corra, Djonga
// ======================

        // Povo
        Povo povo = new Povo("Comunidade", "medo", 100);
        povo.existir();

        // Emprego
        Emprego emprego = new Emprego("Professor", 2500.0, "Noturno");
        emprego.exercer();

        // Dinheiro
        Dinheiro dinheiro = new Dinheiro(5000.0, "alto", "BRL");
        dinheiro.comprar();
    }
}


    class Povo {
         private String nome;
         private String sentimento;
         private int quantidade;

         public Povo(String nome, String sentimento, int quantidade) {
             this.nome = nome;
             this.sentimento = sentimento;
             this.quantidade = quantidade;
         }

         public void existir() {
             System.out.println(nome + " existe com sentimento de " + sentimento + " e possui " + quantidade + " habitantes.");
         }
     }
     class Emprego {
    private String cargo;
    private double salario;
    private String turno;

    public Emprego(String cargo, double salario, String turno) {
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }

    public void exercer() {
        System.out.println("Exercendo cargo de " + cargo + " no turno " + turno + " com salário " + salario);
    }
}

class Dinheiro {
    private double valor;
    private String poderAquisitivo;
    private String moeda;

    public Dinheiro(double valor, String poderAquisitivo, String moeda) {
        this.valor = valor;
        this.poderAquisitivo = poderAquisitivo;
        this.moeda = moeda;
    }

    public void comprar() {
        System.out.println("Comprando uma bicicleta por " + valor + " " + moeda + " (poder aquisitivo " + poderAquisitivo + ")");
    }
}
