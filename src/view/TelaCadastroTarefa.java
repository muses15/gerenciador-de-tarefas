/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.TarefaDAO;
import model.Tarefa;

import javax.swing.*;

public class TelaCadastroTarefa extends JFrame {
    private JTextField tituloField;
    private JTextArea descricaoField;
    private JButton salvarButton;

    public TelaCadastroTarefa() {
        setTitle("Cadastro de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setBounds(20, 20, 100, 25);
        add(tituloLabel);

        tituloField = new JTextField();
        tituloField.setBounds(100, 20, 250, 25);
        add(tituloField);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setBounds(20, 60, 100, 25);
        add(descricaoLabel);

        descricaoField = new JTextArea();
        descricaoField.setBounds(100, 60, 250, 100);
        add(descricaoField);

        salvarButton = new JButton("Salvar");
        salvarButton.setBounds(150, 180, 100, 30);
        salvarButton.addActionListener(e -> salvarTarefa());
        add(salvarButton);
    }

    private void salvarTarefa() {
        String titulo = tituloField.getText();
        String descricao = descricaoField.getText();

        if (titulo.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Tarefa tarefa = new Tarefa(0, titulo, descricao, "pendente");
        TarefaDAO dao = new TarefaDAO();
        dao.salvar(tarefa);

        JOptionPane.showMessageDialog(this, "Tarefa salva com sucesso!");
        tituloField.setText("");
        descricaoField.setText("");
    }
}

