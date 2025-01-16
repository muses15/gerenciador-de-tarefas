/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.TarefaDAO;
import model.Tarefa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaListagemTarefas extends JFrame {
    private JTable tabelaTarefas;
    private JButton editarButton;
    private JButton excluirButton;

    public TelaListagemTarefas() {
        setTitle("Listagem de Tarefas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel tituloLabel = new JLabel("Tarefas Cadastradas");
        tituloLabel.setBounds(20, 20, 200, 25);
        add(tituloLabel);

        tabelaTarefas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaTarefas);
        scrollPane.setBounds(20, 60, 540, 200);
        add(scrollPane);

        editarButton = new JButton("Editar");
        editarButton.setBounds(150, 300, 100, 30);
        editarButton.addActionListener(e -> editarTarefa());
        add(editarButton);

        excluirButton = new JButton("Excluir");
        excluirButton.setBounds(300, 300, 100, 30);
        excluirButton.addActionListener(e -> excluirTarefa());
        add(excluirButton);

        carregarTarefas();
    }

    void carregarTarefas() {
        TarefaDAO dao = new TarefaDAO();
        List<Tarefa> tarefas = dao.listar();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Descrição");
        modelo.addColumn("Status");

        for (Tarefa tarefa : tarefas) {
            modelo.addRow(new Object[]{
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus()
            });
        }

        tabelaTarefas.setModel(modelo);
    }

    private void editarTarefa() {
        int linhaSelecionada = tabelaTarefas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!");
            return;
        }

        int id = (int) tabelaTarefas.getValueAt(linhaSelecionada, 0);
        String titulo = (String) tabelaTarefas.getValueAt(linhaSelecionada, 1);
        String descricao = (String) tabelaTarefas.getValueAt(linhaSelecionada, 2);

        TelaEdicaoTarefa telaEdicao = new TelaEdicaoTarefa(id, titulo, descricao, this);
        telaEdicao.setVisible(true);
    }

    private void excluirTarefa() {
        int linhaSelecionada = tabelaTarefas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para excluir!");
            return;
        }

        int id = (int) tabelaTarefas.getValueAt(linhaSelecionada, 0);
        TarefaDAO dao = new TarefaDAO();
        dao.excluir(id);

        JOptionPane.showMessageDialog(this, "Tarefa excluída com sucesso!");
        carregarTarefas();
    }
}
