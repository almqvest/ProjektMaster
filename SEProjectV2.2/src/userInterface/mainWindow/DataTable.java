package userInterface.mainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.*;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//TableModel that returns the actual class and not String
//May or may not be needed

/**
 * Table that visualizes a DefaultTableModel.
 *  @see javax.swing.JTable
 * Has JCheckbox[] that correspond to the table headers.
 * Upon declaration, the table's model is loaded by an external text data.
 * @see start.Main.Datahandler.load()
 *@author Dalya
 *
 */


public class DataTable extends JTable{
  

  private static final long serialVersionUID = 1L;

  static String[] columnNames = {"Produktbezeichnung", "Kategorie", "Lagernummer", "Gewicht", "Stückpreis (€)", "Anzahl"};
  public static DefaultTableModel model= start.DataHandler.load();
  //ArrayList<JCheckBox> searchCheckboxes = new ArrayList<>();
  JCheckBox[] CheckboxArray = new JCheckBox[columnNames.length];
  
  TableRowSorter sorter;
    
  public DataTable() {
    
    super(model);
    sorter=new TableRowSorter<>(model);
    this.setRowSorter(sorter);

    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    getTableHeader().setReorderingAllowed(false);
    //setNewDatabase();
    //TODO Open Editing frame with correct values
    //ArrayList<Integer> indexesOfSelected = new ArrayList<Integer>();
    /*
    for (int i = 0; i < this.CheckboxArray.length; i++) {
      JCheckBox box = this.CheckboxArray[i];
      if (box.isSelected()) {
        indexesOfSelected.add(i);
      }
    }*/
    
    for (int ii=0; ii<CheckboxArray.length; ii++) {
         JCheckBox box = new JCheckBox(columnNames[ii]);
         CheckboxArray[ii] = (box);
        }
    
    
    
    
    
    addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) { 
             int row= start.Main.table.getSelectedRow();
           if ((e.getClickCount()==2) && (((DataTable) e.getSource()).getSelectedRow()!=-1)) {
            new userInterface.editProductInterface.EditProduct(start.Main.table.convertRowIndexToModel(row));

           } 
            }
          });
    }
  
  
//  public void setNewDatabase(){
//    model.setRowCount(0);
//    ArrayList<String> databaseAsString = start.Main.List.databaseAsString;
//    String[] showMe = new String[6];
//    for (int ii = 0; databaseAsString.size()/6>ii;ii++) {
//      for (int kk=0; kk<6;kk++) {
//        showMe[kk] = databaseAsString.get(ii*6+kk);
//      }
//      model.addRow(showMe);
//    }
//  }
  
  @Override 
  public boolean isCellEditable(int row, int column) {
         return false;
      
  }
  
  /**
   * returns the indexes of the selected CheckBoxes in an array.
   * 
   */
  
  @Override
  public int[] getSelectedColumns() {
      ArrayList<Integer> indexesOfSelected = new ArrayList<Integer>();
      for (int i = 0; i < this.CheckboxArray.length; i++) {
       JCheckBox box = this.CheckboxArray[i];
       if (box.isSelected()) {
        indexesOfSelected.add(i);
       }
      }
      
      int[] rv = new int[indexesOfSelected.size()];
      // java is stupid
      for (int i = 0; i < rv.length; i++) {
       rv[i] = indexesOfSelected.get(i);
      }
      return rv;

     }
  /*
  // returns selected checkboxes
  public int[] getSelectedColumns() {
    ArrayList<Integer> indexesOfSelected = new ArrayList<Integer>();
    for (int i = 0; i < this.searchCheckboxes.size(); ++i) {
      JCheckBox box = this.searchCheckboxes.get(i);
      if (box.isSelected()) {
        indexesOfSelected.add(i);
      }
    }
    
    int[] rv = new int[indexesOfSelected.size()];
    // java is stupid
    for (int i = 0; i < rv.length; i++) {
      rv[i] = indexesOfSelected.get(i);
    }
    return rv;
  }
  
  ArrayList<JCheckBox> getCheckboxes() {
    return this.searchCheckboxes;
  }*/

  /**
   * returns CheckBox at index
   * @param index index of CheckBox
   * @return
   */
  JCheckBox getCheckBox(int index){
       return this.CheckboxArray[index];
      }
  
}

