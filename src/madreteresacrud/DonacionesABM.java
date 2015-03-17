/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.awt.Toolkit;
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
 * @author leandro
 */
public class DonacionesABM extends JPanel {
    
    public DonacionesABM() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * ORDER BY d.fechaDonacion DESC
     ORDER BY d.fechaDonacion DESC
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Donaciones d");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelTabla = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jPanelForm = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        montoLabel = new javax.swing.JLabel();
        fechaDonacionLabel = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        apellidoField = new javax.swing.JTextField();
        montoField = new javax.swing.JTextField();
        fechaDonacionField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButtonCalendar = new javax.swing.JButton();
        documentoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jCheckBoxSoc = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        setEnabled(false);

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apellido}"));
        columnBinding.setColumnName("Apellido");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaDonacion}"));
        columnBinding.setColumnName("Fecha Donacion");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dni}"));
        columnBinding.setColumnName("DNI / Cuil");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        deleteButton.setText("Eliminar Donacion");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        newButton.setText("Nueva Donacion");
        newButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(464, Short.MAX_VALUE))
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addGap(57, 57, 57)))
        );

        jPanelForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        montoLabel.setText("Monto ($):");

        fechaDonacionLabel.setText("Fecha Donacion:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombre}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.apellido}"), apellidoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), apellidoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoField.setToolTipText("Solo números y coma.");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.monto}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoField.addKeyListener(formListener);

        fechaDonacionField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaDonacion}"), fechaDonacionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaDonacionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaDonacionField.addMouseListener(formListener);

        saveButton.setText("Guardar");
        saveButton.setEnabled(false);
        saveButton.addActionListener(formListener);

        refreshButton.setText("Cancelar");
        refreshButton.setEnabled(false);
        refreshButton.addActionListener(formListener);

        jButtonCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButtonCalendar.setContentAreaFilled(false);
        jButtonCalendar.setEnabled(false);
        jButtonCalendar.addActionListener(formListener);

        documentoField.setToolTipText("Solo números con longitud máxima de 8 dígitos. ");
        documentoField.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.dni}"), documentoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        documentoField.addActionListener(formListener);
        documentoField.addKeyListener(formListener);

        jLabel1.setText("Dni/Cuil");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.addActionListener(formListener);

        jCheckBoxSoc.setText("Socio Actual");
        jCheckBoxSoc.setEnabled(false);
        jCheckBoxSoc.addActionListener(formListener);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellidoLabel)
                    .addComponent(montoLabel)
                    .addComponent(fechaDonacionLabel)
                    .addComponent(nombreLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshButton)
                        .addGap(12, 12, 12)
                        .addComponent(saveButton))
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFormLayout.createSequentialGroup()
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(montoField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaDonacionField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                                .addComponent(documentoField)
                                .addGap(164, 164, 164))
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jCheckBoxSoc)))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {refreshButton, saveButton});

        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(documentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxSoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(montoLabel)
                    .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaDonacionLabel)
                        .addComponent(fechaDonacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(saveButton)
                    .addComponent(jButtonBuscar))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == deleteButton) {
                DonacionesABM.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                DonacionesABM.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                DonacionesABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                DonacionesABM.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonCalendar) {
                DonacionesABM.this.jButtonCalendarActionPerformed(evt);
            }
            else if (evt.getSource() == documentoField) {
                DonacionesABM.this.documentoFieldActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonBuscar) {
                DonacionesABM.this.jButtonBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == jCheckBoxSoc) {
                DonacionesABM.this.jCheckBoxSocActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == montoField) {
                DonacionesABM.this.montoFieldKeyTyped(evt);
            }
            else if (evt.getSource() == documentoField) {
                DonacionesABM.this.documentoFieldKeyTyped(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                DonacionesABM.this.masterTableMouseClicked(evt);
            }
            else if (evt.getSource() == fechaDonacionField) {
                DonacionesABM.this.fechaDonacionFieldMouseClicked(evt);
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

    

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        this.refrescarForm();
    }//GEN-LAST:event_refreshButtonActionPerformed

   
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    int[] selected = masterTable.getSelectedRows();
                    List<madreteresacrud.Donaciones> toRemove = new ArrayList<madreteresacrud.Donaciones>(selected.length);

                    
                    for (int idx = 0; idx < selected.length; idx++) {
                        madreteresacrud.Donaciones d = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                        toRemove.add(d);
                        entityManager.remove(d);
                    }
                    try {
                            entityManager.getTransaction().commit();
                            entityManager.getTransaction().begin();
                            JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                list.removeAll(toRemove);
                this.refrescarForm();
            }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newButton.setEnabled(false);
        setEnabledBotones(true);
        jCheckBoxSoc.setSelected(false);
        jCheckBoxSoc.setEnabled(true);
        documentoField.setText("");
        documentoField.setEnabled(true);
        jButtonCalendar.setEnabled(true);
        documentoField.setEnabled(true);
        madreteresacrud.Donaciones d = new madreteresacrud.Donaciones();
        entityManager.persist(d);
        list.add(d);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void setEnabledBotones (boolean estado){
        jButtonBuscar.setEnabled(estado);
        refreshButton.setEnabled(estado);
        saveButton.setEnabled(estado);
        newButton.setEnabled(!estado);
        jCheckBoxSoc.setEnabled(estado);
        jButtonCalendar.setEnabled(estado);
    }
    
    private void activarTextos (boolean estado){
        documentoField.setEnabled(estado);                
        nombreField.setEnabled(estado);
        apellidoField.setEnabled(estado);
        montoField.setEnabled(estado);
        fechaDonacionField.setEnabled(estado);
    }
    
    
    private Boolean blancos (){
        if((documentoField.getText().trim().isEmpty())||
                (nombreField.getText().trim().isEmpty())||
                (apellidoField.getText().trim().isEmpty())||
                (montoField.getText().trim().isEmpty())||
                (fechaDonacionField.getText().trim().isEmpty())){
            return true;
        }else{
            return false;
        }
      }
    
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(this.blancos()){
            JOptionPane.showMessageDialog(null, "No se puede almacenar registros con valores en blanco");
        }else{
                try {
                    int doc = Integer.parseInt(documentoField.getText().trim());
                    if(doc!=0){
                        SociosABM s = new SociosABM();
                        Socios soc = s.ApeYNom(doc);
                        if(soc !=null){
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Es usted "+soc.getNombre()+" "+soc.getApellido()+"?", "Selección de Registro", JOptionPane.YES_NO_OPTION);
                            if(JOptionPane.YES_OPTION == dialogResult){
                                s.setDonanteByDNI(doc);
                                apellidoField.setText(soc.getApellido());
                                nombreField.setText(soc.getNombre());
                                apellidoField.setEnabled(true);
                                nombreField.setEnabled(true);
                                montoField.setEnabled(true);
                                fechaDonacionField.setEnabled(true);
                                dialogResult=0;
                            }
                        }                  
                    }
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();

                } catch (RollbackException rex) {
                    rex.printStackTrace();
                    entityManager.getTransaction().begin();
                    List<madreteresacrud.Donaciones> merged = new ArrayList<madreteresacrud.Donaciones>(list.size());
                    for (madreteresacrud.Donaciones d : list) {
                        merged.add(entityManager.merge(d));
                    }
                    list.clear();
                    list.addAll(merged);
                }
        }
       this.refrescarForm();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void refrescarForm(){
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        this.setEnabledBotones(false);
        this.activarTextos(false);
    }
    
    
    private void jButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarActionPerformed
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this),true,fechaDonacionField).setVisible(true);
    }//GEN-LAST:event_jButtonCalendarActionPerformed

    private void documentoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_documentoFieldKeyTyped
        if ((!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) || (documentoField.getText().trim().length() >= 8))//para permitir el punto && evt.getKeyChar()!='.')
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_documentoFieldKeyTyped

    private void documentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documentoFieldActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if(this.blancos()){
            JOptionPane.showMessageDialog(null, "No se puede buscar socios con valores en blanco");
            this.refrescarForm();
        }else{    
            saveButton.setEnabled(true);
            int doc = Integer.parseInt(documentoField.getText().trim());
            if(doc!=0){
                SociosABM s = new SociosABM();
                Socios soc = s.ApeYNom(doc);
                if(soc !=null){
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Es usted "+soc.getNombre()+" "+soc.getApellido()+"?", "Selección de Registro", JOptionPane.YES_NO_OPTION);
                        if(JOptionPane.YES_OPTION == dialogResult){
                            apellidoField.setText(soc.getApellido());
                            nombreField.setText(soc.getNombre());
                            apellidoField.setEnabled(true);
                            nombreField.setEnabled(true);
                            montoField.setEnabled(true);
                            fechaDonacionField.setEnabled(true);
                            dialogResult=0;       
                        }
                 }else{
                        JOptionPane.showMessageDialog(null, "No se encuentra Socio con ese DNI");
                 }                  
            }
        } 
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jCheckBoxSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSocActionPerformed
        if(jCheckBoxSoc.isSelected()){
            jButtonBuscar.setEnabled(true);
            fechaDonacionField.setEnabled(false);
            montoField.setEnabled(false);
            apellidoField.setEnabled(false);
            nombreField.setEnabled(false);
            saveButton.setEnabled(false);
        }else{
            jButtonBuscar.setEnabled(false);
            fechaDonacionField.setEnabled(true);
            montoField.setEnabled(true);
            apellidoField.setEnabled(true);
            nombreField.setEnabled(true);
            saveButton.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBoxSocActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        setEnabledBotones(true);
        documentoField.setEnabled(true);
        jCheckBoxSoc.setEnabled(true);
    }//GEN-LAST:event_masterTableMouseClicked

    private void montoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.')
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoFieldKeyTyped

    private void fechaDonacionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaDonacionFieldMouseClicked
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this),true,fechaDonacionField).setVisible(true);
    }//GEN-LAST:event_fechaDonacionFieldMouseClicked
    
    //OBJETO PARA PODER ENLAZAR LA FECHA DESDE LA BD EN EL TEXTFIELD fechaNacimiento
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
          
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoField;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField documentoField;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fechaDonacionField;
    private javax.swing.JLabel fechaDonacionLabel;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JCheckBox jCheckBoxSoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTabla;
    private java.util.List<madreteresacrud.Donaciones> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField montoField;
    private javax.swing.JLabel montoLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
    
}

