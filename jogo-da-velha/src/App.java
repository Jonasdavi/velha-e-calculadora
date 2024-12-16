public class App {
    public static void main(String[] args) throws Exception {
        Jogador j = new Jogador('X');
        Jogador j2= new Jogador('O');

        Tabuleiro t=  new Tabuleiro(j, j2);
        TUI tui= new TUI();
        GUI gui= new GUI();

        char vencedor= '*';
        do { 
            if(t.jogar()){
                //t.exibirTabuleiro();
                Thread.sleep(1100);

                for (int i=0; i < 15; i++) {
                    System.out.println();
                }
                
                System.out.println("Jogada: " + t.getNumJogadas());
                tui.desenheTabuleiro(t.getTabuleiro());
                gui.atualizarTabuleiro(t.getTabuleiro());
                
                if(t.getNumJogadas()>4){
                    vencedor= t.verificarVencedor();
                }
            }
            
        }while(t.getNumJogadas()<9 && vencedor=='*');
        if(vencedor=='*'){
            System.out.println("Deu velha!");
        }
        else{
            System.out.println("Vencedor: " + vencedor);
        }

    }
}
