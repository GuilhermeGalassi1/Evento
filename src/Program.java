import javax.swing.*;
import java.awt.*;

public class Program extends JFrame {
    public Program() {
        setTitle("Calculadora de Eventos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba Valores de Entrada
        JPanel panelValoresEntrada = new JPanel();
        panelValoresEntrada.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] lotes = {"Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto"};

        for (String lote : lotes) {
            panelValoresEntrada.add(new JLabel(lote + " Lote:"), gbc);
            gbc.gridx++;
            panelValoresEntrada.add(new JTextField(10), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        tabbedPane.addTab("Valores de entrada", panelValoresEntrada);

        // Aba Valor dos Ingressos
        JPanel panelValorIngressos = new JPanel();
        panelValorIngressos.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (String lote : lotes) {
            panelValorIngressos.add(new JLabel(lote + " Lote Valor:"), gbc);
            gbc.gridx++;
            panelValorIngressos.add(new JTextField(10), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        tabbedPane.addTab("Valor dos ingressos", panelValorIngressos);

        // Aba Total
        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelTotal.add(new JLabel("Total de Ingressos Vendidos:"), gbc);
        gbc.gridx++;
        panelTotal.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelTotal.add(new JLabel("Valor Arrecadado:"), gbc);
        gbc.gridx++;
        panelTotal.add(new JTextField(10), gbc);

        tabbedPane.addTab("Total", panelTotal);

        // Aba Gastos
        JPanel panelGastos = new JPanel();
        panelGastos.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Aba Decoração
        JPanel panelDecoracao = new JPanel();
        panelDecoracao.setLayout(new GridBagLayout());
        GridBagConstraints gbcDecoracao = new GridBagConstraints();
        gbcDecoracao.gridx = 0;
        gbcDecoracao.gridy = 0;
        gbcDecoracao.anchor = GridBagConstraints.WEST;
        gbcDecoracao.insets = new Insets(5, 5, 5, 5);

        panelDecoracao.add(new JLabel("Descrição da Decoração:"), gbcDecoracao);
        gbcDecoracao.gridx++;
        panelDecoracao.add(new JTextField(30), gbcDecoracao);

        gbcDecoracao.gridx = 0;
        gbcDecoracao.gridy++;
        panelDecoracao.add(new JLabel("Valor da Decoração:"), gbcDecoracao);
        gbcDecoracao.gridx++;
        panelDecoracao.add(new JTextField(10), gbcDecoracao);

        // Aba Bebidas
        JPanel panelBebidas = new JPanel();
        panelBebidas.setLayout(new GridBagLayout());
        GridBagConstraints gbcBebidas = new GridBagConstraints();
        gbcBebidas.gridx = 0;
        gbcBebidas.gridy = 0;
        gbcBebidas.anchor = GridBagConstraints.WEST;
        gbcBebidas.insets = new Insets(5, 5, 5, 5);

        String[] tiposBebidas = {"Água", "Destilado", "Fermentado", "Suco", "Refrigerante"};

        for (String tipo : tiposBebidas) {
            panelBebidas.add(new JLabel("Descrição de " + tipo + ":"), gbcBebidas);
            gbcBebidas.gridx++;
            panelBebidas.add(new JTextField(30), gbcBebidas);
            gbcBebidas.gridx = 0;
            gbcBebidas.gridy++;
        }

        gbcBebidas.gridx = 0;
        gbcBebidas.gridy++;
        panelBebidas.add(new JLabel("Valor Total de Bebidas:"), gbcBebidas);
        gbcBebidas.gridx++;
        panelBebidas.add(new JTextField(10), gbcBebidas);

        // Adiciona as abas dentro da aba Gastos
        JTabbedPane tabbedPaneGastos = new JTabbedPane();
        tabbedPaneGastos.addTab("Decoração", panelDecoracao);
        tabbedPaneGastos.addTab("Bebidas", panelBebidas);

        panelGastos.add(tabbedPaneGastos, gbc);

        // Aba Segurança
        JPanel panelSeguranca = new JPanel();
        panelSeguranca.setLayout(new GridBagLayout());
        GridBagConstraints gbcSeguranca = new GridBagConstraints();
        gbcSeguranca.gridx = 0;
        gbcSeguranca.gridy = 0;
        gbcSeguranca.anchor = GridBagConstraints.WEST;
        gbcSeguranca.insets = new Insets(5, 5, 5, 5);

        panelSeguranca.add(new JLabel("Descrição da Segurança:"), gbcSeguranca);
        gbcSeguranca.gridx++;
        panelSeguranca.add(new JTextField(30), gbcSeguranca);

        gbcSeguranca.gridx = 0;
        gbcSeguranca.gridy++;
        panelSeguranca.add(new JLabel("Valor da Segurança:"), gbcSeguranca);
        gbcSeguranca.gridx++;
        panelSeguranca.add(new JTextField(10), gbcSeguranca);

        tabbedPaneGastos.addTab("Segurança", panelSeguranca);

        // Aba Bombeiro
        JPanel panelBombeiro = new JPanel();
        panelBombeiro.setLayout(new GridBagLayout());
        GridBagConstraints gbcBombeiro = new GridBagConstraints();
        gbcBombeiro.gridx = 0;
        gbcBombeiro.gridy = 0;
        gbcBombeiro.anchor = GridBagConstraints.WEST;
        gbcBombeiro.insets = new Insets(5, 5, 5, 5);

        panelBombeiro.add(new JLabel("Descrição do Bombeiro:"), gbcBombeiro);
        gbcBombeiro.gridx++;
        panelBombeiro.add(new JTextField(30), gbcBombeiro);

        gbcBombeiro.gridx = 0;
        gbcBombeiro.gridy++;
        panelBombeiro.add(new JLabel("Valor do Bombeiro:"), gbcBombeiro);
        gbcBombeiro.gridx++;
        panelBombeiro.add(new JTextField(10), gbcBombeiro);

        tabbedPaneGastos.addTab("Bombeiro", panelBombeiro);

        // Aba Limpeza
        JPanel panelLimpeza = new JPanel();
        panelLimpeza.setLayout(new GridBagLayout());
        GridBagConstraints gbcLimpeza = new GridBagConstraints();
        gbcLimpeza.gridx = 0;
        gbcLimpeza.gridy = 0;
        gbcLimpeza.anchor = GridBagConstraints.WEST;
        gbcLimpeza.insets = new Insets(5, 5, 5, 5);

        panelLimpeza.add(new JLabel("Descrição da Limpeza:"), gbcLimpeza);
        gbcLimpeza.gridx++;
        panelLimpeza.add(new JTextField(30), gbcLimpeza);

        gbcLimpeza.gridx = 0;
        gbcLimpeza.gridy++;
        panelLimpeza.add(new JLabel("Valor da Limpeza:"), gbcLimpeza);
        gbcLimpeza.gridx++;
        panelLimpeza.add(new JTextField(10), gbcLimpeza);

        tabbedPaneGastos.addTab("Limpeza", panelLimpeza);

        panelGastos.add(tabbedPaneGastos, gbc);

        // Aba Som
        JPanel panelSom = new JPanel();
        panelSom.setLayout(new GridBagLayout());
        GridBagConstraints gbcSom = new GridBagConstraints();
        gbcSom.gridx = 0;
        gbcSom.gridy = 0;
        gbcSom.anchor = GridBagConstraints.WEST;
        gbcSom.insets = new Insets(5, 5, 5, 5);

        panelSom.add(new JLabel("Descrição do Som:"), gbcSom);
        gbcSom.gridx++;
        panelSom.add(new JTextField(30), gbcSom);

        gbcSom.gridx = 0;
        gbcSom.gridy++;
        panelSom.add(new JLabel("Valor do Som:"), gbcSom);
        gbcSom.gridx++;
        panelSom.add(new JTextField(10), gbcSom);
        
        tabbedPaneGastos.addTab("Som", panelSom);
        panelGastos.add(panelSom, gbc);

        // Aba Espaço
        JPanel panelEspaco = new JPanel();
        panelEspaco.setLayout(new GridBagLayout());
        GridBagConstraints gbcEspaco = new GridBagConstraints();
        gbcEspaco.gridx = 0;
        gbcEspaco.gridy = 0;
        gbcEspaco.anchor = GridBagConstraints.WEST;
        gbcEspaco.insets = new Insets(5, 5, 5, 5);

        panelEspaco.add(new JLabel("Localização:"), gbcEspaco);
        gbcEspaco.gridx++;
        panelEspaco.add(new JTextField(30), gbcEspaco);

        gbcEspaco.gridx = 0;
        gbcEspaco.gridy++;
        panelEspaco.add(new JLabel("Horário:"), gbcEspaco);
        gbcEspaco.gridx++;
        panelEspaco.add(new JTextField(30), gbcEspaco);

        gbcEspaco.gridx = 0;
        gbcEspaco.gridy++;
        panelEspaco.add(new JLabel("Data:"), gbcEspaco);
        gbcEspaco.gridx++;
        panelEspaco.add(new JCalendar(), gbcEspaco);

        gbcEspaco.gridx = 0;
        gbcEspaco.gridy++;
        panelEspaco.add(new JLabel("Valor do Espaço:"), gbcEspaco);
        gbcEspaco.gridx++;
        panelEspaco.add(new JTextField(10), gbcEspaco);

        tabbedPaneGastos.addTab("Espaço", panelEspaco);
        panelGastos.add(panelEspaco, gbc);

        // Aba Equipamento
        JPanel panelEquipamento = new JPanel();
        panelEquipamento.setLayout(new GridBagLayout());
        GridBagConstraints gbcEquipamento = new GridBagConstraints();
        gbcEquipamento.gridx = 0;
        gbcEquipamento.gridy = 0;
        gbcEquipamento.anchor = GridBagConstraints.WEST;
        gbcEquipamento.insets = new Insets(5, 5, 5, 5);

        panelEquipamento.add(new JLabel("Descrição do Equipamento:"), gbcEquipamento);
        gbcEquipamento.gridx++;
        panelEquipamento.add(new JTextField(30), gbcEquipamento);

        gbcEquipamento.gridx = 0;
        gbcEquipamento.gridy++;
        panelEquipamento.add(new JLabel("Valor do Equipamento:"), gbcEquipamento);
        gbcEquipamento.gridx++;
        panelEquipamento.add(new JTextField(10), gbcEquipamento);

        panelGastos.add(panelEquipamento, gbc);

        tabbedPane.addTab("Gastos", panelGastos);

        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Program());
    }
}
