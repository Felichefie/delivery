import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

public class tabla1s extends JPanel {
    public static ImageIcon resize(ImageIcon image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }

    private ImageIcon loadImage(String path) {
        try {
            if (path.startsWith("http")) {
                URL url = new URL(path);
                return new ImageIcon(ImageIO.read(url));
            } else {
                return new ImageIcon(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public tabla1s() {
        String[] columnNames = {"Picture", "Description", "Costo", "Cantidad", "Carrito"};
        String[] figs = {
                "fig1.jpg",
                "https://previews.123rf.com/images/kongvector/kongvector1707/kongvector170700610/81725770-tenga-una-idea-caricatura-del-car%C3%A1cter-de-la-pera.jpg",
                "https://m.media-amazon.com/images/I/81pM+T5uRrS._AC_SL1500_.jpg",
                "https://www.ipp.edu.pe/blog/wp-content/uploads/2020/05/shutterstock_1489158410.jpg"};

        ArrayList<Object[]> al = new ArrayList<Object[]>();

        for (String fig : figs) {
            ImageIcon imageIcon = resize(loadImage(fig), 60, 60);
            al.add(new Object[]{imageIcon, "col2", "col3", "col4", "col5"});
        }

        Object[][] data = new Object[al.size()][];
        for (int i = 0; i < data.length; i++) {
            Object[] row = al.get(i);
            data[i] = row;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return ImageIcon.class;
                    default:
                        return String.class;
                }
            }
        };

        JTable table = new JTable(model);
        table.setPreferredSize(new Dimension(1024, 1024));
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        table.setRowHeight(70);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.add(new tabla1s());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
