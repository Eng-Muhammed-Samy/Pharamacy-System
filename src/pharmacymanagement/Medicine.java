
package pharmacymanagement;

public class Medicine {
    // name of all variables 
    private int medicineId;
    private int rackNo;
    private int cabinetNo;
    private String supplierName;
    private int unitCost;
    private int salesPrice;
    // constractor
    public Medicine() {
    }
    // all setter and getter function 
    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
    public int getRackNo() {
        return rackNo;
    }
    public void setRackNo(int rackNo) {
        this.rackNo = rackNo;
    }
    public int getCabinetNo() {
        return cabinetNo;
    }
    public void setCabinetNo(int cabinetNo) {
        this.cabinetNo = cabinetNo;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public int getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }
    public int getSalesPrice() {
        return salesPrice;
    }
    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }
    
}
 