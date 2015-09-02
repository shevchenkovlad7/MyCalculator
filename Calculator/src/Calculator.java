/**
 * Created by Vlad on 02.09.2015.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    // объявление компонентов на уровне класса
    private JFrame window;
    private JPanel mainPanel, inputPanel, outputPanel, buttonPanel;
    private JButton jbtnAdd, jbtnSubtract, jbtnMultiply, jbtnIntDivide, jbtnRealDivide, jbtnModulo, jbtnReset, jbtnExit;
    private JLabel jlblOut, jlblNum1Caption, jlblNum2Caption;
    private JTextField jtxtNum1, jtxtNum2;

    //конструктор
    public Calculator() {
        //создать фрейм
        window = new JFrame("Калькулятор");

        //по закрытию формы - закрывать приложение
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //установить запрет на расширение окна
        window.setResizable(false);

        //создать контейнеры - панели
        mainPanel = new JPanel(new BorderLayout());
        inputPanel = new JPanel();
        outputPanel = new JPanel();
        buttonPanel = new JPanel();

        //установить менеджера расположения для панелей
        inputPanel.setLayout(new GridLayout(1, 4));	//1 строка и 4 столбца
        outputPanel.setLayout(new GridLayout(1, 1));	//1 строка и 1 столбец
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5)); //1 строка и 4 столбца; расстояние между компонентами будет равно 5 (чтобы кнопки не слипались)

        //добавить панели на главную панель
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        //добавить главную панель на фрейм
        window.getContentPane().add(mainPanel);

        //добавить кнопки и текстовые поля на панели
        addButtonsAndTextFields();

        //установить необходимый размер фрейма и компонентов
        window.pack();
        window.setLocationRelativeTo(null); // для появления фрейма в центре экрана

        //отобразить фрейм - главное окно программы
        window.setVisible(true);
    }

    //добавление кнопко и текстовых полей на панели
    private void addButtonsAndTextFields() {

        //создать кнопки
        jbtnAdd = new JButton("Сложить");
        jbtnSubtract = new JButton("Вычесть");
        jbtnMultiply = new JButton("Умножить");
        jbtnIntDivide = new JButton("Целочисл.деление");
        jbtnRealDivide = new JButton("Деление");
        jbtnModulo = new JButton("Остаток от деления");
        jbtnReset = new JButton("Сброс");
        jbtnExit = new JButton("Выход");

        //создать текстовые метки
        jlblOut = new JLabel(" ", JLabel.CENTER);
        jlblNum1Caption = new JLabel("Число 1:", JLabel.RIGHT);
        jlblNum2Caption = new JLabel("Число 2:", JLabel.RIGHT);

        //создать текстовые поля
        jtxtNum1 = new JTextField();
        jtxtNum2 = new JTextField();

        // слушатели для кнопок
        jbtnAdd.addActionListener(this);
        jbtnSubtract.addActionListener(this);
        jbtnMultiply.addActionListener(this);
        jbtnIntDivide.addActionListener(this);
        jbtnRealDivide.addActionListener(this);
        jbtnModulo.addActionListener(this);
        jbtnReset.addActionListener(this);
        jbtnExit.addActionListener(this);

        //добавить кнопки на панели
        buttonPanel.add(jbtnAdd);
        buttonPanel.add(jbtnSubtract);
        buttonPanel.add(jbtnMultiply);
        buttonPanel.add(jbtnIntDivide);
        buttonPanel.add(jbtnRealDivide);
        buttonPanel.add(jbtnModulo);
        buttonPanel.add(jbtnReset);
        buttonPanel.add(jbtnExit);

        //добавить метки и текстовые поля на панели
        inputPanel.add(jlblNum1Caption);
        inputPanel.add(jtxtNum1);
        inputPanel.add(jlblNum2Caption);
        inputPanel.add(jtxtNum2);

        //добавить метку на панель
        outputPanel.add(jlblOut);
    }

    //метод для перехвата события нажатия кнопки
    @Override
    public void actionPerformed(ActionEvent event) {

        // определить нажатую кнопку и выполнить соотвествующую операцию
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

    // выход
    private void exit() {
        // показать пользователю сообщение для подтверждения
        int reponse = JOptionPane.showConfirmDialog(null, "Вы действительно хотите закрыть приложение?", "Подтверждение",
                JOptionPane.YES_NO_OPTION);

        //если пользователь нажал ДА
        if (reponse == JOptionPane.YES_OPTION) {

            //выйти из программы
            window.dispose();
            System.exit(0);
        }

    }

    //математические операции
    // сложить
    private void add() {

        int num1, num2, result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = num1 + num2;

            //записать результат
            displayData(num1, num2, "+", result);
        }
    }

    //вычесть
    private void subtract() {
        int num1, num2, result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = num1 - num2;

            //записать результат
            displayData(num1, num2, "-", result);
        }
    }

    //умножить
    private void multiply() {
        int num1, num2, result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = num1 * num2;

            //записать результат
            displayData(num1, num2, "*", result);
        }
    }

    //целочисл.деление
    private void intDivide() {

        int num1, num2, result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = num1 / num2;

            //записать результат
            displayData(num1, num2, "/", result);
        }
    }

    //деление
    private void realDivide() {

        int num1, num2;
        double result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = (double) num1 / (double) num2;

            //записать результат
            displayData(num1, num2, "/", result);
        }
    }

    //остаток от деления
    private void modulo() {

        int num1, num2, result;

        //проверить введенные данные
        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {
            //получить введенные числа
            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());

            //сделать расчет
            result = num1 % num2;

            //записать результат
            displayData(num1, num2, "%", result);
        }
    }

    //отображение результатов расчета, где результат будет целое число
    private void displayData(int num1, int num2, String op, int result) {

        //форматированный вывод
        String s = String.format("%d %s %d = %d", num1, op, num2, result);
        // записать результат в текстовую метку
        jlblOut.setText(s);

    }

    //перегруженный метод - отображение результатов расчета, где результат будет нецелое число
    private void displayData(int num1, int num2, String op, double result) {

        //форматированный вывод
        String s = String.format("%d %s %d = %.2f", num1, op, num2, result);
        // записать результат в текстовую метку
        jlblOut.setText(s);

    }

    //очищение данных в текстовых полях
    private void reset() {
        jlblOut.setText(" ");
        jtxtNum1.setText("");
        jtxtNum2.setText("");
        jtxtNum1.requestFocus();

    }

    //проверка данных, введенных пользователем
    private boolean isValidInput(JTextField jtxt, String description) {

        //если был введен какой-либо текст
        if (jtxt.getText().trim().length() > 0) {
            //проверка на ввод только целого числа
            try {
                //попытка преобразовать текст в целое число
                int num = Integer.parseInt(jtxt.getText());

                //если все нормально - возвращаем true
                return true;

            } catch (NumberFormatException e) {

                //предупреждение - неверный формат числа
                JOptionPane.showMessageDialog(window, "Вы должны ввести целое число!", "Ошибка", JOptionPane.WARNING_MESSAGE);

                //расположить курсор в текстово окне, чтобы пользователь еще раз ввел число
                jtxt.requestFocus();
                jtxt.selectAll();

                //ошибка - возвращаем false
                return false;
            }

        } else {// если пользователь не ввели никаких данных

            //предупреждение, что нужно ввести данные
            JOptionPane.showMessageDialog(window, "Введите число " + description, "Ошибка", JOptionPane.WARNING_MESSAGE);

            //расположить курсор в текстово окне, чтобы пользователь еще раз ввел число
            jtxt.requestFocus();
            jtxt.selectAll();

            //ошибка - возвращаем false
            return false;
        }
    }

    private static void setGUI() {
        //создать экземпляр класса Calculator
        Calculator gui = new Calculator();
    }

    //метод main - запуск программы происходит в этом методе
    public static void main(String[] args) {
        //создание компонентов в отдельном потоке
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                setGUI();
            }
        });
    }
}
