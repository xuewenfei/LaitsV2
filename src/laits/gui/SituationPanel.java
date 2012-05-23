package laits.gui;

import laits.cover.Cover;
import laits.graph.Selectable;
import laits.log.Logger;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import laits.comm.ImageFilter;

/**
 * This class is responsible for creating an Interface for adding Problem Description and Problem Image
 * @author Ramayan Tiwari
 */
public class SituationPanel extends javax.swing.JPanel implements java.beans.Customizer, ActionListener 
{

  private Dimension imageSize = new Dimension(0, 0);  
  private static Logger logger = Logger.getLogger();
  private Image image = null;
  private Dimension sizeOfImage = new Dimension(0, 0);  
  private Cover cover = null;
  public Desktop desktop = null;
  JFileChooser fc;
  
  
  
  /**
   * Constructor
   * Initializes the File Choose and hides preview label
   */
  public SituationPanel() {
    super();  
    initComponents();  
    //this.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 2) + 200 , 140));    
    
    fc = new JFileChooser();    
    fc.setAcceptAllFileFilterUsed(false);
    fc.setFileFilter(new ImageFilter());
    
    previewPanel.setVisible(false);
    //labelPreview.setVisible(false);
    buttonEditMode.setEnabled(false);
  }

 /**
   * Constructor
   * Initializes the Situation Panel give the problem Description and Image URL
   */
  public SituationPanel(String problemDescription, String imageURL) {
    super();  
    initComponents();  
    
    fc = new JFileChooser();    
    fc.setAcceptAllFileFilterUsed(false);
    fc.setFileFilter(new ImageFilter());
    
    previewPanel.setVisible(false);    
    buttonEditMode.setEnabled(false);
  }
  /**
   * Paint this panel
   *
   * @param g
   */
  @Override
  protected void paintComponent(Graphics g) 
  {    
    super.paintComponent(g);
    imageSize = this.getParent().getSize();
    g.setColor(Selectable.COLOR_WHITE);  // white background
    g.fillRect(0, 0, imageSize.width, imageSize.height);
    g.setColor(Selectable.COLOR_GREY);   // gray grid
    for (int j = 0; j < imageSize.width; j += 10)
      g.drawLine(j, 0, j, imageSize.height);
    for (int i = 0; i < imageSize.height; i += 10)
      g.drawLine(0, i, imageSize.width, i);
    if (image == null) 
    {
      sizeOfImage = getSize();
      image = createImage(sizeOfImage.width, sizeOfImage.height);
    }
    cover.paint(g);
    repaint();
    
  }

  
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the FormEditor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonEditMode = new javax.swing.JButton();
        buttonPreviewMode = new javax.swing.JButton();
        descPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        buttonFileOpen = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        descriptionScroll = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        labelFileUrl = new javax.swing.JLabel();
        previewPanel = new javax.swing.JPanel();
        labelPreview = new javax.swing.JLabel();

        setToolTipText("");

