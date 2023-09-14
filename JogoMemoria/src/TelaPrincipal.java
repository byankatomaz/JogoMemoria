import regras.ControleBotoesSelecionados;
import regras.EstadosBotoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private static final int QUANTIDADE_JOGADAS = 2;
    private int jogadas = 0;

    private int LARGURA_TELA = 400;
    private int ALTURA_TELA = 350;
    private JButton botao1;
    private JButton botao2;
    private JButton botaoA;
    private JButton botaoB;
    private JPanel panel;
    private ControleBotoesSelecionados controle;
    private ControleBotoesSelecionados controleA;
    private List<ControleBotoesSelecionados> listaControle;
    private List<ControleBotoesSelecionados> listaSelecionados;

    public TelaPrincipal(){
        super("Jogo da Memoria");

        listaControle = new ArrayList<>();
        listaSelecionados = new ArrayList<>();

        controle = new ControleBotoesSelecionados();
        controle.setNmBotao("Churros");

        controleA = new ControleBotoesSelecionados();
        controleA.setNmBotao("Panelão");

        //add controles na lista
        this.listaControle.add(controle);
        this.listaControle.add(controleA);

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

        botaoA = new JButton("Jogo");
        panel.add(botaoA);
        botaoA.setBounds(230, 100, 100, 50);

        botaoA.addActionListener(e);

        botaoB = new JButton("Jogo");
        panel.add(botaoB);
        botaoB.setBounds(60, 100, 100, 50);

        botaoB.addActionListener(e);

        this.controle.adicionarBotao(botao1);
        this.controle.adicionarBotao(botao2);
        this.controleA.adicionarBotao(botaoA);
        this.controleA.adicionarBotao(botaoB);

        this.setBounds(250, 100, LARGURA_TELA, ALTURA_TELA);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    ActionListener e = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botao = (JButton) e.getSource();

            for (ControleBotoesSelecionados cont : listaControle){
                if (cont.getReferenciaBotoes().get(botao) != null){
                    jogadas++;
                    cont.excutarAcaoBotoes((JButton) e.getSource(), EstadosBotoes.SELECIONADO);
                    //controle de inclusão
                    if (!listaSelecionados.contains(cont)){
                        listaSelecionados.add(cont);
                    }
                    System.out.println(listaSelecionados.size());
                    if (jogadas == QUANTIDADE_JOGADAS){
                        //Acabaram as jogadas
                        if (listaSelecionados.size() > 1){
                            for (ControleBotoesSelecionados cbs : listaSelecionados){
                                cbs.zerarSelecoes();
                            }
                        }
                        jogadas = 0;
                        listaSelecionados.clear();
                    }
                }
            }
        }
    };

    private void criarJogo(int qtPares){
        //Quantidade de botoes
        ControleBotoesSelecionados controle = null;

        int posX = 10;
        int posY = 10;

        int j = 0;

        for (int i = 0; i < (qtPares*2); i++) {
            if (i % 2 == 0){
                j++;
                controle = new ControleBotoesSelecionados();
                controle.setNmBotao("Botão " + j);
                this.listaControle.add(controle);
            }

            JButton botao = new JButton("Jogo");
            this.panel.add(botao);
            botao.addActionListener(this.e);

            controle.adicionarBotao(botao);
        }
        //Quantidade de controladores
        //Colocar os botoes na tela
        //Adaptar o tamanho da tela
        //Randomizar o posicionamento dos botões
    }

}
