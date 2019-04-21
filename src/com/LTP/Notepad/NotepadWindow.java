package com.LTP.Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotepadWindow {

    Notepad notepad;

    private JFrame notepadWindow;

    private JPanel    textPanel;
    private JTextArea textArea;

    private JMenuBar menuBar;
    private JMenu    fileMenu;

    private JMenuItem createFileItem;
    private JMenuItem openFileItem;
    private JMenuItem exitItem;
    private JMenuItem saveFileItem;

    public NotepadWindow(int width, int height) {
        notepadWindow = new JFrame("Calculator");
        notepadWindow.setSize(width, height);
        notepadWindow.setLocationRelativeTo(null);
        notepadWindow.setResizable(false);
        notepadWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InitMenuBar();
        InitTextPanel();
        InitEventListeners();

        notepadWindow.setVisible(true);
    }

    private void InitMenuBar() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");

        createFileItem = new JMenuItem("New");
        openFileItem   = new JMenuItem("Open");
        saveFileItem   = new JMenuItem("Save");
        exitItem       = new JMenuItem("Exit");

        fileMenu.add(createFileItem);
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        notepadWindow.setJMenuBar(menuBar);
    }

    private void InitTextPanel() {
        textPanel = new JPanel(new BorderLayout());
        textArea =  new JTextArea();

        textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        notepadWindow.add(textPanel);

        notepad = new Notepad(textArea);
    }

    private void InitEventListeners() {
        createFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.CreateFileAction();
            }
        });

        openFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.OpenFileAction();
            }
        });

        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.SaveFileAction();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.ExitAction();
            }
        });
    }

}