        buttonEditMode.setText(" Edit  ");
        buttonEditMode.setToolTipText("Go to Edit Mode");
        buttonEditMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditModeActionPerformed(evt);
            }
        });

        buttonPreviewMode.setText("Preview");
        buttonPreviewMode.setToolTipText("Go to Preview Mode");
        buttonPreviewMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewModeActionPerformed(evt);
            }
        });

        imageLabel.setText("Problem Image");

        buttonFileOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/amt/images/Open16.gif"))); // NOI18N
        buttonFileOpen.setText("Open a File");
        buttonFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFileOpenActionPerformed(evt);
            }
        });

        descriptionLabel.setText("Problem Description");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        descriptionTextArea.setRows(5);
        descriptionScroll.setViewportView(descriptionTextArea);

        labelFileUrl.setText("No File Selected.");

        org.jdesktop.layout.GroupLayout descPanelLayout = new org.jdesktop.layout.GroupLayout(descPanel);
        descPanel.setLayout(descPanelLayout);
        descPanelLayout.setHorizontalGroup(
            descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(descPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(descriptionLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(imageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 84, Short.MAX_VALUE)
                .add(descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(descPanelLayout.createSequentialGroup()
                        .add(buttonFileOpen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26)
                        .add(labelFileUrl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(descPanelLayout.createSequentialGroup()
                        .add(descriptionScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 623, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        descPanelLayout.setVerticalGroup(
            descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(descPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(descPanelLayout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(descriptionLabel))
                    .add(descriptionScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(33, 33, 33)
                .add(descPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(imageLabel)
                    .add(labelFileUrl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonFileOpen))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        previewPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));

        labelPreview.setText("Preview");

        org.jdesktop.layout.GroupLayout previewPanelLayout = new org.jdesktop.layout.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(previewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelPreview, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 820, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(previewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelPreview)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(87, 87, 87)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(previewPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(descPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(256, 256, 256)
                        .add(buttonEditMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(buttonPreviewMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(81, 81, 81)
                .add(previewPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(descPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(46, 46, 46)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonEditMode)
                    .add(buttonPreviewMode))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

  private void buttonEditModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditModeActionPerformed
    // Handling Edit Mode      
    buttonPreviewMode.setEnabled(true);
    buttonEditMode.setEnabled(false);
    
    //labelPreview.setVisible(false);
    previewPanel.setVisible(false);
    descPanel.setVisible(true);
    repaint();
  }//GEN-LAST:event_buttonEditModeActionPerformed

  private void buttonPreviewModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewModeActionPerformed
    // Validating Input Text box
    if (descriptionTextArea.getText().isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please Enter the Problem Description.", "LAITS Error...", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (labelFileUrl.getText().compareTo("No File Selected.") == 0) {
      JOptionPane.showMessageDialog(this, "Please select the Problem Image. Default Image will be used if no image is selected.", "LAITS Warning...", JOptionPane.WARNING_MESSAGE);
    }

    
    String problemDetails = constructPreviewText(descriptionTextArea.getText());

    labelPreview.setText(problemDetails);
    buttonPreviewMode.setEnabled(false);
    buttonEditMode.setEnabled(true);

    //labelPreview.setVisible(true);
    previewPanel.setVisible(true);
    
    descPanel.setVisible(false);
    repaint();
  }//GEN-LAST:event_buttonPreviewModeActionPerformed

  private void buttonFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFileOpenActionPerformed
    // TODO add your handling code here:
    if (evt.getSource() == buttonFileOpen) {                
              int returnVal = fc.showOpenDialog(SituationPanel.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                
                File file = fc.getSelectedFile();
                labelFileUrl.setText(file.getPath());                
            }else{
                labelFileUrl.setText("No File Selected.");
            }
         }else if(evt.getSource() == buttonEditMode){
             
         }else if(evt.getSource() == buttonPreviewMode){
             
         }
  }//GEN-LAST:event_buttonFileOpenActionPerformed
 // Helper Methods 
    private String constructPreviewText(String rawText){
        File file = new File("src/amt/images/asu.jpg");               
        String imageUrl = "file:"+File.separator+File.separator+file.getAbsolutePath();
        
        if(rawText==null || rawText.isEmpty()){
            rawText = "No problem description provided";
        }
        
        if (labelFileUrl.getText().compareTo("No File Selected.")!=0) {
          // Set default URL to ASU Image URL
          imageUrl = "file:"+File.separator+File.separator+labelFileUrl.getText();
        }
        
        // Replacing '\n' with <br/>
        rawText = rawText.replace("\n", "<br/>");
        
        String htmlText="<html>"+
                                "<table width='800'><tr><td width=25%>"+"<img src='"+imageUrl+"' height='240' width='240' alt='Problem Image Not Selected.'/>"+"</td>"
                                +"<td style='margin-left:30px;' valign='top' width='75%'>"+rawText+"</td>"
                                +"</tr></table>";;
        return htmlText;
    }
  
   /**
   * This method sets the Cover
   *
   * @param cover
   */
  public void setCover(Cover cover) {
    this.cover = cover;
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditMode;
    private javax.swing.JButton buttonFileOpen;
    private javax.swing.JButton buttonPreviewMode;
    private javax.swing.JPanel descPanel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScroll;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel labelFileUrl;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JPanel previewPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Auto generated
     * @param o
     */
    public void setObject(Object o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * Auto generated
   * @param ae
   */
  public void actionPerformed(ActionEvent ae) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public String getProblemDescription(){
    if(descriptionTextArea.getText()!=null)
      return  descriptionTextArea.getText();
    else
      return "";
  }
  
  public String getImageURL(){
    if(labelFileUrl.getText().compareTo("No File Selected.")!=0){
      return labelFileUrl.getText();
    }else{
      return "";
    } 
  }   
}

