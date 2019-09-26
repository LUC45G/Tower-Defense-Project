package Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel extends JLabel {

  public MyLabel(String msg) {

    super(msg);

    addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
        fireActionPerformed(new ActionEvent(MyLabel.this, ActionEvent.ACTION_PERFORMED,
            "SecretMessage"));
      }
    });
  }

  public void addActionListener(ActionListener l) {
    listenerList.add(ActionListener.class, l);
  }

  public void removeActionListener(ActionListener l) {
    listenerList.remove(ActionListener.class, l);
  }

  protected void fireActionPerformed(ActionEvent ae) {

    Object[] listeners = listenerList.getListeners(ActionListener.class);

    for (int i = 0; i < listeners.length; i++) {
      ((ActionListener) listeners[i]).actionPerformed(ae);
    }
  }
}