package pharmacymanagement;

import java.util.ArrayList;

public class ListOfMedicine {
    // list of medicine 
    ArrayList<Medicine> list ;
    // no argument constractor
    public ListOfMedicine() {
    }
    // with argument constractor
    public ListOfMedicine(ArrayList<Medicine> list) {
        this.list = list;
    }
    // setter and getter method
    public ArrayList<Medicine> getList() {
        return list;
    }
    public void setList(ArrayList<Medicine> list) {
        this.list = list;
    }
    
}
