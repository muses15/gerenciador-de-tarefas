/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;

public class TelaInicial extends JFrame {
    private JButton cadastrarButton;
    private JButton listarButton;

    public TelaInicial() {
        setTitle("Gerenciador de Tarefas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        cadastrarButton = new JButton("Cadastrar Tarefa");
        cadastrarButton.setBounds(100, 50, 200, 30);
        cadastrarButton.addActionListener(e -> abrirTelaCadastro());
        add(cadastrarButton);

        listarButton = new JButton("Listar Tarefas");
        listarButton.setBounds(100, 100, 200, 30);
        listarButton.addActionListener(e -> abrirTelaListagem());
        add(listarButton);
    }

    private void abrirTelaCadastro() {
        TelaCadastroTarefa telaCadastro = new TelaCadastroTarefa();
        telaCadastro.setVisible(true);
    }

    private void abrirTelaListagem() {
        TelaListagemTarefas telaListagem = new TelaListagemTarefas();
        telaListagem.setVisible(true);
    }

    public static void main(String[] args) {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
    }
}

