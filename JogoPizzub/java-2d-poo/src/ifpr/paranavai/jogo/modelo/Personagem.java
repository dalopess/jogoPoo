package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;
    private static final int DESLOCAMENTO = 3;
    private static final int POSICAO_INICIAL_EM_X = 50;
    private static final int POSICAO_INICIAL_EM_Y = 409;
    private ArrayList<Tiro> tiros;

    public Personagem() {
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
    }

    public void atualizar() {
        this.posicaoEmX = this.posicaoEmX + this.deslocamentoEmX;
        this.posicaoEmY = this.posicaoEmY + this.deslocamentoEmY;
    }

    public void atirar() {
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImagem / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\Personagem.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            case KeyEvent.VK_A: // Adicionado tratamento para a tecla A
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_D: // Adicionado tratamento para a tecla D
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            default:
                break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_A: // Adicionado tratamento para a tecla A
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D: // Adicionado tratamento para a tecla D
                this.deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public int getPosicaoEmX() {
        return posicaoEmX;
    }

    public int getPosicaoEmY() {
        return posicaoEmY;
    }

    public Image getImagem() {
        return imagem;
    }

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }
}
