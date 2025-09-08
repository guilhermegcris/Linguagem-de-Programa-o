class Ex3part11 {
    public static void main(String[] args) {
// =========================
// IMAGEM 1: The Bearer Irma
// =========================
        // Pessoa
        Pessoa pessoa = new Pessoa("João", 40, "Africana");
        pessoa.carregar();

        // Lixo
        Lixo lixo = new Lixo(10, "Reciclável", "Metal");
        lixo.coletar();

        // Tecido
        Tecido tecido = new Tecido(50.0, "Algodão", 0.5);
        tecido.fabricar();
    }
}

        class Pessoa {
            private String nome;
            private int idade;
            private String etnia;

            public Pessoa(String nome, int idade, String etnia) {
                this.nome = nome;
                this.idade = idade;
                this.etnia = etnia;
            }

            public void carregar() {
                System.out.println(nome + " tem " + idade + " anos e tem origem " + etnia);
            }
        }

        class Lixo {
            private int quantidade;
            private String tipo;
            private String material;

            public Lixo(int quantidade, String tipo, String material) {
                this.quantidade = quantidade;
                this.tipo = tipo;
                this.material = material;
            }

            public void coletar() {
                System.out.println("Coletando " + quantidade + " quilos de lixo " + tipo + " (" + material + ")");
            }
        }

        class Tecido {
            private double valor;
            private String material;
            private double grossura;

            public Tecido(double valor, String material, double grossura) {
                this.valor = valor;
                this.material = material;
                this.grossura = grossura;
            }

            public void fabricar() {
                System.out.println("Fabricando tecido de " + material + " com grossura " + grossura);
            }
        }
