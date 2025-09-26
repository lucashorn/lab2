import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    private static final String[] NOMES = {"João", "Maria", "José", "Ana", "Carlos", "Paula", "Pedro", "Lucia"};
    private static final String[] PARTIDOS = {"UP", "PSOL", "PCB", "PCdoB", "PT", "PSTU", "PDT"};

    public static void main(String[] args) {
        Random random = new Random();
        int tamanho = random.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[tamanho];

        // Preenche o array com candidatos aleatórios
        for (int i = 0; i < candidatos.length; i++) {
            String nome = NOMES[random.nextInt(NOMES.length)];
            String partido = PARTIDOS[random.nextInt(PARTIDOS.length)];
            int votos = random.nextInt(1000);
            candidatos[i] = new Candidato(nome, partido, votos);
        }

        // Ordena os candidatos
        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);
        ordenaCandidatosPorNome(candidatos);

        // Imprime os candidatos ordenados
        System.out.println("Candidatos ordenados:");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        // Pesquisa binária
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nDigite o nome do candidato a pesquisar: ");
            String nomePesquisa = scanner.nextLine();

            int posicao = pesquisaBinariaCandidatos(candidatos, nomePesquisa);
            if (posicao != -1) {
                System.out.println("Candidato encontrado na posição " + posicao + ": " + candidatos[posicao]);
            } else {
                System.out.println("Candidato não encontrado.");
            }
        }
    }

    // Método de ordenação por nome (Inserção Direta)
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            
            while (j >= 0 && candidatos[j].getNome().compareTo(chave.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    // Método de ordenação por votos (Seleção Direta - decrescente)
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        for (int i = 0; i < candidatos.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j].getIntencoesVotos() > candidatos[max].getIntencoesVotos()) {
                    max = j;
                }
            }
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[max];
            candidatos[max] = temp;
        }
    }

    // Método de ordenação por partido (Inserção Direta)
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            
            while (j >= 0 && candidatos[j].getPartido().compareTo(chave.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    // Método de pesquisa binária
    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int esquerda = 0;
        int direita = candidatos.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int comparacao = candidatos[meio].getNome().compareTo(nome);

            if (comparacao == 0) {
                // Encontrou, verifica se há duplicatas à esquerda
                while (meio > 0 && candidatos[meio - 1].getNome().equals(nome)) {
                    meio--;
                }
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}