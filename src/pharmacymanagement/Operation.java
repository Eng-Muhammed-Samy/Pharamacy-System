package pharmacymanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Operation {
    // this method used to search about medicines by id
    public static Medicine search(ArrayList<Medicine> list, int idInput){
        for (Medicine medicine : list) {
            if(idInput == medicine.getMedicineId()){
                // if true return medicine obj
               return medicine ; 
            }
        }
        return null;
    }
    // this method used to remmove any medicine
    public static void remove(ArrayList<Medicine> list, int id){
        // search by id
        Medicine medicine = search(list, id);
        list.remove(medicine); // reomve from list
    }
    //this method used to add all information to medicine object
    public static Medicine add(int id, int rackNo, int cabinetNo, String Name, int unitCost, int sales){
       // save all information from text iputs to medicine object
        Medicine med = new Medicine();
        med.setMedicineId(id);
        med.setRackNo(rackNo);
        med.setCabinetNo(cabinetNo);
        med.setSupplierName(Name);
        med.setUnitCost(unitCost);
        med.setSalesPrice(sales); 
        return med;
    }
    //this function used to calculate buy 
    public static int buy(ArrayList<Medicine> list, String name){
        
        for (Medicine medicine : list) {
            String n = medicine.getSupplierName(); // name of saved medicine
            if(n.equals(name)){// compare between two name
                //if equlas --> return cost of this medicine
                return medicine.getUnitCost();
            }
        }
        return 0;
    }
       // this function used to reload all information from file
    public static ListOfMedicine loadListOfMedicine(String savefile) {
                // crate mapper object
		ObjectMapper mapp = new ObjectMapper();
		ListOfMedicine medicines = null;

		try {
                    //load the data from file
			medicines = mapp.readValue(new File(savefile), ListOfMedicine.class);
		} catch (Exception e) {
                    e.printStackTrace();
                }

		return medicines ;
    }
        // this function used to add all information to file
    public static void AddListOfMedicine(ListOfMedicine medicine, String savefile) {

		try {
                    // using mapper to save a data in file
			ObjectMapper mapp = new ObjectMapper();
			mapp.writeValue(new File(savefile), medicine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    // this function used to calculate total cost
    public static int[] totalCost(ArrayList<Medicine> list){
        int x[] = new int[3];// to save all (cost and sales)
        for(int i = 0; i<list.size(); i++){
            x[0] += list.get(i).getUnitCost();// save total cost in here
            x[1] += list.get(i).getSalesPrice(); // save total sale in here
        }
        x[2] = x[0]-x[1]; // calculate net cost
        return x;
    }
}
