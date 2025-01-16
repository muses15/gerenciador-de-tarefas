/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.TarefaDAO;
import javax.swing.*;

public class TelaEdicaoTarefa extends JFrame {
    private int tarefaId;
    private JTextField tituloField;
    private JTextArea descricaoField;
    private JButton salvarButton;
    private TelaListagemTarefas telaListagem;

    public TelaEdicaoTarefa(int id, String titulo, String descricao, TelaListagemTarefas telaListagem) {
        this.tarefaId = id;
        this.telaListagem = telaListagem;

        setTitle("Edição de Tarefa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setBounds(20, 20, 100, 25);
        add(tituloLabel);

        tituloField = new JTextField(titulo);
        tituloField.setBounds(100, 20, 250, 25);
        add(tituloField);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setBounds(20, 60, 100, 25);
        add(descricaoLabel);

        descricaoField = new JTextArea(descricao);
        descricaoField.setBounds(100, 60, 250, 100);
        add(descricaoField);

        salvarButton = new JButton("Salvar");
        salvarButton.setBounds(150, 180, 100, 30);
        salvarButton.addActionListener(e -> salvarAlteracoes());
        add(salvarButton);
    }

    private void salvarAlteracoes() {
        String titulo = tituloField.getText();
        String descricao = descricaoField.getText();

        if (titulo.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        TarefaDAO dao = new TarefaDAO();
        dao.atualizarStatus(tarefaId, "pendente"); // Atualizar status para manter a consistência
        JOptionPane.showMessageDialog(this, "Tarefa atualizada com sucesso!");

        telaListagem.carregarTarefas();
        dispose();
    }
}
