import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Labirinto {
    private char[][] labirinto;

    public void criaLabirinto(String filename) {
        List<String> lines = new ArrayList<>();
        
        // Lê o arquivo e armazena as linhas em uma lista
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Arquivo vazio");
        }
        
        int linhas = lines.size();
        int colunas = lines.get(0).length();
        
        // Cria a matriz com o número de linhas e colunas
        labirinto = new char[linhas][colunas];
       
        for (int i = 0; i < linhas; i++) {
            String linhaAtual = lines.get(i);
             // Verificação para garantir que todas as linhas tenham o mesmo comprimento
            if (linhaAtual.length() != colunas) {
                throw new IllegalArgumentException("Todas as linhas devem ter o mesmo comprimento");
            }

            // Converte a linha atual em um array de caracteres e armazena na matriz
            labirinto[i] = linhaAtual.toCharArray();
        }
    }

    // Método público para iniciar a iteração
    public boolean percorreLabirinto() {
        if (labirinto == null || labirinto.length == 0 || labirinto[0].length == 0) {
            return false;
        }

        boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];
        return percorreRecursivo(0, 0, visitado);
    }

    private boolean percorreRecursivo(int linha, int coluna, boolean[][] visitado) {
        // Verifica se a posição atual está fora dos limites da matriz
        if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length) {
            return false;
        }

        // Verifica se a posição atual é uma parede ou já foi visitada
        if (labirinto[linha][coluna] == 'X' || visitado[linha][coluna]) {
            return false;
        }

        // Verifica se a posição atual é a saída
        if (labirinto[linha][coluna] == 'D') {
            return true;
        }

        // Marca a posição atual como visitada
        visitado[linha][coluna] = true;

        // Chama recursivamente as direções: cima, baixo, esquerda e direita
        boolean cima = percorreRecursivo(linha - 1, coluna, visitado);
        boolean baixo = percorreRecursivo(linha + 1, coluna, visitado);
        boolean esquerda = percorreRecursivo(linha, coluna - 1, visitado);
        boolean direita = percorreRecursivo(linha, coluna + 1, visitado);

        boolean encontrouCaminho = cima || baixo || esquerda || direita;
        
        visitado[linha][coluna] = false;

        return encontrouCaminho;
    }
}