/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

import java.awt.EventQueue;
import java.beans.Beans;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.beansbinding.Converter;
import utilidades.Calendario;

/**
 *
 * @author francis
 */
public class CuotasFVABM extends JPanel {
    private String label;
    private int idSoc;
    private int idfv;
    private boolean band=false;
    public CuotasFVABM(int idSoc) {
        label = "<html>Flores de vida<P>" +
                "<html>Correspondiente a:<P>";
        this.idSoc=idSoc;        
        java.util.Collection listaFV = getListaFV();
        if(listaFV.isEmpty()){
            JOptionPane.showMessageDialog(null, "El socio no tiene asignado flores de vida, agreguelos con el boton 'Flores de Vida'.");
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.hide(); 
        }else{
            
            FlorVida fv = new FlorVida();
            boolean band = false;
            javax.swing.JComboBox jCB = new javax.swing.JComboBox();
            for(Object fv1:listaFV){
                fv= (FlorVida)fv1;                 
                if(band == false){
                    this.idfv=fv.getIdFV();
                    initComponents();
                    jLidSoc.setText(Integer.toString(idSoc));                   
                    band=true;                    
                }
                jCBfv.addItem(fv.getApellido()+" "+fv.getNombre());            
            }           
             
            if (!Beans.isDesignTime()) {
                entityManager.getTransaction().begin();
            }
            this.band=true;

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
     * regenerated by the Form Editor.
     SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV="+this.idSoc+" AND c.idFV="+this.idfv
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c");
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

        FormListener formListener = new FormListener();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPago}"));
        columnBinding.setColumnName("Fecha Pago");
        columnBinding.setColumnClass(java.util.Date.class);
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
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaPago}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        newButton.setText("Generar Cuota");
        newButton.addActionListener(formListener);

        jLabel1.setText(label);

        jCBfv.addActionListener(formListener);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(montoLabel)
                                            .addComponent(fechaPagoLabel)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(fechaPagoField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(montoField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCBfv, 0, 164, Short.MAX_VALUE)))
                                    .addComponent(jLidSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLidFV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(newButton)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montoLabel)
                            .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaPagoLabel)
                            .addComponent(fechaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLidSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBfv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLidFV, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(newButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
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
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV="+this.idSoc+" AND c.idFV="+this.idfv);
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jCBfvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBfvActionPerformed
        FlorVidaABM fvabm = new FlorVidaABM();
        String [] fv = jCBfv.getSelectedItem().toString().split(" ");
        this.idfv = fvabm.getIdFV(fv[0], fv[1], this.idSoc);
        jLidFV.setText(Integer.toString(this.idfv));
        
        //Recargamos de nuevo la tabla 
        if(band==true){
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV="+this.idSoc+" AND c.idFV="+this.idfv);
            java.util.Collection data = query.getResultList();
            for (Object entity : data) {
                entityManager.refresh(entity);
            }
            list.clear();
            list.addAll(data);
        }
        System.out.println("Funciona");
    }//GEN-LAST:event_jCBfvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Calendario(fechaPagoField).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public java.util.Collection getListaFV(){
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
         query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FlorVida f,RelacSocDifuntos r "+
                                                                                        "WHERE f.idFV=r.idFV AND r.idSocioFV="+this.idSoc);
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