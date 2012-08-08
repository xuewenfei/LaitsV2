package laits.cover;

import laits.Main;
import laits.comm.CommException;
import laits.data.TaskFactory;
import laits.graph.Graph;
import laits.graph.GraphCanvas;
import laits.gui.SideBar;
import laits.graph.Vertex;
import java.awt.*;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Invisible layout to show overlapped elements over the graph. E.g. Duke
 *
 * @author Javier Gonzalez Sanchez
 * @author Megan Kearl
 * @version 20100430
 */
public class Cover implements Runnable {

  private Thread thread;
  private JPanel jpanel;
  private Font n = new Font("Normal", Font.PLAIN, 20); //font in the speech bubbles
  private GraphCanvas gc;
  private SideBar sideBar;

  private Clock clock;
  private boolean hideComponents = true;
  private Calendar cal;
  private long startTime, endTime = 0;


  /**
   * Constructor
   * @param jpanel
   */
  public Cover (GraphCanvas jpanel, Graph graph, Frame frame){
    this.jpanel = jpanel;
    this.gc = jpanel;
    clock = new Clock(gc, "graphCanvas");
    cal = Calendar.getInstance();
    startTime = cal.getTimeInMillis();


    sideBar = new SideBar(gc, graph, n, frame);

    thread = new Thread(this);
    thread.start();
  }

  /**
   * This method returns the Menu Bar
   */
  public SideBar getMenuBar()
  {
      return sideBar;
  }


  /**
   * This method sets the font
   * @param f
   */
  public void setFont(Font f) {
    n = f;
  }


  /**
   * This method paints the avatar and the boxes around the hints and help
   * @param g
   */
  public void paint(Graphics g){

    //Paint the clock to all screens
    clock.setHeight(gc.getHeight());
    clock.paint(g);


    //Determine whether the model can be run


        if(gc.canRun())
        {
          sideBar.getPredictButton().setEnabled(true);
        }
        else
        {
          sideBar.getPredictButton().setEnabled(false);
          gc.setModelHasBeenRun(false);
        }

        if (gc.getGraph().getVertexes().size() != 0) {
          sideBar.getPredictButton().setEnabled(true);
        } else {
          sideBar.getPredictButton().setEnabled(false);
        }
        LinkedList<String> extraNodes = null;

        if (extraNodes == null){
          extraNodes = new LinkedList<String>();
        }

        int extranodecount = 0;
          for (String extra : extraNodes) {
            for (int i = 0; i < gc.getGraph().getVertexes().size(); i++) {
              if (((Vertex) gc.getGraph().getVertexes().get(i)).getNodeName().equals(extra)) {
                extranodecount++;
              }
            }
          }

        if(gc.getGraph().getVertexes().size()-extranodecount == gc.listOfVertexes.size()-extraNodes.size()){
          boolean allCorrect = true;
          for (int i = 0; i < gc.getGraph().getVertexes().size(); i++) {
            Vertex v = (Vertex)gc.getGraph().getVertexes().get(i);
            if (v.getGraphsButtonStatus() != v.CORRECT && v.getGraphsButtonStatus() != v.GAVEUP) {
              allCorrect = false;
            }
          }

        }



  }

  /**
   * This method returns the clock so a height can be set
   * @return
   */
  public Clock getClock()
  {
    return clock;
  }

  /**
   * This method runs the thread for the animation
   */
  public void run() {
    while (!Main.windowIsClosing()){
      jpanel.repaint();
      try {
          Thread.sleep(150);
      } catch (InterruptedException ex) {
      }
    }
  }


  public void hideSomeComponents(boolean hideComponents) {
    this.hideComponents = hideComponents;
  }

}
