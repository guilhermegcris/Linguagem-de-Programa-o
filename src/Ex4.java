class Ex4 {
    public static void main(String[] args) {
// =========================
// IMAGEM 3: Amarula Cup
// =========================

        Animal animal = new Animal("Elefante", 2.5, "frutas");
        animal.comer();

        Bebida bebida = new Bebida(15, 17.5, "Whisky");
        bebida.beber();

        Copo copo = new Copo("Vidro", 30.0, 500);
        copo.encher();
    }
}

class Animal {
    private String especie;
    private double tamanho;
    private String alimentacao;

    public Animal(String especie, double tamanho, String alimentacao) {
        this.especie = especie;
        this.tamanho = tamanho;
        this.alimentacao = alimentacao;
    }

    public void comer() {
        System.out.println("O " + especie + " tem " + tamanho + " metros e está se alimentando de " + alimentacao);
    }
}

class Bebida {
    private int idade;
    private double teorAlcoolico;
    private String sabor;

    public Bebida(int idade, double teorAlcoolico, String sabor) {
        this.idade = idade;
        this.teorAlcoolico = teorAlcoolico;
        this.sabor = sabor;
    }

    public void beber() {
        System.out.println("Bebendo " + sabor + " de " + idade + " anos com teor alcoólico " + teorAlcoolico + "%");
    }
}

class Copo {
    private String material;
    private double preco;
    private int quantidade;

    public Copo(String material, double preco, int quantidade) {
        this.material = material;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void encher() {
        System.out.println("Encher o copo de " + material + " de " + quantidade + "ml no bar custa R$" + preco + "reais" );
    }
}
