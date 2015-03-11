/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import reportes.ConexionBD;

/**
 *
 * @author francis
 */
public class FlorVidaSocio extends JPanel {
    private int idSoc;
    private  SocDif sd;
    public FlorVidaSocio(int idSoc) {
        this.idSoc=idSoc;
        initComponents();
//        deleteButton.setVisible(false);
        masterTable.getColumnModel().getColumn(5).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(5).setMinWidth(0);
        masterTable.getColumnModel().getColumn(5).setPreferredWidth(0);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     SELECT f FROM FlorVida f,RelacSocDifuntos r WHERE f.idFV=r.idFV AND r.idSocioFV="+this.idSoc+" ORDER BY f.apellido"
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FlorVida f,RelacSocDifuntos r WHERE f.idFV=r.idFV AND r.idSocioFV="+this.idSoc+" ORDER BY f.apellido");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        agregarFV = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        masterTable.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apellido}"));
        columnBinding.setColumnName("Apellido");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${localidad}"));
        columnBinding.setColumnName("Localidad");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccion}"));
        columnBinding.setColumnName("Direccion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaDefuncion}"));
        columnBinding.setColumnName("Fecha de Defuncion");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFV}"));
        columnBinding.setColumnName("Id FV");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        agregarFV.setText("Asignar flor de vida");
        agregarFV.addActionListener(formListener);

        jButton1.setText("Salir");
        jButton1.addActionListener(formListener);

        deleteButton.setText("Eliminar flor de vida");
        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(agregarFV, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregarFV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == agregarFV) {
                FlorVidaSocio.this.agregarFVActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                FlorVidaSocio.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                FlorVidaSocio.this.deleteButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void agregarFVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFVActionPerformed
        JDialog florv = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this),true);      
        florv.setTitle("Flores de vida");
        florv.setContentPane(new FlorVidaABM1(this.idSoc,this));
        florv.pack();
        florv.setLocationRelativeTo(null);
        florv.setVisible(true);
//        JFrame frame = new JFrame("Flores de vida");
//        frame.setContentPane(new FlorVidaABM1(this.idSoc,this));
//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);

    }//GEN-LAST:event_agregarFVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialog topFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        topFrame.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {        
            int selected = masterTable.getSelectedRow();                
            eliminarRelac(this.idSoc,Integer.parseInt(masterTable.getValueAt(selected, 5).toString()));

            //Recargamos la tabla
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();

            java.util.Collection data1 = query.getResultList();
            for (Object entity : data1) {
                entityManager.refresh(entity);
            }
            list.clear();
            list.addAll(data1);  
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
   
    public void setTabla(){
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }
    private void eliminarRelac(int idFVSoc, int idFV){
        ConexionBD cc= new ConexionBD();
       Connection cn = cc.conexion();
       String sql = "DELETE  FROM relacSocDifuntos WHERE idSocioFV="+idFVSoc+" AND idFV="+idFV;
       System.out.println(sql);
        try {
             Statement st = cn.createStatement();
             st.executeUpdate(sql);
              cn.close();
             
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro.");
        }
      
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFV;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private java.util.List<madreteresacrud.floresVida.FlorVida> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.persistence.Query query;
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
//            java.util.logging.Logger.getLogger(FlorVidaABM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new FlorVidaABM1());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
