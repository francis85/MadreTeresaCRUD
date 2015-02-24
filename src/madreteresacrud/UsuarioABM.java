/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.awt.Window;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author leandro
 */
public class UsuarioABM extends JPanel {

    public UsuarioABM() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Usuario u");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        nombreLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(Object.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(Object.class);
        bindingGroup.addBinding(jTableBinding);

        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        nombreLabel.setText("Nombre:");

        passwordLabel.setText("Password:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombre}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.password}"), passwordField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), passwordField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        newButton.setText("Nuevo");
        newButton.addActionListener(formListener);

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreLabel)
                                    .addComponent(passwordLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                UsuarioABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                UsuarioABM.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                UsuarioABM.this.deleteButtonActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                UsuarioABM.this.masterTableMouseClicked(evt);
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


    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            javax.persistence.Query query = entityManager.createQuery("SELECT u FROM Usuario u");
            if (query.getResultList().size() == 1) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el único usuario del sistema!");
            } else {
                int[] selected = masterTable.getSelectedRows();
                if (selected.length > 1) {
                    JOptionPane.showMessageDialog(null, "No se pueden eliminar usuarios multiples");
                } else {
                    //Verifica que no sea el usuario que está seleccionado
                    if (!esMismoUsuario(nombreField.getText().trim())) {
                        List<madreteresacrud.Usuario> toRemove = new ArrayList<madreteresacrud.Usuario>(selected.length);
                        for (int idx = 0; idx < selected.length; idx++) {
                            madreteresacrud.Usuario u = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                            toRemove.add(u);
                            entityManager.remove(u);

                        }
                        list.removeAll(toRemove);
                        try {
                            entityManager.getTransaction().commit();
                            entityManager.getTransaction().begin();
                        } catch (RollbackException rex) {
                            rex.printStackTrace();
                            entityManager.getTransaction().begin();
                            List<madreteresacrud.Usuario> merged = new ArrayList<madreteresacrud.Usuario>(list.size());
                            for (madreteresacrud.Usuario u : list) {
                                merged.add(entityManager.merge(u));
                            }
                            list.clear();
                            list.addAll(merged);
                        }
                    } else {
                        //Si es el mismo usuario pregunto si desea borrarse
                        int replyUsu = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar su propio usuario?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
                        if (replyUsu == JOptionPane.YES_OPTION) {
                            List<madreteresacrud.Usuario> toRemove = new ArrayList<madreteresacrud.Usuario>(selected.length);
                            for (int idx = 0; idx < selected.length; idx++) {
                                madreteresacrud.Usuario u = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                                toRemove.add(u);
                                entityManager.remove(u);

                            }
                            list.removeAll(toRemove);
                            try {
                                entityManager.getTransaction().commit();
                                entityManager.getTransaction().begin();
                            } catch (RollbackException rex) {
                                rex.printStackTrace();
                                entityManager.getTransaction().begin();
                                List<madreteresacrud.Usuario> merged = new ArrayList<madreteresacrud.Usuario>(list.size());
                                for (madreteresacrud.Usuario u : list) {
                                    merged.add(entityManager.merge(u));
                                }
                                list.clear();
                                list.addAll(merged);
                            }
                            //Abrimos Ingreso al sistema
                            IngresoSistema i = new IngresoSistema();
                            i.setResizable(false);
                            i.setLocationRelativeTo(null);
                            i.setVisible(true);
                            //ocultamos el MadreTeresaMain
                            Window topFrame = SwingUtilities.getWindowAncestor(this);
                            topFrame.dispose();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed


    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        madreteresacrud.Usuario u = new madreteresacrud.Usuario();
        entityManager.persist(u);
        list.add(u);
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
            List<madreteresacrud.Usuario> merged = new ArrayList<madreteresacrud.Usuario>(list.size());
            for (madreteresacrud.Usuario u : list) {
                merged.add(entityManager.merge(u));
            }
            list.clear();
            list.addAll(merged);
        }
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked

    }//GEN-LAST:event_masterTableMouseClicked
    public boolean Log(String usu, String pas) {
        String item;
        javax.persistence.Query query = entityManager.createQuery("SELECT DISTINCT u.nombre FROM Usuario u WHERE u.nombre='" + usu + "' AND u.password='" + pas + "'");
        if (!query.getResultList().isEmpty()) {
            try {
                String sql = "UPDATE LogUsuario l SET l.activo= " + 0 + " WHERE l.activo= " + 1;
                System.out.println(sql);
                entityManager.createQuery(sql).executeUpdate();
                LogUsuario log = new LogUsuario();
                java.util.Date fecha = new Date();
                log.setFecha(fecha);
                log.setActivo(1);
                log.setNombreUsuario(usu);
                entityManager.persist(log);
                entityManager.getTransaction().commit();

            } catch (RollbackException rex) {
                System.out.println(rex);
            }

            return true;
        }
        return false;

    }

    private boolean esMismoUsuario(String usuario) {
        javax.persistence.Query query = entityManager.createQuery("SELECT DISTINCT l.nombreUsuario FROM LogUsuario l  WHERE l.activo= " + 1);
        String usuarioActual = query.getResultList().get(0).toString();
        if (usuarioActual.equals(usuario)) {
            return true;
        } else {
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<madreteresacrud.Usuario> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
