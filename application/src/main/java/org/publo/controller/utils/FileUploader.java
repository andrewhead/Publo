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
package org.publo.controller.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.publo.controller.utils.Dialogs.Credentials;
import static org.publo.controller.utils.SiteExporter.TARGET_PATH;

/**
 * Uploads the compiled site to a remote host.
 *
 * @author Antonio Cucchiara
 * @since 0.4
 */
public class FileUploader {

    /**
     * The {@code FileUploader} Logger.
     */
    private static final Logger LOGGER
            = Logger.getLogger(FileUploader.class.getName());

    /**
     * Creates an FTP Client, walks the compiled file tree for the site and
     * uploads it to the remote host.
     *
     * The FTP Client will be initialised with the host name entered on creation
     * of the project. Details are gathered from the site property file
     * {@link config.properties}. The required entry for this functionality to
     * operate is: {@link ftp.url}.
     *
     * The method used for the upload is the "local passive mode" to avoid the
     * implementation of local firewall rules.
     *
     * Upload, at this stage, will simply make a remote copy of the files
     * overriding their remote counterparts.
     *
     * A dialog for the FTP server username and password will be presented to
     * the user before client initialisation.
     *
     */
    public static void upload() {
        // TODO upload on a per-project basis.
        // From the pref file
        String hostname = "127.0.0.1";
        final Credentials cred = Dialogs.showLoginDialog();

        final FTPClient client = new FTPClient();
        try {
            client.connect(hostname);
            client.login(cred.getUsername(), cred.getPassword());
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);

            Files.walkFileTree(TARGET_PATH, new SimpleFileVisitor<Path>() {

                /**
                 * Before visiting a directory attempt to change the ftp client
                 * working directory to the one being walked. If it does not
                 * exist, create it and move to the newly created working
                 * directory.
                 *
                 * @param directory in analysis
                 * @param attrs unused
                 * @return CONTINUE
                 * @throws IOException
                 */
                @Override
                public FileVisitResult preVisitDirectory(
                        final Path directory,
                        final BasicFileAttributes attrs)
                        throws IOException {
                    final Path remotePath = TARGET_PATH.relativize(directory);
                    LOGGER.log(Level.INFO, "Moving to directory {0}",
                            remotePath);
                    final String remotePathString = remotePath.toString();
                    if (!client.changeWorkingDirectory(remotePathString)) {
                        client.makeDirectory(remotePathString);
                        client.changeWorkingDirectory(remotePathString);
                    }
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * After visiting a directory move back to its parent.
                 *
                 * @param directory in analysis
                 * @param exc unused
                 * @return CONTINUE
                 * @throws IOException
                 */
                @Override
                public FileVisitResult postVisitDirectory(
                        final Path directory,
                        final IOException exc)
                        throws IOException {
                    client.changeToParentDirectory();
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * Visit the local file and upload it through the FTPClient.
                 *
                 * @param filePath of the resource to upload
                 * @param attrs unused
                 * @return CONTINUE
                 * @throws IOException
                 */
                @Override
                public FileVisitResult visitFile(
                        Path filePath,
                        BasicFileAttributes attrs)
                        throws IOException {
                    LOGGER.log(Level.INFO, "Uploading local {0}", filePath);
                    final File file = filePath.toFile();
                    try (FileInputStream inputStream
                            = new FileInputStream(file)) {
                        final String fileName = file.getName();
                        LOGGER.log(Level.INFO, "Uploading remote {0}",
                                fileName);
                        boolean done = client.storeFile(fileName, inputStream);
                        if (done) {
                            LOGGER.log(Level.INFO,
                                    "File {0} successfully uploaded.",
                                    filePath);
                        } else {
                            LOGGER.log(Level.WARNING,
                                    "Failed to upload file {0}.",
                                    filePath);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (final ConnectException ex) {
            final Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable to upload the site");
            alert.setHeaderText("Error whilst uploading your site");
            alert.setContentText("Please check you are connected to the "
                    + "internet. And that the FTP server is reachable "
                    + "from your machine.");
            alert.showAndWait();
            LOGGER.log(Level.SEVERE, "No internet connection.", ex);
        } catch (final IOException ex) {
            LOGGER.log(Level.SEVERE, "Could not upload site.", ex);
        } finally {
            try {
                if (client.isConnected()) {
                    client.logout();
                    client.disconnect();
                }
                final Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Upload completed");
                alert.setContentText("Your site has been successfully uploaded.");
                alert.showAndWait();
            } catch (final IOException ex) {
                LOGGER.log(Level.SEVERE, "Error initialising the FTP Client",
                        ex);
            }
        }
    }
}
