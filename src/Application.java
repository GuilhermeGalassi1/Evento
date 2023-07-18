import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {

    private JTextField textFieldNumIngressos;
    private JTextField textFieldValorIngresso;
    private JTextField textFieldValorDecoracao;
    private JTextField textFieldValorAgua;
    private JTextField textFieldValorDestilado;
    private JTextField textFieldValorFermentado;
    private JTextField textFieldValorSuco;
    private JTextField textFieldValorRefrigerante;
    private JTextArea textAreaResultado;

    public Application() {
        initialize();
    }

    private void initialize() {
        setTitle("Calculadora de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelValoresEntrada = new JPanel();
        panelValoresEntrada.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Aba Numero de Ingressos
        JPanel panelNumIngressos = new JPanel(new GridBagLayout());
        GridBagConstraints numIngressosConstraints = new GridBagConstraints();
        numIngressosConstraints.gridx = 0;
        numIngressosConstraints.gridy = 0;
        numIngressosConstraints.anchor = GridBagConstraints.WEST;
        numIngressosConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNumIngressos = new JLabel("Número de Ingressos:");
        panelNumIngressos.add(labelNumIngressos, numIngressosConstraints);

        numIngressosConstraints.gridx++;
        textFieldNumIngressos = new JTextField(10);
        panelNumIngressos.add(textFieldNumIngressos, numIngressosConstraints);

        panelValoresEntrada.add(panelNumIngressos, constraints);

        // Aba Valor dos Ingressos
        JPanel panelValorIngresso = new JPanel(new GridBagLayout());
        GridBagConstraints valorIngressoConstraints = new GridBagConstraints();
        valorIngressoConstraints.gridx = 0;
        valorIngressoConstraints.gridy = 0;
        valorIngressoConstraints.anchor = GridBagConstraints.WEST;
        valorIngressoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelValorIngresso = new JLabel("Valor do Ingresso:");
        panelValorIngresso.add(labelValorIngresso, valorIngressoConstraints);

        valorIngressoConstraints.gridx++;
        textFieldValorIngresso = new JTextField(10);
        panelValorIngresso.add(textFieldValorIngresso, valorIngressoConstraints);

        panelValoresEntrada.add(panelValorIngresso, constraints);

        // Aba Total
        JPanel panelTotal = new JPanel(new GridBagLayout());
        GridBagConstraints totalConstraints = new GridBagConstraints();
        totalConstraints.gridx = 0;
        totalConstraints.gridy = 0;
        totalConstraints.anchor = GridBagConstraints.WEST;
        totalConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelTotal = new JLabel("Total:");
        panelTotal.add(labelTotal, totalConstraints);

        totalConstraints.gridx++;
        textAreaResultado = new JTextArea(4, 20);
        textAreaResultado.setEditable(false);
        JScrollPane scrollPaneResultado = new JScrollPane(textAreaResultado);
        panelTotal.add(scrollPaneResultado, totalConstraints);

        panelValoresEntrada.add(panelTotal, constraints);

        tabbedPane.addTab("Valores de entrada", panelValoresEntrada);

        JPanel panelGastos = new JPanel();
        panelGastos.setLayout(new GridBagLayout());

        // Aba Decoração
        JPanel panelDecoracao = new JPanel(new GridBagLayout());
        GridBagConstraints decoracaoConstraints = new GridBagConstraints();
        decoracaoConstraints.gridx = 0;
        decoracaoConstraints.gridy = 0;
        decoracaoConstraints.anchor = GridBagConstraints.WEST;
        decoracaoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDecoracao = new JLabel("Descrição da Decoração:");
        panelDecoracao.add(labelDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridx++;
        JTextField textFieldDecoracao = new JTextField(30);
        panelDecoracao.add(textFieldDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridy++;
        decoracaoConstraints.gridx = 0;
        JLabel labelValorDecoracao = new JLabel("Valor da Decoração:");
        panelDecoracao.add(labelValorDecoracao, decoracaoConstraints);

        decoracaoConstraints.gridx++;
        textFieldValorDecoracao = new JTextField(10);
        panelDecoracao.add(textFieldValorDecoracao, decoracaoConstraints);

        panelGastos.add(panelDecoracao, constraints);

        // Aba Bebidas
        JPanel panelBebidas = new JPanel(new GridBagLayout());
        GridBagConstraints bebidasConstraints = new GridBagConstraints();
        bebidasConstraints.gridx = 0;
        bebidasConstraints.gridy = 0;
        bebidasConstraints.anchor = GridBagConstraints.WEST;
        bebidasConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelBebidas = new JLabel("Bebidas:");
        panelBebidas.add(labelBebidas, bebidasConstraints);

        // SeuBaba Água
        JPanel panelAgua = new JPanel(new GridBagLayout());
        GridBagConstraints aguaConstraints = new GridBagConstraints();
        aguaConstraints.gridx = 0;
        aguaConstraints.gridy = 0;
        aguaConstraints.anchor = GridBagConstraints.WEST;
        aguaConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelAgua = new JLabel("Água:");
        panelAgua.add(labelAgua, aguaConstraints);

        aguaConstraints.gridx++;
        textFieldValorAgua = new JTextField(10);
        panelAgua.add(textFieldValorAgua, aguaConstraints);

        bebidasConstraints.gridy++;
        panelBebidas.add(panelAgua, bebidasConstraints);

        // SeuBaba Destilado
        JPanel panelDestilado = new JPanel(new GridBagLayout());
        GridBagConstraints destiladoConstraints = new GridBagConstraints();
        destiladoConstraints.gridx = 0;
        destiladoConstraints.gridy = 0;
        destiladoConstraints.anchor = GridBagConstraints.WEST;
        destiladoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelDestilado = new JLabel("Destilado:");
        panelDestilado.add(labelDestilado, destiladoConstraints);

        destiladoConstraints.gridx++;
        textFieldValorDestilado = new JTextField(10);
        panelDestilado.add(textFieldValorDestilado, destiladoConstraints);

        bebidasConstraints.gridy++;
        panelBebidas.add(panelDestilado, bebidasConstraints);

        // Subaba Fermentado
        JPanel panelFermentado = new JPanel(new GridBagLayout());
        GridBagConstraints fermentadoConstraints = new GridBagConstraints();
        fermentadoConstraints.gridx = 0;
        fermentadoConstraints.gridy = 0;
        fermentadoConstraints.anchor = GridBagConstraints.WEST;
        fermentadoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelFermentado = new JLabel("Fermentado:");
        panelFermentado.add(labelFermentado, fermentadoConstraints);

        fermentadoConstraints.gridx++;
        textFieldValorFermentado = new JTextField(10);
        panelFermentado.add(textFieldValorFermentado, fermentadoConstraints);

        bebidasConstraints.gridy++;
        panelBebidas.add(panelFermentado, bebidasConstraints);

        // Subaba Suco
        JPanel panelSuco = new JPanel(new GridBagLayout());
        GridBagConstraints sucoConstraints = new GridBagConstraints();
        sucoConstraints.gridx = 0;
        sucoConstraints.gridy = 0;
        sucoConstraints.anchor = GridBagConstraints.WEST;
        sucoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelSuco = new JLabel("Suco:");
        panelSuco.add(labelSuco, sucoConstraints);

        sucoConstraints.gridx++;
        textFieldValorSuco = new JTextField(10);
        panelSuco.add(textFieldValorSuco, sucoConstraints);

        bebidasConstraints.gridy++;
        panelBebidas.add(panelSuco, bebidasConstraints);

        // Subaba Refrigerante
        JPanel panelRefrigerante = new JPanel(new GridBagLayout());
        GridBagConstraints refrigeranteConstraints = new GridBagConstraints();
        refrigeranteConstraints.gridx = 0;
        refrigeranteConstraints.gridy = 0;
        refrigeranteConstraints.anchor = GridBagConstraints.WEST;
        refrigeranteConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelRefrigerante = new JLabel("Refrigerante:");
        panelRefrigerante.add(labelRefrigerante, refrigeranteConstraints);

        refrigeranteConstraints.gridx++;
        textFieldValorRefrigerante = new JTextField(10);
        panelRefrigerante.add(textFieldValorRefrigerante, refrigeranteConstraints);

        bebidasConstraints.gridy++;
        panelBebidas.add(panelRefrigerante, bebidasConstraints);

        panelGastos.add(panelBebidas, constraints);

        // Aba Equipamento
        JPanel panelEquipamento = new JPanel(new GridBagLayout());
        GridBagConstraints equipamentoConstraints = new GridBagConstraints();
        equipamentoConstraints.gridx = 0;
        equipamentoConstraints.gridy = 0;
        equipamentoConstraints.anchor = GridBagConstraints.WEST;
        equipamentoConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelEquipamento = new JLabel("Descrição do Equipamento:");
        panelEquipamento.add(labelEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridx++;
        JTextField textFieldEquipamento = new JTextField(30);
        panelEquipamento.add(textFieldEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridy++;
        equipamentoConstraints.gridx = 0;
        JLabel labelValorEquipamento = new JLabel("Valor do Equipamento:");
        panelEquipamento.add(labelValorEquipamento, equipamentoConstraints);

        equipamentoConstraints.gridx++;
        JTextField textFieldValorEquipamento = new JTextField(10);
        panelEquipamento.add(textFieldValorEquipamento, equipamentoConstraints);

        panelGastos.add(panelEquipamento, constraints);

        tabbedPane.addTab("Gastos", panelGastos);

        add(tabbedPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Application calculator = new Application();
    }
}
