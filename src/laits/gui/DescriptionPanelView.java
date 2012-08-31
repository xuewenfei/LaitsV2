/**
 * LAITS Project
 * Arizona State University
 * 
 * Updated by rptiwari on Aug 24, 2012
 */

package laits.gui;

import laits.model.DecisionTreeRenderer;
import laits.model.DescriptionTree;
import laits.data.DecisionTreeNode;
import laits.model.GraphCanvas;
import laits.model.Vertex;
import laits.model.Graph;
import laits.model.Selectable;
import laits.gui.dialog.MessageDialog;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import laits.common.ErrorMessages;
import org.apache.log4j.Logger;


/**
 *
 * @author ramayantiwari
 */
public class DescriptionPanelView extends JPanel implements TreeSelectionListener {

  Vertex currentVertex;
  GraphCanvas modelCanvas;
  Graph modelGraph;
  private String undoName = "";
  private LinkedList<TreePath> treePaths = new LinkedList<TreePath>();
  TreePath[] decisionTreePaths;
  private boolean undoFlag = false;
  //private NodeEditor parent = null;
  private InputsPanelView parentNode = null;

  private boolean initializing = false;
  private boolean treeSelected = true;
  DefaultMutableTreeNode root = null;
  DefaultTreeModel model = null;
  DescriptionTree dTree, savedDecisionTree;
  String prevNodeName;
  
  private boolean triedDuplicate = false;
  private static DescriptionPanelView descView;
  private static Logger logs = Logger.getLogger(DescriptionPanelView.class);
  
  
  /**
   * Implementing Singleton pattern for Description Panel
   * @param v: Vertex for which this panel is to be created
   * @param gc: GraphCanvas of the LAITS application
   * @return 
   */
  public static DescriptionPanelView getInstance(){
    if(descView == null){
      logs.info("Instantiating Description Panel.");
      descView = new DescriptionPanelView();
    }
    
    return descView;
  }
  
  private DescriptionPanelView(){
    initComponents();
    modelCanvas = GraphCanvas.getInstance();
    modelGraph = GraphCanvas.getInstance().getGraph();   
  }
  
  public void initPanel(Vertex inputVertex, boolean newNode){
    currentVertex = inputVertex;
    
    if(newNode)
      initPanelForNewNode();
    else
      initPanelForSavedNode();
  }
  /**
   * Initialize Description Panel for a particular Vertex
   * @param inputVertex 
   */
  public void initPanelForSavedNode(){
    logs.trace("Initializing Description Panel for Node "+
            currentVertex.getNodeName());
    
    
    nodeNameTextField.setText(currentVertex.getNodeName());
    
    initTree();
    
    try {
      decisionTreePaths = getPaths(decisionTree, true);
    } catch (Exception ex) {
      logs.error("Error in Creating Description Tree "+ex.getMessage());
    }

    initTreeSelectionListener();
    quantityDescriptionTextField.setText(currentVertex.getSelectedDescription());
  }
  
  public void initPanelForNewNode(){
    logs.trace("Initializing Description Panel for New Node");
    resetDescriptionPanel();
    initTree();
    
    try {
      decisionTreePaths = getPaths(decisionTree, true);
    } catch (Exception ex) {
      logs.error("Error in Creating Description Tree "+ex.getMessage());
    }

    initTreeSelectionListener();
  }
  
  private void resetDescriptionPanel(){
    nodeNameTextField.setText("");
    quantityDescriptionTextField.setText("");   
  }
  
