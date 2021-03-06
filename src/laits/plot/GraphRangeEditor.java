/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GraphRangeEditor.java
 *
 * Created on Oct 23, 2011, 5:52:48 PM
 */
package laits.plot;

import java.awt.Color;
import laits.data.TaskFactory;
import laits.model.GraphCanvas;

/**
 *
 * @author Ram
 */
public class GraphRangeEditor extends javax.swing.JDialog {

    /** Creates new form GraphRangeEditor */
    public GraphRangeEditor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labelErrorFinal.setVisible(false);
        labelErrorInitial.setVisible(false);
        try{
          System.out.println("Initializing Range Editor "+ "Unit time : "+TaskFactory.getInstance().getActualTask().getUnitTime());
            textIntialValue.setText(String.valueOf(TaskFactory.getInstance().getActualTask().getStartTime()));
            textFinalValue.setText(String.valueOf(TaskFactory.getInstance().getActualTask().getEndTime()));
            comboUnits.setSelectedItem(TaskFactory.getInstance().getActualTask().getUnitTime());

        }catch(Exception e){
            e.printStackTrace();
        }
        this.setBounds((this.getToolkit().getScreenSize().width)/2 - 150, (this.getToolkit().getScreenSize().height)/2 - 125, 300,250);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    labelIntialValue = new javax.swing.JLabel();
    labelFinalValue = new javax.swing.JLabel();
    labelUnits = new javax.swing.JLabel();
    buttonSave = new javax.swing.JButton();
    buttonCancel = new javax.swing.JButton();
    textIntialValue = new javax.swing.JTextField();
    textFinalValue = new javax.swing.JTextField();
    comboUnits = new javax.swing.JComboBox();
    graphPanelHeading = new javax.swing.JLabel();
    labelErrorInitial = new javax.swing.JLabel();
    labelErrorFinal = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Graph Range Editor");
    setBounds(new java.awt.Rectangle(300, 200, 100, 150));
    setModal(true);
    setName("GraphModelEditor"); // NOI18N
    setResizable(false);

    labelIntialValue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    labelIntialValue.setText("Initial Value");
    labelIntialValue.setFocusable(false);

    labelFinalValue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    labelFinalValue.setText("Final Value");
    labelFinalValue.setFocusable(false);

    labelUnits.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    labelUnits.setText("Units");
    labelUnits.setFocusable(false);

    buttonSave.setText("Save");
    buttonSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonSaveActionPerformed(evt);
      }
    });

    buttonCancel.setText("Cancel");
    buttonCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCancelActionPerformed(evt);
      }
    });

    textIntialValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    textIntialValue.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        textIntialValueFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        textIntialValueFocusLost(evt);
      }
    });

    textFinalValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    textFinalValue.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        textFinalValueFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        textFinalValueFocusLost(evt);
      }
    });

    comboUnits.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Years", "Months", "Days", "Hours", "Mins" }));
    comboUnits.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        comboUnitsActionPerformed(evt);
      }
    });

    graphPanelHeading.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    graphPanelHeading.setText("Edit Graph Settings");

    labelErrorInitial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    labelErrorInitial.setForeground(new java.awt.Color(255, 0, 0));
    labelErrorInitial.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    labelErrorInitial.setText("Intial Value can not be empty !");
    labelErrorInitial.setFocusable(false);

    labelErrorFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    labelErrorFinal.setForeground(new java.awt.Color(255, 0, 0));
    labelErrorFinal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    labelErrorFinal.setText("Final Value can not be empty !");
    labelErrorFinal.setFocusable(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGap(73, 73, 73)
            .addComponent(graphPanelHeading))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelFinalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelIntialValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(textIntialValue)
              .addComponent(textFinalValue)
              .addComponent(buttonCancel)
              .addComponent(comboUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(57, 57, 57))
      .addGroup(layout.createSequentialGroup()
        .addGap(69, 69, 69)
        .addComponent(labelErrorInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addComponent(labelErrorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(63, 63, 63)
        .addComponent(buttonSave)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(graphPanelHeading)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelIntialValue)
          .addComponent(textIntialValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelErrorInitial)
        .addGap(4, 4, 4)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelFinalValue)
          .addComponent(textFinalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(2, 2, 2)
        .addComponent(labelErrorFinal)
        .addGap(2, 2, 2)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelUnits)
          .addComponent(comboUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonSave)
          .addComponent(buttonCancel))
        .addContainerGap(49, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // Validating user input
        boolean isInputValid = true;
        labelErrorInitial.setVisible(false);
        labelErrorFinal.setVisible(false);
        if(textIntialValue.getText().isEmpty()){
            labelErrorInitial.setVisible(true);
            textIntialValue.requestFocus();
            isInputValid = false;
        }
        if(textFinalValue.getText().isEmpty()){
            labelErrorFinal.setVisible(true);
            textFinalValue.requestFocus();
            isInputValid = false;
        }
        if(isInputValid){
            // Saving User's input in the Server Task object
            int startTime = Integer.parseInt(textIntialValue.getText());
            int endTime = Integer.parseInt(textFinalValue.getText());

            //Checking if end time is less than start time
            if(endTime<startTime){
                labelErrorFinal.setText("End Time can not be less than Start Time");
                labelErrorFinal.setVisible(true);
                textFinalValue.requestFocus();
                return;
            }

            String units = String.valueOf(comboUnits.getSelectedItem());
            try{
                TaskFactory.getInstance().getActualTask().setStartTime(startTime);
                TaskFactory.getInstance().getActualTask().setEndTime(endTime);
                TaskFactory.getInstance().getActualTask().setUnitTime(units);
            }catch(Exception e){
                e.printStackTrace();
            }
            this.dispose();
            
            GraphCanvas.getInstance().resetAllNodeGraphs();
            GraphCanvas.getInstance().repaint();
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // Closing the window on Cancel
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void textIntialValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textIntialValueFocusGained
        textIntialValue.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_textIntialValueFocusGained

    private void textFinalValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFinalValueFocusGained
        textFinalValue.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_textFinalValueFocusGained

    private void textIntialValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textIntialValueFocusLost
        textIntialValue.setBackground(Color.white);
    }//GEN-LAST:event_textIntialValueFocusLost

    private void textFinalValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFinalValueFocusLost
        textFinalValue.setBackground(Color.white);
    }//GEN-LAST:event_textFinalValueFocusLost

    private void comboUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUnitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUnitsActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonCancel;
  private javax.swing.JButton buttonSave;
  private javax.swing.JComboBox comboUnits;
  private javax.swing.JLabel graphPanelHeading;
  private javax.swing.JLabel labelErrorFinal;
  private javax.swing.JLabel labelErrorInitial;
  private javax.swing.JLabel labelFinalValue;
  private javax.swing.JLabel labelIntialValue;
  private javax.swing.JLabel labelUnits;
  private javax.swing.JTextField textFinalValue;
  private javax.swing.JTextField textIntialValue;
  // End of variables declaration//GEN-END:variables
}
