public class TUI implements TabUI{
    private char [][] tui;

    public TUI(){
        //iniciando tabuleiro
        tui= new char[17][17];
    }

    @Override
    public void desenheTabuleiro(char[][] tab) {
        
    
    }

    public void reiniciarTUI(){

        /* 
            desenho do tabuleiro 
            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
        0   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        1   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        2   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        3   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        4   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        5   #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #
        6   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        7   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        8   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        9   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        10  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        11  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #
        12  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        13  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        14  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        15  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        16  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
            
        */

        //primeiramente deixar o tabuleiro todo como espaço ' ' pra depois fazer o desenho:
        for(int l=0 ; l<tui.length ; l++){
            for(int c=0 ; c<tui.length ; c++){
                tui[l][c]= ' ';
            }
        }

        //desenhando:
        
        //em todas as linhas, as colunas 5 e 11 sao '#':
        for(int l=0 ; l<=16 ; l++){
            tui[l][5]= '#';
            tui[l][11]= '#';
        }

        // em todas as colunas, as linhas 5 e 11 sao '#':
        for(int c=0 ; c<=16 ; c++){
            tui[5][c]= '#';
            tui[11][c]= '#';
        }
    }
    
}