  public void setquantityDescriptionTextField(String desc) {
    this.quantityDescriptionTextField.setText(desc);
    quantityDescriptionTextField.setBackground(Selectable.COLOR_CORRECT);
    nodeNameTextField.setBackground(Selectable.COLOR_CORRECT);
    decisionTree.setEnabled(false);
    currentVertex.setDescriptionDefined(true);
    
    if(currentVertex.getNodeName() == "")
      NodeEditor.getInstance().setTitle("New Node");
    else
      NodeEditor.getInstance().setTitle(currentVertex.getNodeName().replaceAll("_", " "));
    
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    contentPanel = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    decisionTree = new javax.swing.JTree();
    evenMorePreciseLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    quantityDescriptionTextField = new javax.swing.JTextArea();
    referencesLabel = new javax.swing.JLabel();
    nodeNameTextField = new javax.swing.JTextField();
    NodeNameLabel = new javax.swing.JLabel();
    jRadioCorrect = new javax.swing.JRadioButton();
    jRadioInCorrect = new javax.swing.JRadioButton();
    buttonAddDesc = new javax.swing.JButton();

    decisionTree.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
    javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("A count of");
    javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("rabbits in the population");
    javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("at the beginning of the year");
    javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("and it is constant from year to year");
    treeNode4.add(treeNode5);
    treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("and it varies from year to year");
    treeNode4.add(treeNode5);
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("totaled up across all years");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("averaged across all years");
    treeNode3.add(treeNode4);
    treeNode2.add(treeNode3);
    treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("rabbits born into the population");
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("during a year");
    treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("and it is constant from year to year");
    treeNode4.add(treeNode5);
    treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("and it varies from year to year");
    treeNode4.add(treeNode5);
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("across all years");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("per year on average");
    treeNode3.add(treeNode4);
    treeNode2.add(treeNode3);
    treeNode1.add(treeNode2);
    treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("A ratio of");
    treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("the number of rabbits in the population at the beginning of the year, divided by");
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the number of rabbits added to the population during that same year");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the total number of rabbits added up across all years");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the average number of rabbits across all years");
    treeNode3.add(treeNode4);
    treeNode2.add(treeNode3);
    treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("the number of rabbits added to the population during the year, divided by");
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the number of rabbits in the population at the beginning of that same year");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the total number of rabbits added to the population across all years");
    treeNode3.add(treeNode4);
    treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("the average number of rabbits added to the population each year");
    treeNode3.add(treeNode4);
    treeNode2.add(treeNode3);
    treeNode1.add(treeNode2);
    decisionTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
    decisionTree.setEditable(true);
    decisionTree.setRowHeight(23);
    jScrollPane2.setViewportView(decisionTree);

    evenMorePreciseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    evenMorePreciseLabel.setText("Description Tree of the Problem");

    quantityDescriptionTextField.setWrapStyleWord(true);
    quantityDescriptionTextField.setColumns(20);
    quantityDescriptionTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    quantityDescriptionTextField.setLineWrap(true);
    quantityDescriptionTextField.setRows(2);
    quantityDescriptionTextField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
    quantityDescriptionTextField.setMargin(new java.awt.Insets(2, 3, 2, 3));
    jScrollPane1.setViewportView(quantityDescriptionTextField);

    referencesLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    referencesLabel.setText("Precise description of the quantity:");

    nodeNameTextField.setDisabledTextColor(new java.awt.Color(102, 102, 102));

    NodeNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    NodeNameLabel.setText("Node Name:");

    buttonGroup1.add(jRadioCorrect);
    jRadioCorrect.setText("Correct");

    buttonGroup1.add(jRadioInCorrect);
    jRadioInCorrect.setText("InCorrect");

    buttonAddDesc.setText("Add");
    buttonAddDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonAddDescActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
    contentPanel.setLayout(contentPanelLayout);
    contentPanelLayout.setHorizontalGroup(
      contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(contentPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
            .addComponent(referencesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(53, 53, 53))
          .addGroup(contentPanelLayout.createSequentialGroup()
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jRadioCorrect)
                .addGap(26, 26, 26)
                .addComponent(jRadioInCorrect)
                .addGap(27, 27, 27)
                .addComponent(buttonAddDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                  .addComponent(NodeNameLabel)
                  .addGap(18, 18, 18)
                  .addComponent(nodeNameTextField))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addComponent(evenMorePreciseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
            .addContainerGap(30, Short.MAX_VALUE))))
    );
    contentPanelLayout.setVerticalGroup(
      contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(contentPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(evenMorePreciseLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(NodeNameLabel)
          .addComponent(nodeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(referencesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jRadioCorrect)
          .addComponent(jRadioInCorrect)
          .addComponent(buttonAddDesc))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Method to handle Add Correct/InCorrect description 
   * Checks if the Node already has a correct description
   * @param evt 
   */
  private void buttonAddDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddDescActionPerformed
    
    String nodeDescription = quantityDescriptionTextField.getText();
    
    // Check if user has provided the description
    if(nodeDescription == null || nodeDescription.isEmpty()){
      MessageDialog.showMessageDialog(null, true, "Please Provide Desciption", 
              modelGraph);
      return;
    }  
    
    String nodeName = "new_node";
    
    // check if node already has a name provided by the Author
    if(currentVertex.getNodeName().compareTo("") != 0){
      nodeName = currentVertex.getNodeName();
    }
    
    // Check if Correct or Incorrect option button is selected
    if (jRadioCorrect.isSelected()) {
      logs.trace("Adding Correct Description");
      if (dTree.add(nodeDescription, nodeName, true) == 1) {
        MessageDialog.showMessageDialog(null, true, 
                "Node already has a correct description.", modelGraph);
      }
      
    } else if (jRadioInCorrect.isSelected()) {
        logs.trace("Adding InCorrect Description");
        dTree.add(nodeDescription, nodeName, false);
    } else {
        MessageDialog.showMessageDialog(null, true, 
              "Please Select Description Type", modelGraph);
    }

    model.reload();

    TreeNode root = (TreeNode) decisionTree.getModel().getRoot();
    expandAll(decisionTree, new TreePath(root));

  }//GEN-LAST:event_buttonAddDescActionPerformed

  // returns the value held by triedDuplicate
  public boolean getTriedDuplicate() {
    return triedDuplicate;
  }

  public boolean duplicatedNode(String nodeName) {
    if(currentVertex.getNodeName().compareTo(nodeName) == 0){
      return false;
    }
    
    if(modelGraph.getVertexByName(nodeName) == null)
      return false;
    else
      return true;
  }

  private TreePath[] getPaths(JTree tree, boolean expanded) {
    TreeNode root = (TreeNode) tree.getModel().getRoot();
    List<TreePath> list = new ArrayList<TreePath>();
    getPaths(tree, new TreePath(root), expanded, list);

    return (TreePath[]) list.toArray(new TreePath[list.size()]);
  }

  private void getPaths(JTree tree, TreePath parent, boolean expanded, 
          List<TreePath> list) {
    list.add(parent);
    TreeNode node = (TreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (Enumeration e = node.children(); e.hasMoreElements();) {
        TreeNode n = (TreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        getPaths(tree, path, expanded, list);
      }
    }
  }

  public void collapseAll(javax.swing.JTree tree) {
    int row = tree.getRowCount() - 1;
    while (row >= 1) {
      tree.collapseRow(row);
      row--;
    }
  }

  public void expandTreePath(javax.swing.JTree tree, TreePath treepath) {
    collapseAll(tree);
    decisionTree.scrollPathToVisible(treepath);
    decisionTree.setSelectionPath(treepath);
  }
 protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = DescriptionPanelView.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }

  private void initTree() {
    savedDecisionTree = DescriptionTree.getDecisionTree();
    dTree = DescriptionTree.getDecisionTree();
    root = dTree.getRoot();
    ImageIcon correctLeafIcon = createImageIcon("/amt/images/correct.gif");
    ImageIcon inCorrectLeafIcon = createImageIcon("/amt/images/incorrect.gif");

    if (correctLeafIcon != null && inCorrectLeafIcon != null) {
      decisionTree.setCellRenderer(new DecisionTreeRenderer(correctLeafIcon, 
              inCorrectLeafIcon));
    }
    model = new DefaultTreeModel(root);
    decisionTree.setModel(model);

    jScrollPane2.setViewportView(decisionTree);

    TreeNode root = (TreeNode) decisionTree.getModel().getRoot();
    expandAll(decisionTree, new TreePath(root));
  }

  private void expandAll(JTree tree, TreePath parent) {
    TreeNode node = (TreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (Enumeration e = node.children(); e.hasMoreElements();) {
        TreeNode n = (TreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        expandAll(tree, path);
      }
    }
    tree.expandPath(parent);
    // tree.collapsePath(parent);
  }

  /*
   * Method to process the Action of Ok Button on the Description Panel
   * This is called from NodeEditor
   */
  public boolean processSubmitAction(){

    if(validateNodeName() && validateNodeDescription()){
    
    /* Check if Author has added correct description for the Node
    if(!dTree.nodeHasCorrectDesciption(inputNodeName)){
      MessageDialog.showMessageDialog(null, true, "Please Provide Correct"
              + "Description for this Node", authorGraph);
      return false;
    }

    // Update dTree Node Name (from new_node to the provided node)
    String dTreeNodeName = "new_node";
    if(currentVertex.getNodeName().compareTo("") != 0)
      dTreeNodeName = currentVertex.getNodeName();
    
    dTree.updateNodeName(dTreeNodeName, inputNodeName);
    */
    currentVertex.setNodeName(nodeNameTextField.getText());
    currentVertex.setSelectedDescription(quantityDescriptionTextField.getText());
    
    // Moves the Label below the node
    currentVertex.defaultLabel();

    return true;
    }
    return false;
  }
  
  private boolean validateNodeName(){
    String inputNodeName = nodeNameTextField.getText();
    
    // Check if Node Name is provided
    if(inputNodeName.isEmpty()){
      NodeEditor.getInstance().setEditorMessage(ErrorMessages.EMPTY_NODE_ERROR);
      return false;
    }
    
    // Check for Invalid Names
    if(inputNodeName.length() == 1){
      logs.trace("here here");
      if(inputNodeName.charAt(0) == '+' || inputNodeName.charAt(0) == '-' ||
              inputNodeName.charAt(0) == '*' || inputNodeName.charAt(0) == '/'){
        NodeEditor.getInstance().setEditorMessage(
                ErrorMessages.OPERATOR_AS_NODE_NAME);
        
        return false;
      }        
    }
    
    // Check for Duplicate NodeName
    if (duplicatedNode(inputNodeName)) {
      String message = String.format("A node with name %s already exists in the"
              + " Graph", inputNodeName);
      NodeEditor.getInstance().setEditorMessage(message);
      nodeNameTextField.setText("");
      return false;
    }
    
    return true;
  }
  
  private boolean validateNodeDescription(){
  if(quantityDescriptionTextField.getText().isEmpty()){
      NodeEditor.getInstance().setEditorMessage(
              ErrorMessages.EMPTY_NODE_DESCRIPTION);
      return false;
    }
    return true;
  }

  public void processDeleteAction(){
    logs.trace(  "Author deleted the node.");
    this.currentVertex.setNodeName(""); // sets the node to a state where it will be deleted by NodeEditor.java when closed
    java.awt.event.WindowEvent e = new java.awt.event.WindowEvent(NodeEditor.getInstance(), 201); // create a window event that simulates the close button being pressed
    NodeEditor.getInstance().windowClosing(e); // call the window closing method on NodeEditor
  }

  public void processCloseAction(){
    // Undo the decision tree changes
    DescriptionTree.undoDescriptionTreeChanges();
    
    java.awt.event.WindowEvent e = new java.awt.event.WindowEvent(NodeEditor.getInstance(), 201); // create a window event that simulates the close button being pressed
    NodeEditor.getInstance().windowClosing(e); // call the window closing method on NodeEditor

  }
  
  
  
  // Methods to Handle JTree
  public DefaultMutableTreeNode getSelectedTreeNode() {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
            decisionTree.getLastSelectedPathComponent();
    return node;
  }

  public void initTreeSelectionListener() {
    decisionTree.getSelectionModel().setSelectionMode(
            TreeSelectionModel.SINGLE_TREE_SELECTION);
    decisionTree.addTreeSelectionListener(this);
  }

  public void valueChanged(TreeSelectionEvent e) {
    DefaultMutableTreeNode node = getSelectedTreeNode();
    DecisionTreeNode n;
    try {
      if (node != null) {
        n = (DecisionTreeNode) node.getUserObject();
        //change input button status so that the (g) graphic on the vertex turns white
        currentVertex.setDescriptionDefined(false);
        //reset background colors
        quantityDescriptionTextField.setBackground(Selectable.COLOR_GREY);
        nodeNameTextField.setBackground(Selectable.COLOR_GREY);
        quantityDescriptionTextField.setEnabled(true);
        nodeNameTextField.setEnabled(true);
        if (node.isLeaf()) {
          // check button should only be enabled if the node is a leaf
          treeSelected = true;

          //zpwn: to get & update vertex decision tree path.
          treePaths.add(decisionTree.getSelectionPath());
          if (currentVertex.getTreePath() == null) {
            currentVertex.setTreePath(decisionTree.getSelectionPath());
          } else if (decisionTree.getSelectionPath() != currentVertex.getTreePath()) {
            currentVertex.setTreePath(decisionTree.getSelectionPath());
          }
          //done

          //Get the data from the tree to fill the nodeName. A leaf node has a label and an answer.
          nodeNameTextField.setText(n.getAnswer());

          currentVertex.setSelectedDescription(quantityDescriptionTextField.getText());
          currentVertex.setNodeName(nodeNameTextField.getText());
          currentVertex.defaultLabel();

          //Populate the quantity description label
          String description = "";
          TreeNode[] ancestors = node.getPath();
          for (int i = 0; i < ancestors.length; i++) {
            if (!ancestors[i].toString().equalsIgnoreCase("Node")) {
              if (!description.isEmpty()) {
                description += " " + ancestors[i].toString();
              } else {
                description = ancestors[i].toString();
              }
            }
          }
          quantityDescriptionTextField.setText(description);
          currentVertex.setSelectedDescription(description);
          
          NodeEditor.getInstance().getInputsPanel().updateNodeDescription();
          NodeEditor.getInstance().getGraphsPanel().updateDescription();
          

          if (currentVertex.getSelectedDescription().trim().equals(description)) {
            logs.trace( "DescriptionPanel.valueChanged.1 "+ "legal_" + currentVertex.getNodeName());
          } else {
            logs.trace( "DescriptionPanel.valueChanged.1 "+ "!legal");
          }
        } else {
          treeSelected = false;

        }
      } else {
        // check button should be disabled if the node is not a leaf
        treeSelected = false;

      }
    } catch (ClassCastException cce) {
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel NodeNameLabel;
  private javax.swing.JButton buttonAddDesc;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JPanel contentPanel;
  private javax.swing.JTree decisionTree;
  private javax.swing.JLabel evenMorePreciseLabel;
  private javax.swing.JRadioButton jRadioCorrect;
  private javax.swing.JRadioButton jRadioInCorrect;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextField nodeNameTextField;
  private javax.swing.JTextArea quantityDescriptionTextField;
  private javax.swing.JLabel referencesLabel;
  // End of variables declaration//GEN-END:variables

    
  
}

