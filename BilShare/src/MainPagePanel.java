import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author Yagmur
 * @author Elif
 */
public class MainPagePanel extends JFrame {

	// Variables                 
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    /**
     * Creates new form NewJFrame
     */
    public MainPagePanel() {
        initComponents();
    }
                       
    private void initComponents() {

        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton5 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(51, 204, 255));

        jButton2.setBackground(new Color(255, 255, 255));
        jButton2.setForeground(new Color(255, 153, 0));
        jButton2.setText("ADD AN ITEM");
        
        jButton3.setBackground(new Color(255, 255, 255));
        jButton3.setForeground(new Color(255, 153, 0));
        jButton3.setText("BOOKS");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setBackground(new Color(255, 255, 255));
        jButton4.setForeground(new Color(255, 153, 0));
        jButton4.setText("LECTURE NOTES");
        
        jButton5.setBackground(new Color(255, 255, 255));
        jButton5.setForeground(new Color(255, 153, 0));
        jButton5.setText("MY PROFILE");

        jLabel1.setFont(new Font("Tahoma", 0, 24)); 
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("LOOK FOR");

        jLabel2.setBackground(new Color(51, 153, 255));
        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("OR");

        jLabel3.setBackground(new Color(100, 100, 100));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon("C:\\Users\\Yagmur\\Desktop\\5d6f50df-9a91-4cb4-b547-903999ee292b.jpg")); 
        jLabel3.setLabelFor(jLabel3);
        jLabel3.setVerticalAlignment(SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel3.setMaximumSize(new Dimension(100, 100));
        jLabel3.setMinimumSize(new Dimension(100, 100));
        jLabel3.setPreferredSize(new Dimension(100, 100));


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(67, 67, 67)
                .addComponent(jButton4)
                .addGap(84, 84, 84))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(220, 220, 220))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    private void jButton3ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPagePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainPagePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainPagePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainPagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPagePanel().setVisible(true);
            }
        });
    }                 
}
