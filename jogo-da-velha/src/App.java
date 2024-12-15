public class App {
    public static void main(String[] args) throws Exception {
        Tabuleiro t= new Tabuleiro(new Jogador('X'), new Jogador('O'));
        TUI tui= new TUI();
        while(t.getNumJogadas()<9){
            if(t.jogar()){
                t.exibirTabuleiro();
                tui.desenheTabuleiro(t.getTabuleiro());
                System.out.println();
            }

        }
    }
}
