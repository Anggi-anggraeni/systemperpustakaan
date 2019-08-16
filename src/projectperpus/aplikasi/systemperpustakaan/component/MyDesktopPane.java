package projectperpus.aplikasi.systemperpustakaan.component;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class MyDesktopPane extends JDesktopPane{
    public static void cascade( JDesktopPane desktopPane, int layer ) {
        JInternalFrame[] frames = desktopPane.getAllFramesInLayer( layer );
        if ( frames.length == 0) return;

        cascade( frames, desktopPane.getBounds(), 24 );
    }

    public static void cascade( JDesktopPane desktopPane ) {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        if ( frames.length == 0) return;

        cascade( frames, desktopPane.getBounds() );
    }

    private static void cascade( JInternalFrame[] frames, Rectangle dBounds, int separation ) {
        int margin = frames.length*separation + separation;
        int width = dBounds.width - margin;
        int height = dBounds.height - margin;
        for ( int i = 0; i < frames.length; i++) {
            frames[i].setBounds( separation + dBounds.x + i*separation,
                                 separation + dBounds.y + i*separation,
                                 width, height );
        }
    }

    private static void cascade( JInternalFrame[] frames, Rectangle dBounds ) {
    int margin = 0;

    Insets ins = null;
    Dimension d, cd;
    for ( int i = 0; i < frames.length; i++) {
        d = frames[i].getSize();
        cd = frames[i].getContentPane().getSize();
        margin += Math.max( d.width - cd.width,
                            d.height - cd.height );
    }

    int width = dBounds.width - margin;
    int height = dBounds.height - margin;
    int offset = 0;
    for ( int i = 0; i < frames.length; i++) {
        frames[i].setBounds( dBounds.x + offset,
                             dBounds.y + offset,
                             width, height );
        d = frames[i].getSize();
        cd = frames[i].getContentPane().getSize();
        offset += Math.max( d.width - cd.width,
                            d.height - cd.height );
    }
}

    public static void tile( JDesktopPane desktopPane, int layer ) {
        JInternalFrame[] frames = desktopPane.getAllFramesInLayer( layer );
        if ( frames.length == 0) return;
        tile( frames, desktopPane.getBounds() );
    }
    public static void tileHorizontal( JDesktopPane desktopPane ) {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        if ( frames.length == 0) return;
        tile( frames, desktopPane.getBounds() );
    }
    private static void tile( JInternalFrame[] frames, Rectangle dBounds ) {
        int cols = (int)Math.sqrt(frames.length);System.out.println("cols: "+cols);
        int rows = (int)(Math.ceil( ((double)frames.length) / cols));System.out.println("rows: "+rows);
        int lastRow = frames.length - cols*(rows-1);System.out.println("lastRow: "+lastRow);
        int width, height;

        if ( lastRow == 0 ) {
            rows--;
            height = dBounds.height / rows;
        }
        else {
            height = dBounds.height / rows;
            if ( lastRow < cols ) {
                rows--;
                width = dBounds.width / lastRow;
                for (int i = 0; i < lastRow; i++ ) {
                    frames[cols*rows+i].setBounds( i*width, rows*height,
                                                   width, height );
                }
            }
        }

        width = dBounds.width/cols;
        for (int j = 0; j < rows; j++ ) {
            for (int i = 0; i < cols; i++ ) {
                frames[i+j*cols].setBounds( i*width, j*height, width, height );
            }
        }
    }

    public static void tileVertical(JDesktopPane desk){
        // How many frames do we have?
        JInternalFrame[] allframes = desk.getAllFrames();
        int count = allframes.length;
        if (count == 0)
          return;

        // Determine the necessary grid size
        int sqrt = (int) Math.sqrt(count);
        int rows = sqrt;
        int cols = sqrt;
        if (rows * cols < count) {
          cols++;
          if (rows * cols < count) {
            rows++;
          }
        }

        // Define some initial values for size & location.
        Dimension size = desk.getSize();

        int w = size.width / cols;
        int h = size.height / rows;
        int x = 0;
        int y = 0;

        // Iterate over the frames, deiconifying any iconified frames and then
        // relocating & resizing each.
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols && ((i * cols) + j < count); j++) {
            JInternalFrame f = allframes[(i * cols) + j];

            if (!f.isClosed() && f.isIcon()) {
              try {
                f.setIcon(false);
              } catch (PropertyVetoException ignored) {
              }
            }

            desk.getDesktopManager().resizeFrame(f, x, y, w, h);
            x += w;
          }
          y += h; // start the next row
          x = 0;
        }
  
    }


}
