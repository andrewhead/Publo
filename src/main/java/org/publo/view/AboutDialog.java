/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.publo.view;

import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author antonio
 */
public class AboutDialog extends JDialog {

    /**
     * Creates new form AboutDialog
     * @param parent
     * @param modal
     */
    public AboutDialog(Frame parent, boolean modal) {
        super(parent, modal);
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

        javax.swing.JScrollPane aboutDialogScrollPane = new javax.swing.JScrollPane();
        javax.swing.JEditorPane aboutDialogEditoPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Publo");
        setMaximumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));

        aboutDialogEditoPane.setEditable(false);
        aboutDialogEditoPane.setContentType("text/html"); // NOI18N
        aboutDialogEditoPane.setText("<html>\r\n  <head>\r\n  </head>\r\n  <body>\r\n    <h1 style=\"text-align:center\">Publo</h1>\n    <p style=\"text-align:center\">The cross-platform,\r distraction-less<br/>markdown editor.</p>\n    <ul>\n    <li>Author: Antonino Cucchiara</li>\n    <li>Homepage: https://github.com/AntoCuc/Publo</li>\n    </ul>\n    <h4 style=\"text-align:center\">The MIT license</h4>\n    <p>Copyright 2016 Antonino Cucchiara.</p>\n<p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: </p>\n<p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. </p>\n<p>THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. </p>\n  </body>\r\n</html>\r\n");
        aboutDialogEditoPane.setPreferredSize(new java.awt.Dimension(400, 300));
        aboutDialogScrollPane.setViewportView(aboutDialogEditoPane);

        getContentPane().add(aboutDialogScrollPane, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
