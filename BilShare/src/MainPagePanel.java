import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Yagmur
 * @author Elif
 */
public class MainPagePanel extends JPanel {

    /**
     * Creates new form NewMaınPagePanel
     */
    public MainPagePanel() {
        initComponents();
    }
    // Variables                     
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

   
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        setBackground(new Color(0, 204, 255));

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setForeground(new Color(255, 153, 51));
        jButton1.setText("MY PROFILE");
        jButton1.setBorderPainted(false);

        jButton2.setForeground(new Color(255, 153, 51));
        jButton2.setText("ADD AN ITEM");

        jButton3.setForeground(new Color(255, 153, 51));
        jButton3.setText("BOOKS");
        jButton3.setMaximumSize(new Dimension(113, 23));
        jButton3.setMinimumSize(new Dimension(113, 23));

        jButton4.setForeground(new Color(255, 153, 51));
        jButton4.setText("LECTURE NOTES");

        jLabel1.setIcon(new ImageIcon("C:\\Users\\Yagmur\\Desktop\\5d6f50df-9a91-4cb4-b547-903999ee292b.jpg")); // NOI18N

        jLabel2.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("LOOK FOR");

        jLabel3.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("OR");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton2))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4)
                        .addGap(51, 51, 51))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel3))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }
}
