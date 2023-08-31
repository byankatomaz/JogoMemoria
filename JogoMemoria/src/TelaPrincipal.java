import regras.ControleBotoesSelecionados;
import regras.EstadosBotoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class TelaPrincipal extends JFrame {

    private int LARGURA_TELA = 400;
    private int ALTURA_TELA = 350;
    private JButton botao1;
    private JButton botao2;
    private JPanel panel;
    private ControleBotoesSelecionados controle;

    public TelaPrincipal(){
        super("Jogo da Memoria");

        controle = new ControleBotoesSelecionados();
        controle.setNmBotao("Churros");

        panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);

        botao1 = new JButton("Jogo");
        panel.add(botao1);
        botao1.setBounds(60, 10, 100, 50);

        botao1.addActionListener(e);

        botao2 = new JButton("Jogo");
        panel.add(botao2);
        botao2.setBounds(230, 10, 100, 50);

        botao2.addActionListener(e);

        this.controle.adicionarBotao(botao1);
        this.controle.adicionarBotao(botao2);

        this.setBounds(250, 100, LARGURA_TELA, ALTURA_TELA);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    ActionListener e = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ((JButton) e.getSource()).setBackground(Color.orange);
            controle.alterarSelecao(((JButton)e.getSource()), EstadosBotoes.SELECIONADO);
            ((JButton) e.getSource()).setText(controle.getNmBotao());
        }
    };

}
