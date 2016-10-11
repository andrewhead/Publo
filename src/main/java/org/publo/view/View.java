/*
 * The MIT License
 *
 * Copyright 2016 Antonino Cucchiara.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.publo.view;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import org.publo.model.Model;

/**
 * Application Swing frontend.
 *
 * @author Antonio Cucchiara
 * @since 0.1
 */
public final class View extends JFrame {
    
    private static final String TITLE_PREFIX = "Publo - ";
    private static final DefaultBoundedRangeModel EDITOR_RANGE_MODEL
            = new DefaultBoundedRangeModel();
    
    private final Model model;

    /**
     * Creates new form UserInterface
     * @param model containing the business logic
     */
    public View(final Model model) {
        this.model = model;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel sourcePanel = new javax.swing.JPanel();
        textAreaScrollPanel = new javax.swing.JScrollPane();
        textAreaScrollPanel.getVerticalScrollBar().setModel(EDITOR_RANGE_MODEL);
        textArea = new javax.swing.JTextArea();
        previewPanel = new javax.swing.JPanel();
        editorScrollPanel = new javax.swing.JScrollPane();
        editorScrollPanel.getVerticalScrollBar().setModel(EDITOR_RANGE_MODEL);
        editorPanel = new javax.swing.JEditorPane();
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator itemOpsSeparator = new javax.swing.JPopupMenu.Separator();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator appOpsSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        helpContentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        sourcePanel.setLayout(new java.awt.BorderLayout());

        textAreaScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textAreaScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textAreaScrollPanel.setViewportView(textArea);

        sourcePanel.add(textAreaScrollPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(sourcePanel);

        previewPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        previewPanel.setLayout(new java.awt.BorderLayout());

        editorScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        editorScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        editorPanel.setContentType("text/html"); // NOI18N
        editorPanel.setText("<html>\r   <head>\r \r   </head>\r   <body>\r     <h1>\r      No Content \r     </h1>\r   </body>\r </html>\r ");
        editorPanel.setToolTipText("");
        editorPanel.setMargin(new java.awt.Insets(10, 10, 10, 10));
        editorScrollPanel.setViewportView(editorPanel);

        previewPanel.add(editorScrollPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(previewPanel);

        fileMenu.setText("File");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("New");
        fileMenu.add(newMenuItem);

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openItem.setText("Open");
        fileMenu.add(openItem);
        fileMenu.add(itemOpsSeparator);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save as...");
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(appOpsSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        helpContentsMenuItem.setText("Help Contents");
        helpMenu.add(helpContentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JEditorPane editorPanel;
    private javax.swing.JScrollPane editorScrollPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem helpContentsMenuItem;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTextArea textArea;
    private javax.swing.JScrollPane textAreaScrollPanel;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getHelpContentsMenuItem() {
        return helpContentsMenuItem;
    }

    public JMenuItem getNewMenuItem() {
        return newMenuItem;
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }

    public JPanel getPreviewPanel() {
        return previewPanel;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public JMenuItem getSaveAsMenuItem() {
        return saveAsMenuItem;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void showHelpContents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JEditorPane getEditorPanel() {
        return editorPanel;
    }

    public void updatePreview() {
        editorPanel.setText(model.getMarkup());
    }
    
    public void updateTitle() {
        String fileName = model.getOpenFile().getName();
        String suffix = (model.isChanged()) ? "*" : "";
        setTitle(TITLE_PREFIX + fileName + suffix);
    }
}
