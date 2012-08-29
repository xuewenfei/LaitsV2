/*
 * LAITS Project
 * Arizona State University
 * 
 * @author: rptiwari
 */

package laits.gui;

import laits.comm.CommException;
import laits.data.Task;
import laits.data.TaskFactory;
import laits.graph.Graph;
import laits.graph.GraphCanvas;
import laits.graph.Vertex;
import laits.plot.PlotPanel;
import java.awt.*;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Megana
 */
public class GraphsPanelView extends javax.swing.JPanel {

  JPanel grafica;
  Vertex currentVertex;
  Graph modelGraph;
  GraphCanvas modelCanvas;
  Image correctAnswer = null;
  Task t;

  //the width and height of the panel
  int width, height;
  
  private static GraphsPanelView graphView;
  
  /** Logger **/
  private static Logger logs = Logger.getLogger(GraphsPanelView.class);
  

  public static GraphsPanelView getInstance(){
    if(graphView == null){
      logs.info("Instantiating Description Panel.");
      graphView = new GraphsPanelView();
    }
    
    return graphView;
  }
  
  private GraphsPanelView(){
    initComponents();
    modelCanvas = GraphCanvas.getInstance();
    modelGraph = GraphCanvas.getInstance().getGraph();
  }
  
  
  public void initPanel(Vertex inputVertex){
    currentVertex = inputVertex;
    
    if (grafica != null)
      userAnswerPanel.remove(grafica);

    if ((modelCanvas.getModelHasBeenRun() == true) && (currentVertex.getType() != Vertex.NOTYPE)
            && ((!currentVertex.isNodeEquationEmpty()) || (currentVertex.getType() == Vertex.CONSTANT)))

      userAnswerPanel = new PlotPanel(this.currentVertex);

    this.updateDescription();
    this.testResetLayout();
  }
  
  public void testResetLayout() {
    allGraphsPanel.removeAll();
    allGraphsPanel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

      c.fill = GridBagConstraints.HORIZONTAL;
      c.weighty = 1;
      c.gridx = 0;
      c.gridy = 0;
      c.weightx = 0.0;
      allGraphsPanel.add(userGraphLabel, c);
      //Add the correct graph
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 1;
      c.weightx = 0.0;
      allGraphsPanel.add(userAnswerPanel, c);
//    }
    //Add the predicted values label
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 1;
    c.gridx = 0;
    c.gridy = 2;
    c.weightx = 0.0;
    //allGraphsPanel.add(predictedValuesLabel, c);
    //Add the predicted values item box
    c.fill = GridBagConstraints.HORIZONTAL;
    //c.weighty = 1;
    c.gridx = 0;
    c.gridy = 3;
    c.weightx = 0.0;
    //allGraphsPanel.add(itemBox, c);
    //Add the user graph label
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 1;
    c.gridx = 0;
    c.gridy = 4;
    c.weightx = 0.0;

    //Add the user graph
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 5;
    c.weightx = 0.0;

  }

  /**
   * This method is used when the user selects a name and description for the node
   * currently being edited
   */
  public void updateDescription() {
    descriptionLabel.setText("<html><b>Description:</b> " + currentVertex.getSelectedDescription() + "</html>");
  }

  public void resetLayout() {
    this.removeAll();
    userAnswerPanel.setPreferredSize(new java.awt.Dimension(300, 200));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);


  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    nodeDescriptionLabel = new javax.swing.JLabel();
    allGraphsPanel = new javax.swing.JPanel();
    userGraphLabel = new javax.swing.JLabel();
    filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 32767));
    userAnswerPanel = new javax.swing.JPanel();
    correctGraphLabel1 = new javax.swing.JLabel();
    correctGraphLabel2 = new javax.swing.JLabel();
    descriptionLabel = new javax.swing.JLabel();

    nodeDescriptionLabel.setText("<html></html>");

    userGraphLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    userGraphLabel.setText("Author's Graph:");

    userAnswerPanel.setMaximumSize(new java.awt.Dimension(286, 99));
    userAnswerPanel.setPreferredSize(new java.awt.Dimension(286, 99));

    javax.swing.GroupLayout userAnswerPanelLayout = new javax.swing.GroupLayout(userAnswerPanel);
    userAnswerPanel.setLayout(userAnswerPanelLayout);
    userAnswerPanelLayout.setHorizontalGroup(
      userAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 409, Short.MAX_VALUE)
    );
    userAnswerPanelLayout.setVerticalGroup(
      userAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 109, Short.MAX_VALUE)
    );

    correctGraphLabel1.setText("     ");

    correctGraphLabel2.setText("                   ");

    javax.swing.GroupLayout allGraphsPanelLayout = new javax.swing.GroupLayout(allGraphsPanel);
    allGraphsPanel.setLayout(allGraphsPanelLayout);
    allGraphsPanelLayout.setHorizontalGroup(
      allGraphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(allGraphsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(allGraphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(userAnswerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(userGraphLabel)
          .addComponent(correctGraphLabel1)
          .addComponent(correctGraphLabel2))
        .addContainerGap(69, Short.MAX_VALUE))
      .addGroup(allGraphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(allGraphsPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(31, Short.MAX_VALUE)))
    );
    allGraphsPanelLayout.setVerticalGroup(
      allGraphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(allGraphsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(userGraphLabel)
        .addGap(18, 18, 18)
        .addComponent(userAnswerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
        .addComponent(correctGraphLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(correctGraphLabel1)
        .addGap(210, 210, 210))
      .addGroup(allGraphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(allGraphsPanelLayout.createSequentialGroup()
          .addGap(303, 303, 303)
          .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(262, Short.MAX_VALUE)))
    );

    descriptionLabel.setText("<html><b>Description:</b></html>");
    descriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(allGraphsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(287, 287, 287)
        .addComponent(nodeDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(allGraphsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(nodeDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(286, 286, 286)))
        .addGap(90, 90, 90))
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel allGraphsPanel;
  private javax.swing.JLabel correctGraphLabel1;
  private javax.swing.JLabel correctGraphLabel2;
  private javax.swing.JLabel descriptionLabel;
  private javax.swing.Box.Filler filler1;
  private javax.swing.JLabel nodeDescriptionLabel;
  private javax.swing.JPanel userAnswerPanel;
  private javax.swing.JLabel userGraphLabel;
  // End of variables declaration//GEN-END:variables

   
}