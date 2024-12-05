import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    // JButton Элементы графического интерфейса (кнопки\окна)
    JButton btnStart, btnExit;
    SettingWindow settingWindow;
    Map map;

    GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // чтобы программа завершилась при закрытии окна
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("TicTacToe"); // заголовок
        setResizable(false); // запрещаем пользователю менять размер окна

        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");
        settingWindow = new SettingWindow(this); // ссылка на себя, основное окно
        map = new Map(); // игровое поле


        // слушатель действия
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // закрытие программы
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true); // делаем окно настроек видимым
            }
        });

        // JPanel создается панель (группу элементов)
        // GridLayout - компоновщик, где указывается число строк и столбцов. В нашем случае две кнопки
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);

        // BorderLayout - компоновщик, где нужно указать место
        add(panBottom, BorderLayout.SOUTH); // добавляем панель в окно, SOUTH - низ\юг
        add(map);

        setVisible(true); // указываем, что окно видимое
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX, sizeY, winLen);
    }
}