package db.operation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Form {

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("New");
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File("/home/alexis/IdeaProjects/untitled/resourses/cover.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                new JLabel(new ImageIcon(myPicture));

                frame.setIconImage(myPicture);
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocation(2500, 300);
                frame.setVisible(true);
                frame.setBackground(Color.blue);

                System.out.println(frame.getGraphicsConfiguration());
                System.out.println(frame.getGraphics());
            }
        });
    }
}