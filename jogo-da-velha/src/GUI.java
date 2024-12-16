import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class GUI {
    private JFrame jPrinc;
    private JPanel jp[];
    private JButton jb[];
    private ImageIcon imgX, imgO;

    public GUI(){
        jPrinc= new JFrame("Jogo Da Velha");

        jp= new JPanel[9];
        jb= new JButton[9];
        imgX= new ImageIcon("src/imagens/X.png");
        imgO= new ImageIcon("src/imagens/O.png");

        jPrinc.getContentPane().setLayout(new GridLayout(3,3, 10, 10));

        for (int i=0; i<jp.length; i++) {
            jp[i]= new JPanel();
            jb[i]= new JButton();
            
            jb[i].setBackground(Color.BLACK);
            jp[i].setBackground(Color.BLACK);

            jp[i].setLayout(new BorderLayout());

            jp[i].add(jb[i]);
            jPrinc.add(jp[i], i);
        }
        
        jPrinc.setSize(600,600);
        jPrinc.setVisible(true);

        this.zerarTabuleiroGUI();
    }

    public void atualizarTabuleiro(char tabuleiro[][]){
        for(int l=0; l<tabuleiro.length; l++){
            for(int c=0; c<tabuleiro.length; c++){
                addCaractere(l, c, tabuleiro[l][c]);
            }
        }
    }

    private void addCaractere(int linha, int coluna, char caractere){
        if(caractere!='*'){
            jb[linha*3+coluna].setIcon(caractere=='X'? imgX : imgO);
        }
    }

    public void zerarTabuleiroGUI(){
        for(int i=0; i< jb.length; i++){
            jb[i].setIcon(null);
        }
    }

}
