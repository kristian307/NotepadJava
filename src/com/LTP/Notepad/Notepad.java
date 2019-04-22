package com.LTP.Notepad;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Notepad {

    private JTextArea textArea;

    private File currentFile;

    public Notepad(JTextArea text) {
        textArea = text;
    }

    public void CreateFileAction() {
        textArea.setText(null);
        currentFile = null;
    }

    public void OpenFileAction() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        currentFile = fileChooser.getSelectedFile();

        textArea.setText(GetTextAreaValue());
    }

    public void SaveFileAction() {
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile().getPath());
                currentFile = fileChooser.getSelectedFile();
                BufferedWriter out = new BufferedWriter(fileWriter);
                out.write(GetTextAreaValue());
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void ExitAction() {
        System.exit(0);
    }

    protected String GetTextAreaValue() {
        byte[] fileBytes = new byte[(int) currentFile.length()];

        try {
            FileInputStream stream = new FileInputStream(currentFile);
            stream.read(fileBytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String res = new String(fileBytes, StandardCharsets.UTF_8);
        return res;
    }

}
