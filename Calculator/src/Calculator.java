/**
 * Created by Vlad on 02.09.2015.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    // ���������� ����������� �� ������ ������
    private JFrame window;
    private JPanel mainPanel, inputPanel, outputPanel, buttonPanel;
    private JButton jbtnAdd, jbtnSubtract, jbtnMultiply, jbtnIntDivide, jbtnRealDivide, jbtnModulo, jbtnReset, jbtnExit;
    private JLabel jlblOut, jlblNum1Caption, jlblNum2Caption;
    private JTextField jtxtNum1, jtxtNum2;

    //�����������
    public Calculator() {
        //������� �����
        window = new JFrame("�����������");

        //�� �������� ����� - ��������� ����������
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //���������� ������ �� ���������� ����
        window.setResizable(false);

        //������� ���������� - ������
        mainPanel = new JPanel(new BorderLayout());
        inputPanel = new JPanel();
        outputPanel = new JPanel();
        buttonPanel = new JPanel();

        //���������� ��������� ������������ ��� �������
        inputPanel.setLayout(new GridLayout(1, 4));	//1 ������ � 4 �������
        outputPanel.setLayout(new GridLayout(1, 1));	//1 ������ � 1 �������
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5)); //1 ������ � 4 �������; ���������� ����� ������������ ����� ����� 5 (����� ������ �� ���������)

        //�������� ������ �� ������� ������
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        //�������� ������� ������ �� �����
        window.getContentPane().add(mainPanel);

        //�������� ������ � ��������� ���� �� ������
        addButtonsAndTextFields();

        //���������� ����������� ������ ������ � �����������
        window.pack();
        window.setLocationRelativeTo(null); // ��� ��������� ������ � ������ ������

        //���������� ����� - ������� ���� ���������
        window.setVisible(true);
    }

    //���������� ������ � ��������� ����� �� ������
    private void addButtonsAndTextFields() {

        //������� ������
        jbtnAdd = new JButton("�������");
        jbtnSubtract = new JButton("�������");
        jbtnMultiply = new JButton("��������");
        jbtnIntDivide = new JButton("��������.�������");
        jbtnRealDivide = new JButton("�������");
        jbtnModulo = new JButton("������� �� �������");
        jbtnReset = new JButton("�����");
        jbtnExit = new JButton("�����");

        //������� ��������� �����
        jlblOut = new JLabel(" ", JLabel.CENTER);
        jlblNum1Caption = new JLabel("����� 1:", JLabel.RIGHT);
        jlblNum2Caption = new JLabel("����� 2:", JLabel.RIGHT);

        //������� ��������� ����
        jtxtNum1 = new JTextField();
        jtxtNum2 = new JTextField();

        // ��������� ��� ������
        jbtnAdd.addActionListener(this);
        jbtnSubtract.addActionListener(this);
        jbtnMultiply.addActionListener(this);
        jbtnIntDivide.addActionListener(this);
        jbtnRealDivide.addActionListener(this);
        jbtnModulo.addActionListener(this);
        jbtnReset.addActionListener(this);
        jbtnExit.addActionListener(this);

        //�������� ������ �� ������
        buttonPanel.add(jbtnAdd);
        buttonPanel.add(jbtnSubtract);
        buttonPanel.add(jbtnMultiply);
        buttonPanel.add(jbtnIntDivide);
        buttonPanel.add(jbtnRealDivide);
        buttonPanel.add(jbtnModulo);
        buttonPanel.add(jbtnReset);
        buttonPanel.add(jbtnExit);

        //�������� ����� � ��������� ���� �� ������
        inputPanel.add(jlblNum1Caption);
        inputPanel.add(jtxtNum1);
        inputPanel.add(jlblNum2Caption);
        inputPanel.add(jtxtNum2);

        //�������� ����� �� ������
        outputPanel.add(jlblOut);
    }

    //����� ��� ��������� ������� ������� ������
    @Override
    public void actionPerformed(ActionEvent event) {

        // ���������� ������� ������ � ��������� �������������� ��������
        if (event.getSource() == jbtnAdd) {
            add();
        } else if (event.getSource() == jbtnSubtract) {
            subtract();
        } else if (event.getSource() == jbtnMultiply) {
            multiply();
        } else if (event.getSource() == jbtnIntDivide) {
            intDivide();
        } else if (event.getSource() == jbtnRealDivide) {
            realDivide();
        } else if (event.getSource() == jbtnModulo) {
            modulo();
        } else if (event.getSource() == jbtnReset) {
            reset();
        } else if (event.getSource() == jbtnExit) {
            exit();
        }
    }

    // �����
    private void exit() {
        // �������� ������������ ��������� ��� �������������
        int reponse = JOptionPane.showConfirmDialog(null, "�� ������������� ������ ������� ����������?", "�������������",
                JOptionPane.YES_NO_OPTION);

        //���� ������������ ����� ��
        if (reponse == JOptionPane.YES_OPTION) {

            //����� �� ���������
            window.dispose();
            System.exit(0);
        }

    }

    //�������������� ��������
    // �������
    private void add() {

        int num1, num2, result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = num1 + num2;

            //�������� ���������
            displayData(num1, num2, "+", result);
        }
    }

    //�������
    private void subtract() {
        int num1, num2, result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = num1 - num2;

            //�������� ���������
            displayData(num1, num2, "-", result);
        }
    }

    //��������
    private void multiply() {
        int num1, num2, result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = num1 * num2;

            //�������� ���������
            displayData(num1, num2, "*", result);
        }
    }

    //��������.�������
    private void intDivide() {

        int num1, num2, result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = num1 / num2;

            //�������� ���������
            displayData(num1, num2, "/", result);
        }
    }

    //�������
    private void realDivide() {

        int num1, num2;
        double result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = (double) num1 / (double) num2;

            //�������� ���������
            displayData(num1, num2, "/", result);
        }
    }

    //������� �� �������
    private void modulo() {

        int num1, num2, result;

        //��������� ��������� ������
        if ((isValidInput(jtxtNum1, "����� 1")) && (isValidInput(jtxtNum2, "����� 2"))) {
            //�������� ��������� �����
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //������� ������
            result = num1 % num2;

            //�������� ���������
            displayData(num1, num2, "%", result);
        }
    }

    //����������� ����������� �������, ��� ��������� ����� ����� �����
    private void displayData(int num1, int num2, String op, int result) {

        //��������������� �����
        String s = String.format("%d %s %d = %d", num1, op, num2, result);
        // �������� ��������� � ��������� �����
        jlblOut.setText(s);

    }

    //������������� ����� - ����������� ����������� �������, ��� ��������� ����� ������� �����
    private void displayData(int num1, int num2, String op, double result) {

        //��������������� �����
        String s = String.format("%d %s %d = %.2f", num1, op, num2, result);
        // �������� ��������� � ��������� �����
        jlblOut.setText(s);

    }

    //�������� ������ � ��������� �����
    private void reset() {
        jlblOut.setText(" ");
        jtxtNum1.setText("");
        jtxtNum2.setText("");
        jtxtNum1.requestFocus();

    }

    //�������� ������, ��������� �������������
    private boolean isValidInput(JTextField jtxt, String description) {

        //���� ��� ������ �����-���� �����
        if (jtxt.getText().trim().length() > 0) {
            //�������� �� ���� ������ ������ �����
            try {
                //������� ������������� ����� � ����� �����
                int num = Integer.parseInt(jtxt.getText());

                //���� ��� ��������� - ���������� true
                return true;

            } catch (NumberFormatException e) {

                //�������������� - �������� ������ �����
                JOptionPane.showMessageDialog(window, "�� ������ ������ ����� �����!", "������", JOptionPane.WARNING_MESSAGE);

                //����������� ������ � �������� ����, ����� ������������ ��� ��� ���� �����
                jtxt.requestFocus();
                jtxt.selectAll();

                //������ - ���������� false
                return false;
            }

        } else {// ���� ������������ �� ����� ������� ������

            //��������������, ��� ����� ������ ������
            JOptionPane.showMessageDialog(window, "������� ����� " + description, "������", JOptionPane.WARNING_MESSAGE);

            //����������� ������ � �������� ����, ����� ������������ ��� ��� ���� �����
            jtxt.requestFocus();
            jtxt.selectAll();

            //������ - ���������� false
            return false;
        }
    }

    private static void setGUI() {
        //������� ��������� ������ Calculator
        Calculator gui = new Calculator();
    }

    //����� main - ������ ��������� ���������� � ���� ������
    public static void main(String[] args) {
        //�������� ����������� � ��������� ������
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                setGUI();
            }
        });
    }
}
