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

package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Jorge Luis
 */
public class EstablishmentEditor extends JPanel implements EditorRecord {

    private Object m_oId;
    private DataLogicEstablishment dlEstablishments;

    /**
     * Creates new form taxEditor
     *
     * @param app
     * @param dirty
     */
    public EstablishmentEditor(AppView app, DirtyManager dirty) {

        dlEstablishments = (DataLogicEstablishment) app.getBean("com.openbravo.pos.admin.DataLogicEstablishment");
        initComponents();

        txtCode.getDocument().addDocumentListener(dirty);
        txtComercialName.getDocument().addDocumentListener(dirty);
        txtAddress.getDocument().addDocumentListener(dirty);
        txtCity.getDocument().addDocumentListener(dirty);
        txtStatus.getDocument().addDocumentListener(dirty);

        writeValueEOF();
    }

    /**
     *
     * @throws BasicException
     */
    public void activate() throws BasicException {

    }

    /**
     *
     */
    @Override
    public void refresh() {

    }

    /**
     *
     */
    @Override
    public void writeValueEOF() {
        m_oId = null;
        txtCode.setText(null);
        txtComercialName.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        txtStatus.setText(null);

        txtCode.setEnabled(false);
        txtComercialName.setEnabled(false);
        txtAddress.setEnabled(false);
        txtCity.setEnabled(false);
        txtStatus.setEnabled(false);
    }

    /**
     *
     */
    @Override
    public void writeValueInsert() {
        m_oId = null;
        txtCode.setText(null);
        txtComercialName.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        txtStatus.setText(null);

        txtCode.setEnabled(true);
        txtComercialName.setEnabled(true);
        txtAddress.setEnabled(true);
        txtCity.setEnabled(true);
        txtStatus.setEnabled(true);
    }

    /**
     *
     * @param value
     */
    @Override
    public void writeValueDelete(Object value) {

        Object[] establishment = (Object[]) value;
        m_oId = establishment[0];
        txtCode.setText(Formats.STRING.formatValue(establishment[0]));
        txtComercialName.setText(Formats.STRING.formatValue(establishment[1]));
        txtAddress.setText(Formats.STRING.formatValue(establishment[2]));
        txtCity.setText(Formats.STRING.formatValue(establishment[3]));
        txtStatus.setText(Formats.STRING.formatValue(establishment[4]));

        txtCode.setEnabled(false);
        txtComercialName.setEnabled(false);
        txtAddress.setEnabled(false);
        txtCity.setEnabled(false);
        txtStatus.setEnabled(false);
    }

    /**
     *
     * @param value
     */
    @Override
    public void writeValueEdit(Object value) {

        Object[] establishment = (Object[]) value;
        m_oId = establishment[0];
        txtCode.setText(Formats.STRING.formatValue(establishment[0]));
        txtComercialName.setText(Formats.STRING.formatValue(establishment[1]));
        txtAddress.setText(Formats.STRING.formatValue(establishment[2]));
        txtCity.setText(Formats.STRING.formatValue(establishment[3]));
        txtStatus.setText(Formats.STRING.formatValue(establishment[4]));

        txtCode.setEnabled(false);
        txtComercialName.setEnabled(true);
        txtAddress.setEnabled(true);
        txtCity.setEnabled(true);
        txtStatus.setEnabled(true);
    }

    /**
     *
     * @return @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {

        Object[] establishment = new Object[5];

        establishment[0] = txtCode.getText();
        establishment[1] = txtComercialName.getText();
        establishment[2] = txtAddress.getText();
        establishment[3] = txtCity.getText();
        establishment[4] = txtStatus.getText();

        return establishment;
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCode = new javax.swing.JTextField();
        txtComercialName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        txtCode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCode.setPreferredSize(new java.awt.Dimension(0, 30));

        txtComercialName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtComercialName.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel1.setText("Establecimiento");

        jLabel4.setText("Nombre Comercial");

        txtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAddress.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel5.setText("Dirección");

        txtCity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCity.setPreferredSize(new java.awt.Dimension(0, 30));

        txtStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtStatus.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel6.setText("Ciudad");

        jLabel7.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComercialName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComercialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(475, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtComercialName;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

}
