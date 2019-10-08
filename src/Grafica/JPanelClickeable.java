package Grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelClickeable extends JPanel{
	
	 public JPanelClickeable() {

		    super();

		    addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		        fireActionPerformed(new MouseEvent(JPanelClickeable.this, HEIGHT, HEIGHT, HEIGHT, HEIGHT, HEIGHT, PROPERTIES, getAutoscrolls()) {
		        	
		        });
		      }

		    });
	 }
	 
	 public void addActionListener(ActionListener l) {
		    listenerList.add(ActionListener.class, l);
		  }
	 public void addMouseListener(MouseListener l) {
		    listenerList.add(MouseListener.class, l);
		  }


	  public void removeActionListener(ActionListener l) {
	    listenerList.remove(ActionListener.class, l);
	  }

	  protected void fireActionPerformed(MouseEvent s) {
		    Object[] listeners = listenerList.getListeners(MouseListener.class);
	
		    for (int i = 0; i < listeners.length; i++) {
		      ((MouseListener) listeners[i]).mouseClicked(s);
		    }
	  }
}
