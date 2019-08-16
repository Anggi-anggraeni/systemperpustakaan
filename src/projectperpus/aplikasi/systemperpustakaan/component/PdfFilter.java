package projectperpus.aplikasi.systemperpustakaan.component;

import projectperpus.aplikasi.systemperpustakaan.utility.FilterUtility;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class PdfFilter extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = FilterUtility.getExtension(f);
        if (extension != null) {
            if (extension.equals(FilterUtility.pdf)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Portable Document File";
    }
}
