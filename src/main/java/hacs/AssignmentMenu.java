package hacs;

import javax.swing.*;


abstract public class AssignmentMenu extends JDialog {
  abstract void showMenu(Assignment ass, Person per);
  public AssignmentMenu() {
    setModal(true);
    setSize(575,330);
  }
}
