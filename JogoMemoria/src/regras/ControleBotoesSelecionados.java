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

    public void excutarAcaoBotoes(JButton botao, EstadosBotoes estado){
        alterarSelecao(botao, estado);

        if (this.isTodasSelecionadas()){
            alterarEstadoTodosBotoes(EstadosBotoes.PARES);
        } else {
            alterarVisualizacaoBotao(botao);
        }

    }

    private void alterarEstadoTodosBotoes(EstadosBotoes estado){
        for (JButton botao : this.referenciaBotoes.keySet()) {
            alterarSelecao(botao, estado);
            alterarVisualizacaoBotao(botao);
        }
    }

    public void adicionarBotao(JButton botao){
        this.referenciaBotoes.put(botao, EstadosBotoes.NORMAL);
    }

    public void alterarSelecao(JButton botao, EstadosBotoes selecionado){
        this.referenciaBotoes.put(botao, selecionado);
        EstadosBotoes b = this.referenciaBotoes.get(botao);
        b = EstadosBotoes.SELECIONADO;
        alterarVisualizacaoBotao(botao);
    }

    private void alterarVisualizacaoBotao(JButton botao){
        EstadosBotoes selecionado = this.referenciaBotoes.get(botao);

        switch (selecionado){
            case NORMAL -> { // Cinza, não exibe texto
                botao.setBackground(null);
                botao.setText("Jogo");
                break;
            } case SELECIONADO -> {  // Exibir texto, mudar a cor
                botao.setBackground(Color.GREEN);
                botao.setText(this.nmBotao);
                break;
            } case PARES -> { // Mudar a cor, exibir o texto
                botao.setBackground(Color.magenta);
                botao.setText(this.nmBotao);
                botao.setEnabled(false);
                break;
            }
        }
    }

    public void zerarSelecoes(){
        alterarEstadoTodosBotoes(EstadosBotoes.NORMAL);
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
