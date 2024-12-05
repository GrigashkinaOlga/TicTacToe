import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 230;
    private static final String SELECT_FIELD_SIZES = "Выбранный размер поля: ";
    private static final String INSTALLED_LENGTH = "Установленная длина: ";

    JButton btnStart = new JButton("Start new game");
    JRadioButton aiRadioButton = new JRadioButton("Человек против компьютера");
    JRadioButton humanRadioButton = new JRadioButton("Человек против человека");
    JSlider sizeW = new JSlider(3, 10);
    JSlider sizeF = new JSlider(3, 10);
    GameWindow gameWindow;

    SettingWindow(GameWindow gameWindow) {  // вспомогательное окно принимает экземпляр основного для красивого оцентрирования
        this.gameWindow = gameWindow;
        setLocationRelativeTo(gameWindow); // местоположение относительно главному окну
        setSize(WIDTH, HEIGHT);

        JPanel setting = new JPanel(new GridLayout(0, 1));

        // Выбор типа игры

        JLabel gameModelLabel = new JLabel("Выберите режим игры");
        ButtonGroup gameModeGroup = new ButtonGroup();


        // Заголовок для выбора длины для победы
        JLabel winLengthLabel = new JLabel("Выберите длину для победы");

        JLabel selectWinLengthLabel = new JLabel(INSTALLED_LENGTH);


        // слушатель действия
        sizeW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int length = sizeW.getValue();
                selectWinLengthLabel.setText(INSTALLED_LENGTH + length);
            }
        });

        // выбор размеров поля
        JLabel fieldSizeLabel = new JLabel("Выберите размеры поля");

        JLabel selectedFieldSizeLabel = new JLabel(SELECT_FIELD_SIZES);


        // слушатель действия
        sizeF.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sizeF.getValue();
                selectedFieldSizeLabel.setText(INSTALLED_LENGTH + size);
                sizeW.setMaximum(size);
            }
        });

        // Заполнение панели
        setting.add(gameModelLabel);
        gameModeGroup.add(aiRadioButton);
        gameModeGroup.add(humanRadioButton);
        setting.add(aiRadioButton);
        setting.add(humanRadioButton);
        setting.add(fieldSizeLabel);
        setting.add(selectedFieldSizeLabel);
        setting.add(sizeF);
        setting.add(winLengthLabel);
        setting.add(selectWinLengthLabel);
        setting.add(sizeW);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        add(btnStart, BorderLayout.SOUTH);

        // добавляем панель настроек на основное окно
        add(setting);

    }

    public void startNewGame() {
        int mode = 0;
        if (aiRadioButton.isSelected()) {
            mode = 1;
        } else if (aiRadioButton.isSelected()) {
            mode = 2;
        }
        int sizeField = sizeF.getValue();
        int sizeWin = sizeW.getValue();
        gameWindow.startNewGame(mode, sizeField, sizeField, sizeWin);
        setVisible(false);
    }
}
