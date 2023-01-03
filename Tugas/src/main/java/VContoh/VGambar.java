package VContoh;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class VGambar extends JFrame {
    private JPanel panel1;
    private JButton PilihBTN;
    private JLabel Gmbar;

    JFileChooser fChooser = new JFileChooser();

    private BufferedImage resizeImage(BufferedImage originalImage,int type){
       int IMG_HEIGHT = 0;
       int IMG_WIDTH = 0;
        BufferedImage resizeImage = new BufferedImage(IMG_HEIGHT,IMG_WIDTH,type);
        Graphics2D g = resizeImage.createGraphics();
        g.drawImage(originalImage,0,0,IMG_WIDTH,IMG_HEIGHT,null);
        g.dispose();
        return resizeImage;
    }

    public VGambar(){
        PilihBTN.addActionListener(e->{
            FileFilter filter = new FileNameExtensionFilter("Image Files", "jpg","png", "jpeg");
            fChooser.setFileFilter(filter);
            BufferedImage img = null;
            int result = fChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fChooser.getSelectedFile();
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();
                Gmbar.setIcon(new ImageIcon(String.valueOf(file)));
            }
        });
        init();
    }
    public void init() {
        setContentPane(panel1);
        setTitle("Input Data Gambar");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
         Gmbar = new JLabel(new ImageIcon(String.valueOf(fChooser)));
    }
}

