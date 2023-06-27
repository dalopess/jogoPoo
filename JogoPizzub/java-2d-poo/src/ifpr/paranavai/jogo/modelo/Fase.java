package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener, KeyListener {
    private Image fundo;
    private Personagem personagem;
    private static final int DELAY = 5;
    private Timer timer;
    private static final int LARGURA_JANELA = 938;
    private boolean atirar = true;

    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon("recursos\\fundo.jpg");
        this.fundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();

        addKeyListener(new TecladoAdp());
        timer = new Timer(DELAY, (ActionListener) this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);

        ArrayList<Tiro> tiros = personagem.getTiros();

        for (Tiro tiro : tiros) {
            tiro.carregar();
            graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();

        ArrayList<Tiro> tiros = personagem.getTiros();

        for (int i = 0; i < tiros.size(); i++) {
            if (tiros.get(i).getPosicaoEmX() > LARGURA_JANELA)
                tiros.remove(i);
            else
                tiros.get(i).atualizar();
        }

        repaint();
    }

    private class TecladoAdp extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            personagem.mover(e);
        }

        public void keyReleased(KeyEvent e) {
            personagem.parar(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else
            personagem.mover(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            atirar = true;

        personagem.parar(e);
    }
}
