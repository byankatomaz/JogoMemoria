package regras;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ControleBotoesSelecionados {

    private String nmBotao;
    private Map<JButton, EstadosBotoes> referenciaBotoes;

    public ControleBotoesSelecionados() {
        this.referenciaBotoes = new HashMap<>();
    }

    public String getNmBotao() {
        return nmBotao;
    }

    public void setNmBotao(String nmBotao) {
        this.nmBotao = nmBotao;
    }

    public Map<JButton, EstadosBotoes> getReferenciaBotoes() {
        return referenciaBotoes;
    }

    public void setReferenciaBotoes(Map<JButton, EstadosBotoes> referenciaBotoes) {
        this.referenciaBotoes = referenciaBotoes;
    }

    public void adicionarBotao(JButton botao){
        this.referenciaBotoes.put(botao, EstadosBotoes.NORMAL);
    }

    public void alterarSelecao(JButton botao, EstadosBotoes selecionado){
        EstadosBotoes b = this.referenciaBotoes.get(botao);
        b = EstadosBotoes.SELECIONADO;
        alterarVisualizacaoBotao(botao);
    }

    private void alterarVisualizacaoBotao(JButton botao){
        EstadosBotoes selecionado = this.referenciaBotoes.get(botao);

        switch (selecionado){
            case NORMAL -> {
                botao.setBackground(Color.gray);
                botao.setText("Jogo");
                break;
            } case SELECIONADO -> {
                botao.setBackground(Color.GREEN);
                botao.setText(this.nmBotao);
                break;
            } case PARES -> {
                botao.setBackground(Color.magenta);
                botao.setText(this.nmBotao);
                break;
            }
        }
    }

    public void zerarSelecoes(){
        for (EstadosBotoes b : this.referenciaBotoes.values()) {
              b = EstadosBotoes.NORMAL;
        }
    }

    public Boolean isTodasSelecionadas(){
        for (EstadosBotoes b : this.referenciaBotoes.values()) {
            if (b != EstadosBotoes.SELECIONADO){
                //Não foram selecionados
                return false;
            }
        }
        return true;
    }
}
