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
package org.publo.filebrowser;

import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import org.publo.Launcher;
import org.publo.filebrowser.controller.listener.EditableTreeCell;
import org.publo.filebrowser.controller.utils.FileTreeView;
import org.publo.filebrowser.controller.utils.PathTreeItem;

/**
 *
 * @author Antonio Cucchiara
 * @since 0.2
 */
public final class FileBrowser extends BorderPane {

    private final TreeView<String> treeView;

    public FileBrowser() {
        this(Launcher.PROJECTS_PATH);
    }

    public FileBrowser(final String rootPathString) {
        this(Paths.get(rootPathString));
    }

    public FileBrowser(final Path rootPath) {
        this.treeView = new FileTreeView<>(new PathTreeItem(rootPath));
        this.treeView.setEditable(true);
        this.treeView.setShowRoot(false);
        this.treeView.setCellFactory(
                (TreeView<String> tree)
                -> new EditableTreeCell((FileTreeView<String>) tree)
        );
        this.setCenter(this.treeView);
    }
    
    public void setRoot(final Path newRoot) {
        this.treeView.setRoot(new PathTreeItem(newRoot));
    }

    public final void addSelectionListener(ChangeListener listener) {
        this.treeView.getSelectionModel()
                .selectedItemProperty()
                .addListener(listener);
    }

}