import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author melihobut
 * @date 25.04.2020
 */
public class AddAnItem extends JFrame {
    
    //Properties
    private JButton BookAdvertButton;
    private JButton LectureNotesButton;
    private JButton MenuButton;
    private JLabel BookAdvertLabel;
    private JLabel LectureNotesLabel;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JLabel icon;
    
    /**
     * Constructor of AddAnItem
     */
    public AddAnItem() {
        initComponents();
    }


    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanel();
        BookAdvertButton = new JButton();
        BookAdvertLabel = new JLabel();
        LectureNotesLabel = new JLabel();
        LectureNotesButton = new JButton();
        jLabel3 = new JLabel();
        MenuButton = new JButton();
        icon = new JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        BookAdvertButton.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        BookAdvertButton.setForeground(new java.awt.Color(255, 153, 51));
        BookAdvertButton.setText("BOOK");
        BookAdvertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookAdvertButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 94, 0, 0);
        jPanel1.add(BookAdvertButton, gridBagConstraints);

        BookAdvertLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        BookAdvertLabel.setForeground(new java.awt.Color(255, 153, 0));
        BookAdvertLabel.setText("OR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 182, 0, 0);
        jPanel1.add(BookAdvertLabel, gridBagConstraints);

        LectureNotesLabel.setBackground(new java.awt.Color(255, 255, 255));
        LectureNotesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        LectureNotesLabel.setForeground(new java.awt.Color(255, 255, 255));
        LectureNotesLabel.setText("         ADD AN ITEM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 82, 0, 0);
        jPanel1.add(LectureNotesLabel, gridBagConstraints);

        LectureNotesButton.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        LectureNotesButton.setForeground(new java.awt.Color(255, 153, 0));
        LectureNotesButton.setText("LECTURE NOTES");
        LectureNotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LectureNotesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 94, 37, 0);
        jPanel1.add(LectureNotesButton, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("What kind of item would you like to add?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 34, 0, 20);
        jPanel1.add(jLabel3, gridBagConstraints);
        
        icon.setBackground(new Color(100, 100, 100));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setIcon(new ImageIcon("RESİM BURAYA GELECEK")); 
        icon.setLabelFor(icon);
        icon.setVerticalAlignment(SwingConstants.TOP);
        icon.setHorizontalTextPosition(SwingConstants.CENTER);
        icon.setMaximumSize(new Dimension(100, 100));
        icon.setMinimumSize(new Dimension(100, 100));
        icon.setPreferredSize(new Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;

        jPanel1.add(icon, gridBagConstraints);

        MenuButton.setForeground(new java.awt.Color(255, 153, 0));
        MenuButton.setText("MENU");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MenuButton, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    private void LectureNotesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //new LectureNotesAdvert();
    }

    private void BookAdvertButtonActionPerformed(java.awt.event.ActionEvent evt) {
      //  new BookAdvert();
    }

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //new MainPagePanel();
    }

    /**
     * Main Method
     * @param args 
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAnItem().setVisible(true);
            }
        });
    }

}
