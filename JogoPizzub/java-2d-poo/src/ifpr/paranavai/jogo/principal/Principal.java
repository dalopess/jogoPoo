package ifpr.paranavai.jogo.principal;

import javax.swing.JFrame;

import ifpr.paranavai.jogo.modelo.Fase;

public class Principal extends JFrame {
    public Principal() {
        Fase fase = new Fase();
        super.add(fase);
        super.setTitle("Zombizza ");
        super.setSize(1030, 554);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);

    }

    public static void main(String[] args) {
        new Principal();
    }
}