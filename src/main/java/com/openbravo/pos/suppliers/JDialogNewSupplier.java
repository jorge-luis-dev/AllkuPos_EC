//    Allku Pos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://www.allku.expert
//
//    This file is part of Allku Pos
//
//    Allku Pos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Allku Pos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Allku Pos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.suppliers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.gui.MessageInf;
import com.openbravo.data.loader.LocalRes;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSales;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import expert.allku.identification.*;
import javax.swing.JOptionPane;

public class JDialogNewSupplier extends javax.swing.JDialog {
    
    private DataLogicSuppliers dlSupplier;
    private DataLogicSales dlSales;
    private TableDefinition tsuppliers;
    private SupplierInfoExt selectedSupplier;
    private Object m_oId;
    private SentenceList sentenceIdentificationType;
    private ComboBoxValModel modelIdentificationType;
    
    /** Creates new form quick New Supplier
     * @param parent */
    protected JDialogNewSupplier(java.awt.Frame parent) {
        super(parent, true);
    }
    
    /** Creates new form quick New Supplier
     * @param parent */
    protected JDialogNewSupplier(java.awt.Dialog parent) {
        super(parent, true);
    } 
    
    private void init(AppView app) {
        try {
            dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
            dlSupplier = (DataLogicSuppliers) app.getBean("com.openbravo.pos.suppliers.DataLogicSuppliers");
            tsuppliers = dlSupplier.getTableSuppliers();
            sentenceIdentificationType = dlSales.getIdentificationList();
            
            initComponents();
            
            modelIdentificationType = new ComboBoxValModel(
                    sentenceIdentificationType.list());
            cBoxIdentificationType.setModel(modelIdentificationType);
            modelIdentificationType.setSelectedFirst();
            
            jLblSearchkey.setVisible(false);
            m_jSearchkey.setVisible(false);
            
            getRootPane().setDefaultButton(m_jBtnOK);
        } catch (BasicException ex) {
            Logger.getLogger(JDialogNewSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public Object createValue() throws BasicException {
        Object[] supplier = new Object[23];
        supplier[0] = m_oId;        
        supplier[1] = m_jTaxID.getText();//m_jSearchkey.getText();
        supplier[2] = m_jTaxID.getText();
        supplier[3] = m_jName.getText();
        supplier[4] = 0.0;
        supplier[5] = Formats.STRING.parseValue(txtAddress.getText());
        supplier[6] = null;
        supplier[7] = null;
        supplier[8] = null;
        supplier[9] = null;
        supplier[10] = null; 
        supplier[11] = Formats.STRING.parseValue(txtFirstName.getText());
        supplier[12] = Formats.STRING.parseValue(txtLastName.getText());
        supplier[13] = Formats.STRING.parseValue(txtEmail.getText());
        supplier[14] = Formats.STRING.parseValue(txtPhone.getText());
        supplier[15] = Formats.STRING.parseValue(txtPhone2.getText());
        supplier[16] = null;        
        supplier[17] = null;
        supplier[18] = true;
        supplier[19] = null;
        supplier[20] = 0.0;
        supplier[21] = null;  
        supplier[22] = modelIdentificationType.getSelectedKey();
        
        return supplier;
    }

    
    public static JDialogNewSupplier getDialog(Component parent,AppView app) {
         
        Window window = getWindow(parent);        
        JDialogNewSupplier quicknewsupplier;        
        
        if (window instanceof Frame) { 
            quicknewsupplier = new JDialogNewSupplier((Frame) window);
        } else {
            quicknewsupplier = new JDialogNewSupplier((Dialog) window);
        }
        
        quicknewsupplier.init(app);         
        
        return quicknewsupplier;
    } 
    
    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    public SupplierInfoExt getSelectedSupplier() {
        return selectedSupplier;
    }
    
   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLblTaxID = new javax.swing.JLabel();
        m_jTaxID = new javax.swing.JTextField();
        jLblSearchkey = new javax.swing.JLabel();
        m_jSearchkey = new javax.swing.JTextField();
        jLblName = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();
        jLblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLblTelephone1 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLblTelephone2 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        cBoxIdentificationType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        m_jBtnCancel = new javax.swing.JButton();
        m_jBtnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("label.supplier")); // NOI18N
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setResizable(false);

        jPanel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(620, 340));

        jLblTaxID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTaxID.setText(AppLocal.getIntString("label.taxid")); // NOI18N
        jLblTaxID.setMaximumSize(new java.awt.Dimension(150, 30));
        jLblTaxID.setMinimumSize(new java.awt.Dimension(140, 25));
        jLblTaxID.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jTaxID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jTaxID.setPreferredSize(new java.awt.Dimension(150, 30));

        jLblSearchkey.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblSearchkey.setText(AppLocal.getIntString("label.searchkeym")); // NOI18N
        jLblSearchkey.setPreferredSize(new java.awt.Dimension(82, 30));

        m_jSearchkey.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jSearchkey.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        m_jSearchkey.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        m_jSearchkey.setPreferredSize(new java.awt.Dimension(150, 30));

        jLblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblName.setText(AppLocal.getIntString("label.supplier")); // NOI18N
        jLblName.setMaximumSize(new java.awt.Dimension(140, 25));
        jLblName.setMinimumSize(new java.awt.Dimension(140, 25));
        jLblName.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jName.setPreferredSize(new java.awt.Dimension(400, 30));
        m_jName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                m_jNameFocusGained(evt);
            }
        });

        jLblFirstName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblFirstName.setText(AppLocal.getIntString("label.firstname")); // NOI18N
        jLblFirstName.setAlignmentX(0.5F);
        jLblFirstName.setPreferredSize(new java.awt.Dimension(150, 30));

        txtFirstName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFirstName.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblLastName.setText(AppLocal.getIntString("label.lastname")); // NOI18N
        jLblLastName.setPreferredSize(new java.awt.Dimension(150, 30));

        txtLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLastName.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblEmail.setText(AppLocal.getIntString("label.email")); // NOI18N
        jLblEmail.setPreferredSize(new java.awt.Dimension(150, 30));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblTelephone1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTelephone1.setText(AppLocal.getIntString("label.phone")); // NOI18N
        jLblTelephone1.setPreferredSize(new java.awt.Dimension(150, 30));

        txtPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhone.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblTelephone2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTelephone2.setText(AppLocal.getIntString("label.phone2")); // NOI18N
        jLblTelephone2.setPreferredSize(new java.awt.Dimension(150, 30));

        txtPhone2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhone2.setPreferredSize(new java.awt.Dimension(200, 30));

        cBoxIdentificationType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Tipo Identificación");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText(AppLocal.getIntString("label.address")); // NOI18N
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 30));

        txtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAddress.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblTelephone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblTelephone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLblTaxID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLblSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(m_jSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(m_jTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cBoxIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 69, Short.MAX_VALUE)))))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jBtnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        m_jBtnCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jBtnCancel.setFocusPainted(false);
        m_jBtnCancel.setFocusable(false);
        m_jBtnCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnCancel.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnCancel.setRequestFocusEnabled(false);
        m_jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnCancel);

        m_jBtnOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jBtnOK.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jBtnOK.setFocusPainted(false);
        m_jBtnOK.setFocusable(false);
        m_jBtnOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnOK.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnOK.setRequestFocusEnabled(false);
        m_jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnOK);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(628, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnOKActionPerformed
        if (validateBlank() && 
                 validateIdentification((String) modelIdentificationType.getSelectedKey(), 
                         m_jTaxID.getText())) { 
            try {
                m_oId = m_jTaxID.getText();//UUID.randomUUID().toString();
                Object supplier = createValue() ;                       
                int status = tsuppliers.getInsertSentence().exec(supplier);
                if (status>0){
                    selectedSupplier =  dlSales.loadSupplierExt(m_oId.toString());
                    dispose();
                }else{
                    MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, 
                           LocalRes.getIntString("message.nosave"), "Error save");
                   msg.show(this);
                }
            } catch (BasicException ex) {
               MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, 
                       LocalRes.getIntString("message.nosave"), ex);
                msg.show(this);
            }
        }
    }//GEN-LAST:event_m_jBtnOKActionPerformed
    
    private Boolean validateBlank() {
        if ("".equals(m_jTaxID.getText())
                || "".equals(m_jName.getText())) {
            JOptionPane.showMessageDialog(
                null, 
                AppLocal.getIntString("message.customercheck"), 
                "Validación del cliente", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validateIdentification(String identificationType, String identification) {
        if (identificationType.equals("C")) {
            Ci ci = new Ci(identification);
            if(!ci.validar()) {
                JOptionPane.showMessageDialog(this,
                        ci.getError(), 
                        "Error al validar la cédula", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else if (identificationType.equals("R")) {
            Ruc ruc = new Ruc(identification);
            if(!ruc.validar()) {
                JOptionPane.showMessageDialog(this,
                        ruc.getError(), 
                        "Error al validar la RUC", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else if (identificationType.equals("CF")) {
            if (!identification.equals("9999999999999")) {
                JOptionPane.showMessageDialog(this,
                        "El consumidor final debe ser 9999999999999", 
                        "Error al validar el Consumidor Final", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    private void m_jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnCancelActionPerformed
        dispose();        
    }//GEN-LAST:event_m_jBtnCancelActionPerformed

    private void m_jNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_m_jNameFocusGained
        if (m_jName.getText().isEmpty()) {
            m_jName.setText(txtLastName.getText() + " " + txtFirstName.getText());
        }
    }//GEN-LAST:event_m_jNameFocusGained
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cBoxIdentificationType;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblFirstName;
    private javax.swing.JLabel jLblLastName;
    private javax.swing.JLabel jLblName;
    private javax.swing.JLabel jLblSearchkey;
    private javax.swing.JLabel jLblTaxID;
    private javax.swing.JLabel jLblTelephone1;
    private javax.swing.JLabel jLblTelephone2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton m_jBtnCancel;
    private javax.swing.JButton m_jBtnOK;
    private javax.swing.JTextField m_jName;
    private javax.swing.JTextField m_jSearchkey;
    private javax.swing.JTextField m_jTaxID;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhone2;
    // End of variables declaration//GEN-END:variables
    
}
