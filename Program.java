import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JFrame {
    private JTextField[] numIngressosFields;
    private JButton buttonCalcular;
    private JTextArea textAreaObservacoes;

    public Program() {
        super("Calculadora de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        JPanel panelForm = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Valores de Entrada
        JPanel panelValoresEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints valoresEntradaConstraints = new GridBagConstraints();
        valoresEntradaConstraints.gridx = 0;
        valoresEntradaConstraints.gridy = 0;
        valoresEntradaConstraints.anchor = GridBagConstraints.WEST;
        valoresEntradaConstraints.insets = new Insets(5, 5, 5, 5);

        panelValoresEntrada.add(new JLabel("Número de Ingressos:"), valoresEntradaConstraints);

        int numSubAbas = 5;
        String[] subAbasNomes = {"Primeiro Lote:", "Segundo Lote:", "Terceiro Lote:", "Quarto Lote:", "Quinto Lote:"};
        numIngressosFields = new JTextField[numSubAbas];

        for (int i = 0; i < numSubAbas; i++) {
            valoresEntradaConstraints.gridy++;
            panelValoresEntrada.add(new JLabel(subAbasNomes[i]), valoresEntradaConstraints);

            valoresEntradaConstraints.gridx++;
            numIngressosFields[i] = new JTextField(10);
            panelValoresEntrada.add(numIngressosFields[i], valoresEntradaConstraints);

            valoresEntradaConstraints.gridx = 0;
        }

        tabbedPane.addTab("Valores de Entrada", panelValoresEntrada);

        // Valor dos Ingressos
        JPanel panelValorIngressos = criarSubAbaValores("Valor dos Ingressos:", subAbasNomes);
        tabbedPane.addTab("Valor dos Ingressos", panelValorIngressos);

        // Total
        JPanel panelTotal = new JPanel(new GridBagLayout());
        GridBagConstraints totalConstraints = new GridBagConstraints();
        totalConstraints.gridx = 0;
        totalConstraints.gridy = 0;
        totalConstraints.anchor = GridBagConstraints.WEST;
        totalConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelTotalIngressosVendidos = new JLabel("Total de Ingressos Vendidos:");
        panelTotal.add(labelTotalIngressosVendidos, totalConstraints);

        totalConstraints.gridx++;
        JTextField textFieldTotalIngressosVendidos = new JTextField(10);
        panelTotal.add(textFieldTotalIngressosVendidos, totalConstraints);

        totalConstraints.gridx = 0;
        totalConstraints.gridy++;
        JLabel labelTotalArrecadado = new JLabel("Total Arrecadado:");
        panelTotal.add(labelTotalArrecadado, totalConstraints);

        totalConstraints.gridx++;
        JTextField textFieldTotalArrecadado = new JTextField(10);
        panelTotal.add(textFieldTotalArrecadado, totalConstraints);

        tabbedPane.addTab("Total", panelTotal);

        // Aba Gastos
        JPanel panelGastos = new JPanel(new GridBagLayout());
        GridBagConstraints gastosConstraints = new GridBagConstraints();
        gastosConstraints.gridx = 0;
        gastosConstraints.gridy = 0;
        gastosConstraints.anchor = GridBagConstraints.WEST;
        gastosConstraints.insets = new Insets(5, 5, 5, 5);

        // SubAbas dentro de Gastos
        JTabbedPane tabbedPaneGastos = new JTabbedPane();

        // Decoração
        JPanel panelDecoracao = new JPanel(new GridBagLayout());
        GridBagConstraints decoracaoConstraints = new GridBagConstraints();
        decoracaoConstraints.gridx = 0;
        decoracaoConstraints.gridy = 0;
        decoracaoConstraints.anchor = GridBagConstraints.WEST;
        decoracaoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDescricaoDecoracao = new JLabel("Descrição da Decoração:");
        panelDecoracao.add(labelDescricaoDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridx++;
        JTextField textFieldDescricaoDecoracao = new JTextField(30);
        panelDecoracao.add(textFieldDescricaoDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridx = 0;
        decoracaoConstraints.gridy++;
        JLabel labelValorDecoracao = new JLabel("Valor da Decoração:");
        panelDecoracao.add(labelValorDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridx++;
        JTextField textFieldValorDecoracao = new JTextField(10);
        panelDecoracao.add(textFieldValorDecoracao, decoracaoConstraints);

        tabbedPaneGastos.addTab("Decoração", panelDecoracao);

        // Bebidas
        JPanel panelBebidas = new JPanel(new GridBagLayout());
        GridBagConstraints bebidasConstraints = new GridBagConstraints();
        bebidasConstraints.gridx = 0;
        bebidasConstraints.gridy = 0;
        bebidasConstraints.anchor = GridBagConstraints.WEST;
        bebidasConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelMediaBebida = new JLabel("Média de Bebida por Ingresso:");
        panelBebidas.add(labelMediaBebida, bebidasConstraints);

        bebidasConstraints.gridx++;
        JTextField textFieldMediaBebida = new JTextField(10);
        panelBebidas.add(textFieldMediaBebida, bebidasConstraints);

        // Aba para detalhes das bebidas
        JTabbedPane tabbedPaneBebidasDetalhes = new JTabbedPane();
        String[] bebidasNomes = {"Água", "Destilado", "Fermentado", "Suco", "Refrigerante"};
        JTextField[] bebidasFields = new JTextField[bebidasNomes.length];

        for (int i = 0; i < bebidasNomes.length; i++) {
            JPanel panelBebidaDetalhe = new JPanel(new GridBagLayout());
            GridBagConstraints bebidaDetalheConstraints = new GridBagConstraints();
            bebidaDetalheConstraints.gridx = 0;
            bebidaDetalheConstraints.gridy = 0;
            bebidaDetalheConstraints.anchor = GridBagConstraints.WEST;
            bebidaDetalheConstraints.insets = new Insets(5, 5, 5, 5);

            panelBebidaDetalhe.add(new JLabel(bebidasNomes[i] + ":"), bebidaDetalheConstraints);

            bebidaDetalheConstraints.gridx++;
            bebidasFields[i] = new JTextField(10);
            panelBebidaDetalhe.add(bebidasFields[i], bebidaDetalheConstraints);

            tabbedPaneBebidasDetalhes.addTab(bebidasNomes[i], panelBebidaDetalhe);
        }

        bebidasConstraints.gridx = 0;
        bebidasConstraints.gridy++;
        bebidasConstraints.gridwidth = 2;
        panelBebidas.add(tabbedPaneBebidasDetalhes, bebidasConstraints);

        tabbedPaneGastos.addTab("Bebidas", panelBebidas);

        // Segurança
        JPanel panelSeguranca = new JPanel(new GridBagLayout());
        GridBagConstraints segurancaConstraints = new GridBagConstraints();
        segurancaConstraints.gridx = 0;
        segurancaConstraints.gridy = 0;
        segurancaConstraints.anchor = GridBagConstraints.WEST;
        segurancaConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDescricaoSeguranca = new JLabel("Descrição da Segurança:");
        panelSeguranca.add(labelDescricaoSeguranca, segurancaConstraints);

        segurancaConstraints.gridx++;
        JTextField textFieldDescricaoSeguranca = new JTextField(30);
        panelSeguranca.add(textFieldDescricaoSeguranca, segurancaConstraints);

        segurancaConstraints.gridx = 0;
        segurancaConstraints.gridy++;
        JLabel labelValorSeguranca = new JLabel("Valor da Segurança:");
        panelSeguranca.add(labelValorSeguranca, segurancaConstraints);

        segurancaConstraints.gridx++;
        JTextField textFieldValorSeguranca = new JTextField(10);
        panelSeguranca.add(textFieldValorSeguranca, segurancaConstraints);

        tabbedPaneGastos.addTab("Segurança", panelSeguranca);

        // Bombeiro
        JPanel panelBombeiro = new JPanel(new GridBagLayout());
        GridBagConstraints bombeiroConstraints = new GridBagConstraints();
        bombeiroConstraints.gridx = 0;
        bombeiroConstraints.gridy = 0;
        bombeiroConstraints.anchor = GridBagConstraints.WEST;
        bombeiroConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDescricaoBombeiro = new JLabel("Descrição do Bombeiro:");
        panelBombeiro.add(labelDescricaoBombeiro, bombeiroConstraints);

        bombeiroConstraints.gridx++;
        JTextField textFieldDescricaoBombeiro = new JTextField(30);
        panelBombeiro.add(textFieldDescricaoBombeiro, bombeiroConstraints);

        bombeiroConstraints.gridx = 0;
        bombeiroConstraints.gridy++;
        JLabel labelValorBombeiro = new JLabel("Valor do Bombeiro:");
        panelBombeiro.add(labelValorBombeiro, bombeiroConstraints);

        bombeiroConstraints.gridx++;
        JTextField textFieldValorBombeiro = new JTextField(10);
        panelBombeiro.add(textFieldValorBombeiro, bombeiroConstraints);

        tabbedPaneGastos.addTab("Bombeiro", panelBombeiro);

        // Limpeza
        JPanel panelLimpeza = new JPanel(new GridBagLayout());
        GridBagConstraints limpezaConstraints = new GridBagConstraints();
        limpezaConstraints.gridx = 0;
        limpezaConstraints.gridy = 0;
        limpezaConstraints.anchor = GridBagConstraints.WEST;
        limpezaConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDescricaoLimpeza = new JLabel("Descrição da Limpeza:");
        panelLimpeza.add(labelDescricaoLimpeza, limpezaConstraints);

        limpezaConstraints.gridx++;
        JTextField textFieldDescricaoLimpeza = new JTextField(30);
        panelLimpeza.add(textFieldDescricaoLimpeza, limpezaConstraints);

        limpezaConstraints.gridx = 0;
        limpezaConstraints.gridy++;
        JLabel labelValorLimpeza = new JLabel("Valor da Limpeza:");
        panelLimpeza.add(labelValorLimpeza, limpezaConstraints);

        limpezaConstraints.gridx++;
        JTextField textFieldValorLimpeza = new JTextField(10);
        panelLimpeza.add(textFieldValorLimpeza, limpezaConstraints);

        tabbedPaneGastos.addTab("Limpeza", panelLimpeza);

        // Equipamento
        JPanel panelEquipamento = new JPanel(new GridBagLayout());
        GridBagConstraints equipamentoConstraints = new GridBagConstraints();
        equipamentoConstraints.gridx = 0;
        equipamentoConstraints.gridy = 0;
        equipamentoConstraints.anchor = GridBagConstraints.WEST;
        equipamentoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDescricaoEquipamento = new JLabel("Descrição do Equipamento:");
        panelEquipamento.add(labelDescricaoEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridx++;
        JTextField textFieldDescricaoEquipamento = new JTextField(30);
        panelEquipamento.add(textFieldDescricaoEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridx = 0;
        equipamentoConstraints.gridy++;
        JLabel labelValorEquipamento = new JLabel("Valor do Equipamento:");
        panelEquipamento.add(labelValorEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridx++;
        JTextField textFieldValorEquipamento = new JTextField(10);
        panelEquipamento.add(textFieldValorEquipamento, equipamentoConstraints);

        tabbedPaneGastos.addTab("Equipamento", panelEquipamento);

        // Adicionando o TabbedPane de Gastos ao painel principal
        gastosConstraints.gridx = 0;
        gastosConstraints.gridy++;
        gastosConstraints.gridwidth = 2;
        panelGastos.add(tabbedPaneGastos, gastosConstraints);

        tabbedPane.addTab("Gastos", panelGastos);

        // Botões de Ação
        JPanel panelBotoesAcao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonCalcular = new JButton("Calcular");
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValores();
            }
        });
        panelBotoesAcao.add(buttonCalcular);

        JButton buttonAumentarTela = new JButton("Aumentar Tela");
        buttonAumentarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarTela();
            }
        });
        panelBotoesAcao.add(buttonAumentarTela);

        JButton buttonDiminuirTela = new JButton("Diminuir Tela");
        buttonDiminuirTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diminuirTela();
            }
        });
        panelBotoesAcao.add(buttonDiminuirTela);

        // Painel de Observações
        JPanel panelObservacoes = new JPanel(new BorderLayout());
        panelObservacoes.setBorder(BorderFactory.createTitledBorder("Observações"));
        textAreaObservacoes = new JTextArea(10, 30);
        textAreaObservacoes.setEditable(false);
        JScrollPane scrollPaneObservacoes = new JScrollPane(textAreaObservacoes);
        panelObservacoes.add(scrollPaneObservacoes, BorderLayout.CENTER);

        // Adicionando os painéis ao painel principal
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelForm.add(tabbedPane, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelForm.add(panelBotoesAcao, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panelForm.add(panelObservacoes, constraints);

        add(panelForm);

        pack();
        setVisible(true);
    }

    private JPanel criarSubAbaValores(String titulo, String[] subAbasNomes) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel(titulo), constraints);

        JTextField[] fields = new JTextField[subAbasNomes.length];
        for (int i = 0; i < subAbasNomes.length; i++) {
            constraints.gridy++;
            panel.add(new JLabel(subAbasNomes[i]), constraints);

            constraints.gridx++;
            fields[i] = new JTextField(10);
            panel.add(fields[i], constraints);

            constraints.gridx = 0;
        }
        return panel;
    }

    private void calcularValores() {
        // Aqui você pode implementar os cálculos dos valores e exibi-los nas áreas correspondentes
        // Utilize os campos numIngressosFields e demais campos para obter os valores de entrada
        // e atualize os campos de total e valores dos gastos de acordo com os cálculos realizados
    }

    private void aumentarTela() {
        Dimension size = getSize();
        size.width += 50;
        size.height += 50;
        setSize(size);
    }

    private void diminuirTela() {
        Dimension size = getSize();
        size.width -= 50;
        size.height -= 50;
        setSize(size);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Program();
            }
        });
    }
}
