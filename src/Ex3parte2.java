class Ex3parte2 {
    public static void main(String[] args) {
// =========================
// IMAGEM 2: Torre Eiffel
// =========================
        // Pais
        Pais pais = new Pais("Brasil", 200000000, "America do Sul");
        pais.viajar();

        // Edificio
        Edificio ediificio = new Edificio("Ferro", 330, 1000000.0);
        ediificio.construir();

        // Arvore
        Arvore arvore = new Arvore(15.5, 80, "Carvalho");
        arvore.plantar();
    }
}

class Pais {
    private String nacionalidade;
    private int habitantes;
    private String continente;

    public Pais(String nacionalidade, int habitantes, String continente) {
        this.nacionalidade = nacionalidade;
        this.habitantes = habitantes;
        this.continente = continente;
    }

    public void viajar() {
        System.out.println("Viajando pelo " + nacionalidade + " localizado na " + continente + " com mais de "+ habitantes + " habitantes");
    }
}

class Edificio {
    private String material;
    private double altura;
    private double valor;

    public Edificio(String material, double altura, double valor) {
        this.material = material;
        this.altura = altura;
        this.valor = valor;
    }

    public void construir() {
        System.out.println("Construindo edifício de " + material + " com altura " + altura + " que custará " + valor);
    }
}

class Arvore {
    private double tamanho;
    private int idade;
    private String especie;

    public Arvore(double tamanho, int idade, String especie) {
        this.tamanho = tamanho;
        this.idade = idade;
        this.especie = especie;
    }

    public void plantar() {
        System.out.println("Plantando árvore da espécie " + especie + " que normalmente chega a " +  tamanho + " metros de altura e " + idade + " anos");
    }
}
