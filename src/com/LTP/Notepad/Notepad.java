package com.LTP.Notepad;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Notepad {

    private JTextArea textArea;

    private File currentFile;

    public Notepad(JTextArea text) {
        this.textArea = text;
    }

    public void CreateFileAction() {
        textArea.setText(null);
        currentFile = null;
    }

    public void OpenFileAction() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        currentFile = fileChooser.getSelectedFile();

        textArea.setText(new String(GetTextAreaValue(currentFile.length()), StandardCharsets.UTF_8));
    }

    public void SaveFileAction() {

    }

    public void ExitAction() {

    }

    protected byte[] GetTextAreaValue(long lengthFile) {
        byte[] fileBytes = new byte[(int) lengthFile];

        try {
            FileInputStream stream = new FileInputStream(currentFile);
            stream.read(fileBytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileBytes;
    }

}
