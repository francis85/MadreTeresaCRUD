/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

import java.awt.Toolkit;
import java.beans.Beans;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.beansbinding.Converter;
import utilidades.CalendarioDialog;

/**
 *
 * @author francis
 */
public class CuotasFVABM extends JPanel {

    private String label;
    private int idSoc;
    private int idfv;
    private boolean band = false;

    public CuotasFVABM(int idSoc) {
        label = "<html>Flores de vida<P>"
                + "<html>Correspondiente a:<P>";
        this.idSoc = idSoc;
        List<FlorVida> listaFV = getListaFV();
        if (listaFV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El socio no tiene asignado flores de vida, agreguelos con el boton 'Ver Flores de Vida'.");
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.hide();
        } else {

            FlorVida fv = new FlorVida();
            boolean band = false;
            javax.swing.JComboBox jCB = new javax.swing.JComboBox();
            for (FlorVida fv1 : listaFV) {
                fv = (FlorVida) fv1;
                if (band == false) {
                    this.idfv = fv.getIdFV();
                    initComponents();
                    jLidSoc.setText(Integer.toString(idSoc));
                    band = true;
                }
                jCBfv.addItem(fv.getApellido() + ", " + fv.getNombre());
            }

            if (!Beans.isDesignTime()) {
                entityManager.getTransaction().begin();
            }
            this.band = true;

            //deleteButton.setVisible(false);
            jLidSoc.setVisible(false);
            jLidFV.setVisible(false);
            //Ocultamos la columna correspondiente al idTipoSocio
            masterTable.getColumnModel().getColumn(2).setMaxWidth(0);
            masterTable.getColumnModel().getColumn(2).setMinWidth(0);
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(0);

            masterTable.getColumnModel().getColumn(3).setMaxWidth(0);
            masterTable.getColumnModel().getColumn(3).setMinWidth(0);
            masterTable.getColumnModel().getColumn(3).setPreferredWidth(0);

            masterTable.getColumnModel().getColumn(4).setMaxWidth(0);
            masterTable.getColumnModel().getColumn(4).setMinWidth(0);
            masterTable.getColumnModel().getColumn(4).setPreferredWidth(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. SELECT c FROM CuotaFlorDeVida c WHERE
     * c.idSocioFV="+this.idSoc+" AND c.idFV="+this.idfv
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV="+this.idSoc+" AND c.idFV="+this.idfv);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        montoLabel = new javax.swing.JLabel();
        fechaPagoLabel = new javax.swing.JLabel();
        montoField = new javax.swing.JTextField();
        fechaPagoField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCBfv = new javax.swing.JComboBox();
        jLidSoc = new javax.swing.JLabel();
        jLidFV = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPago}"));
        columnBinding.setColumnName("Fecha Pago");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idcuotaFlorDeVida}"));
        columnBinding.setColumnName("Idcuota Flor De Vida");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idSocioFV}"));
        columnBinding.setColumnName("Id Socio FV");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFV}"));
        columnBinding.setColumnName("Id FV");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        montoLabel.setText("Monto ($):");

        fechaPagoLabel.setText("Fecha de Pago:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.monto}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoField.addKeyListener(formListener);

        fechaPagoField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaPago}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaPagoField.addMouseListener(formListener);

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        newButton.setText("Generar Cuota");
        newButton.addActionListener(formListener);

        jLabel1.setText(label);

        jCBfv.addActionListener(formListener);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(formListener);

        jButton2.setText("Salir");
        jButton2.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCBfv, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(montoLabel)
                                .addGap(42, 42, 42)
                                .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLidSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaPagoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fechaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLidFV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(newButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBfv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLidSoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(montoLabel)
                        .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fechaPagoLabel)
                                .addComponent(fechaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLidFV, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(saveButton)
                    .addComponent(jButton2)
                    .addComponent(newButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                CuotasFVABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                CuotasFVABM.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jCBfv) {
                CuotasFVABM.this.jCBfvActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                CuotasFVABM.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                CuotasFVABM.this.jButton2ActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == montoField) {
                CuotasFVABM.this.montoFieldKeyTyped(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == fechaPagoField) {
                CuotasFVABM.this.fechaPagoFieldMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents


    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        madreteresacrud.floresVida.CuotaFlorDeVida c = new madreteresacrud.floresVida.CuotaFlorDeVida();
        c.setIdFV(Integer.parseInt(jLidFV.getText()));
        c.setIdSocioFV(Integer.parseInt(jLidSoc.getText()));
        entityManager.persist(c);
        list.add(c);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<madreteresacrud.floresVida.CuotaFlorDeVida> merged = new ArrayList<madreteresacrud.floresVida.CuotaFlorDeVida>(list.size());
            for (madreteresacrud.floresVida.CuotaFlorDeVida c : list) {
                merged.add(entityManager.merge(c));
            }
            list.clear();
            list.addAll(merged);
        }
        //Recargamos de nuevo la tabla 
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV=" + this.idSoc + " AND c.idFV=" + this.idfv);
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jCBfvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBfvActionPerformed
        FlorVidaABM fvabm = new FlorVidaABM();
        String[] fv = jCBfv.getSelectedItem().toString().split(",");
        this.idfv = fvabm.getIdFV(fv[0], fv[1], this.idSoc);
        jLidFV.setText(Integer.toString(this.idfv));

        //Recargamos de nuevo la tabla 
        if (band == true) {
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV=" + this.idSoc + " AND c.idFV=" + this.idfv);
            java.util.Collection data = query.getResultList();
            for (Object entity : data) {
                entityManager.refresh(entity);
            }
            list.clear();
            list.addAll(data);
        }
    }//GEN-LAST:event_jCBfvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CalendarioDialog((JDialog) SwingUtilities.getWindowAncestor(this), true, fechaPagoField).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JDialog topFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        topFrame.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fechaPagoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaPagoFieldMouseClicked
      new CalendarioDialog((JDialog) SwingUtilities.getWindowAncestor(this), true, fechaPagoField).setVisible(true);          
    }//GEN-LAST:event_fechaPagoFieldMouseClicked

    private void montoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoFieldKeyTyped
       if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.')
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoFieldKeyTyped

    public List<FlorVida> getListaFV() {
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FlorVida f,RelacSocDifuntos r "
                + "WHERE f.idFV=r.idFV AND r.idSocioFV=" + this.idSoc);
        return query.getResultList();

    }

    Converter dateConverter = new Converter<java.util.Date, String>() {
        @Override
        public String convertForward(java.util.Date value) {
            DateFormat df = DateFormat.getDateInstance();
            return df.format(value);
        }

        @Override
        public java.util.Date convertReverse(String value) {
            try {
                DateFormat df = DateFormat.getDateInstance();
                return df.parse(value);
            } catch (ParseException e) {
                return Calendar.getInstance().getTime();
            }
        }
    };
    //Este codigo deberia eliminar las cuotas pero no funciona
//    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
//        int[] selected = masterTable.getSelectedRows();
//        List<madreteresacrud.floresVida.CuotaFlorDeVida> toRemove = new ArrayList<madreteresacrud.floresVida.CuotaFlorDeVida>(selected.length);
//        for (int idx = 0; idx < selected.length; idx++) {
//            madreteresacrud.floresVida.CuotaFlorDeVida c = list.get(masterTable.convertRowIndexToModel(selected[idx]));
//            toRemove.add(c);
//            entityManager.remove(c);
//            System.out.println(c.getMonto());
//        }
//        list.removeAll(toRemove);
//    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fechaPagoField;
    private javax.swing.JLabel fechaPagoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCBfv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLidFV;
    private javax.swing.JLabel jLidSoc;
    private java.util.List<madreteresacrud.floresVida.CuotaFlorDeVida> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField montoField;
    private javax.swing.JLabel montoLabel;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//    public static void main(String[] args) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CuotasFVABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CuotasFVABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CuotasFVABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CuotasFVABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new CuotasFVABM());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
