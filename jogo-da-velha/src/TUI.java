public class TUI implements TabUI{
    private int qtCharCaractere; //quantidade de char de cada caractere para representar X ou O em relacao a linha ou coluna
    private int tamanhoDesenho; //quantidade de colunas ou linhas do desenho total

    private final int GROSSURALINHA= 1; //quantidades de caracteres da grossura da linha do desenho
    private final int ESPACO= 1; //quantidade de espaço ao redor do desenho do caractere X ou O

    private char[][] tabTui;
    
    public TUI(){
        qtCharCaractere=5; //definindo tamanho do desenho que representará 'X' ou 'O'


        tamanhoDesenho= qtCharCaractere*3 + ESPACO*6 + GROSSURALINHA*2;

        tabTui= new char[tamanhoDesenho][tamanhoDesenho];
        reiniciarTui();
    }


    @Override
    public void desenheTabuleiro(char[][] tab) {

        for (int l = 0; l < tab.length; l++) {
            for (int c = 0; c < tab.length; c++) {
                desenhePosicao(l, c, tab[l][c]);
            }
        }

        for (int l = 0; l < tabTui.length; l++) {
            for (int c = 0; c < tabTui.length; c++) {
                System.out.print(tabTui[l][c]);
            }
            System.out.println();
        }
        
    }

    private void desenhePosicao(int linha, int coluna, char caractere){
        if(caractere=='X'){ 
            int linhaInicial= GROSSURALINHA + (qtCharCaractere+ESPACO*2+GROSSURALINHA)*linha; //linha onde o desenho se inicia TUI
            int colunaInicial= GROSSURALINHA + (qtCharCaractere+ESPACO*2+GROSSURALINHA)*coluna; //coluna onde o desenho se inicia na TUI

            int linhaTermino= qtCharCaractere+(qtCharCaractere+ESPACO*2+GROSSURALINHA)*linha; //linha onde o desenho se termina TUI
            int colunaTermino= qtCharCaractere+(qtCharCaractere+ESPACO*2+GROSSURALINHA)*coluna; //coluna onde o desenho se termina na TUI

            for(int i=0; i<qtCharCaractere; i++){
                //primeira diagonal do X:
                tabTui[linhaInicial+i][colunaInicial+i]= caractere;  

                //segunda diagonal do X:
                tabTui[linhaInicial+i][colunaTermino-i]= caractere; 
            }
        }
        else if(caractere=='O'){
            for(int l=0; l<qtCharCaractere; l++){
                for (int c=0; c<qtCharCaractere; c++) {
                    if(l==0 && c!=0 && c!=qtCharCaractere-1 || l==qtCharCaractere-1 && c!=0 && c!=qtCharCaractere-1|| c==0 && l!=0 && l!=qtCharCaractere-1|| c==qtCharCaractere-1 && l!=0 && l!=qtCharCaractere-1){
                        tabTui[l+1+(qtCharCaractere+3)*linha][c+1+(qtCharCaractere+3)*coluna]= caractere;
                    }
                }
            }
        }
    }

    public void reiniciarTui(){
        for (int l = 0; l < tabTui.length; l++) {
            for (int c = 0; c < tabTui.length; c++) {
                //linhas do desenho:
                if(l== ESPACO*2 + qtCharCaractere || l== ESPACO*4 + qtCharCaractere*2 + GROSSURALINHA
                || c== ESPACO*2 + qtCharCaractere || c== ESPACO*4 + qtCharCaractere*2 + GROSSURALINHA){
                    tabTui[l][c]='#';
                }
                else{
                    tabTui[l][c]=' ';
                }
            }
        }
    }
    
}