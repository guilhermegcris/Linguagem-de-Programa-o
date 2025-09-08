class Ex5 {
    public static void main(String[] args) {

// =========================
// VÍDEO: QUEM É O JOGADOR PROFISSIONAL? Feat. Vampeta
// =========================

        Jogador jogador = new Jogador("Atacante", 28, "Vampeta");
        jogador.ser();

        Chuteira chuteira = new Chuteira(599.90, 42, "Nike");
        chuteira.comprar();

        Prancheta prancheta = new Prancheta("Madeira", "Alta", "Tática");
        prancheta.escrever();
    }
}

class Jogador {
    private String trabalho;
    private int idade;
    private String nome;

    public Jogador(String trabalho, int idade, String nome) {
        this.trabalho = trabalho;
        this.idade = idade;
        this.nome = nome;
    }

    public void ser() {
        System.out.println(nome + " é jogador, trabalha como " + trabalho);
    }
}

class Chuteira {
    private double preco;
    private double tamanho;
    private String marca;

    public Chuteira(double preco, double tamanho, String marca) {
        this.preco = preco;
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public void comprar() {
        System.out.println("Comprando chuteira do tamanho" + tamanho + "da marca " + marca + " por R$" + preco);
    }
}

class Prancheta {
    private String material;
    private String durabilidade;
    private String tipo;

    public Prancheta(String material, String durabilidade, String tipo) {
        this.material = material;
        this.durabilidade = durabilidade;
        this.tipo = tipo;
    }

    public void escrever() {
        System.out.println("Escrevendo na prancheta de " + material);
    }
}
