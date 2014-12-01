package db.operation;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());

        setLayout(new GridBagLayout());
        Container container  = getContentPane();

        Details details = new Details();
        details.setLocation(33,33);
        details.createToolTip();
        add(details);

    }
}
