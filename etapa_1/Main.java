public class Main {
    public static void main(String[] args) {
        executaLabirinto("labirinto1.txt");
        executaLabirinto("labirinto2.txt");
        executaLabirinto("labirinto3.txt");
        executaLabirinto("labirinto4.txt");
    }

    private static void executaLabirinto(String nomeArquivo) {
        Labirinto lab = new Labirinto();
        lab.criaLabirinto(nomeArquivo);
        boolean resultado = lab.percorreLabirinto();

        System.out.println(nomeArquivo + " tem saída? " + resultado);
        
    }
}