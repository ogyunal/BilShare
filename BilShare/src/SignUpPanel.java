
/*
 *     Copyright 2020-2021 BilShare @ http://bil-share.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpPanel
     */
    public SignUpPanel() {
        initComponents();
    }
  

    private javax.swing.JButton alreadyHaveAnAccountButton;
    private javax.swing.JLabel bilShareLogo;
    private javax.swing.JLabel createAnAccountLabel;
    private javax.swing.JComboBox<String> departmentSelecter;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JButton signUpPressed;
    private javax.swing.JTextField surnameTextField;


    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        bilShareLogo = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        signUpPressed = new javax.swing.JButton();
        createAnAccountLabel = new javax.swing.JLabel();
        alreadyHaveAnAccountButton = new javax.swing.JButton();
        departmentSelecter = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(41, 204, 255));
        setForeground(new java.awt.Color(51, 204, 255));
        setToolTipText("");

        bilShareLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilShareLogo.png"))); 

        nameTextField.setText("Name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        surnameTextField.setText("Surname");
        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setText("Password");
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        emailTextField.setText("E-mail");
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        signUpPressed.setFont(new java.awt.Font("Luminari", 0, 36)); 
        signUpPressed.setText("Sign Up");
        signUpPressed.setToolTipText("");
        signUpPressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpPressedActionPerformed(evt);
            }
        });

        createAnAccountLabel.setFont(new java.awt.Font("Luminari", 0, 36)); 
        createAnAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        createAnAccountLabel.setText("Create An Account");

        alreadyHaveAnAccountButton.setText("Already Have An Account?");
        alreadyHaveAnAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alreadyHaveAnAccountButtonActionPerformed(evt);
            }
        });

        departmentSelecter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department", "CS", "EEE", "POLS", "IR", "ME", "IE", "GRA", "AMER", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bilShareLogo)
                                .addGap(515, 515, 515))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(createAnAccountLabel)
                                .addGap(453, 453, 453)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameTextField)
                                .addComponent(surnameTextField)
                                .addComponent(emailTextField)
                                .addComponent(passwordTextField)
                                .addComponent(alreadyHaveAnAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departmentSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(420, 420, 420)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(signUpPressed, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(435, 435, 435))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bilShareLogo)
                .addGap(26, 26, 26)
                .addComponent(createAnAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departmentSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alreadyHaveAnAccountButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpPressed, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // STORE NAME
    }

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // STORE SURNAME
    }

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // STORE PASSWORD
    }

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // STORE EMAIL
    }

    private void alreadyHaveAnAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alreadyHaveAnAccountButtonActionPerformed
        // SEGUE TO LOGIN PAGE
    }

    private void signUpPressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpPressedActionPerformed
        // SEGUE TO LOGIN PAGE
    }


   
}
