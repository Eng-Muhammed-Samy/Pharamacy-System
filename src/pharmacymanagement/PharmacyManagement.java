package pharmacymanagement;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PharmacyManagement extends Application {
    //input text field
    static TextField txt1 = new TextField();
    static TextField txt2 = new TextField();
    static TextField txt3 = new TextField();
    static TextField txt4 = new TextField();
    static TextField txt5 = new TextField();
    static TextField txt6 = new TextField();
    // output labels
    static Label label1 = new Label();
    static Label label2 = new Label();
    static Label label3 = new Label();
    static Label label4 = new Label();
    static Label label5 = new Label();
    static Label label6 = new Label();
    // to show cost and sales and net cost
    static Label total = new Label();
    static Label sales = new Label();
    static Label net = new Label();
    
    static Label sh = new Label();
    //list of medicine
    static ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    //object of medicine
    static Medicine med;
    //path of file 
    static String pass = "text.json";
    // glopal stage
    static Stage stg = new Stage();
    @Override
    public void start(Stage primaryStage) {
        primaryStage = stg;// set primary stage equal to stage
        primaryStage.setTitle("PHARMACY MANAGEMENT SYSTEM"); // set title to project
        primaryStage.setScene(Mainscene());// add new scene
        primaryStage.show();// show stage
    }
    public static void main(String[] args) {
        //load list after run program
        medicines = Operation.loadListOfMedicine(pass).getList();
        launch(args);
    }    
    public Scene Mainscene(){
        // add main pane to add all buttons
        HBox root = new HBox();
        // make add button and set event action
        Button add = new Button("Add Item");
        Add a = new Add();
        add.setOnAction(a);
        // make ubdate button and set event action
        Button update = new Button("Update Item");
        Update u = new Update();
        update.setOnAction(u);
        // make delete button and set it some proberties , and set event action 
        Button delete = new Button("Delete Item");
        delete.setOnAction((event) -> {
            stg.setScene(delete());
        });
        // make buy button and set event action
        Button buy  = new Button("Buy Medicine");
        buy.setOnAction((event) -> {
            stg.setScene(buyScene());
        });
        // make Create purchases button and set event action
        Button purchasesCreate = new Button("Create purchases");
        Create c = new Create();
        purchasesCreate.setOnAction(c);
        // make search button and set event action 
        Button ser = new Button("Search");
        ser.setOnAction((event) -> {
            SrearchStage();
        });
        // make exit button and set event action
        Button exit = new Button("Exit");
        exit.setOnAction((event) -> {
            System.exit(0);
        });
        //set it size to buttons
        add.setMinSize(80, 40);
        update.setMinSize(80, 40);
        delete.setMinSize(80, 40);
        buy.setMinSize(80, 40);
        purchasesCreate.setMinSize(80, 40);
        exit.setMinSize(80, 40);
        ser.setMinSize(80, 40);
         //set it font size to buttons       
        add.setFont(new Font(18));
        update.setFont(new Font(18));
        delete.setFont(new Font(18));
        buy.setFont(new Font(18));
        purchasesCreate.setFont(new Font(18));
        exit.setFont(new Font(18));
        ser.setFont(new Font(18));
         //set it properties to buttons       
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        // add all buttons to pane
        root.getChildren().addAll(add, update, delete, buy, purchasesCreate, ser, exit);
        return new Scene(root, 900, 100);
    }
    public Scene scene(){
        //add pane to set oll nodes to it
        GridPane pane = new GridPane();
        Label lbl1 = new Label("Medicine Id");
        Label lbl2 = new Label("Rack Number");
        Label lbl3 = new Label("Cabinet Number");
        Label lbl4 = new Label("supplier’s Name");
        Label lbl5 = new Label("Unit Cost");
        Label lbl6 = new Label("Sales Price");
        // add event
        Button add = new Button("ADD");
        AddItem a = new AddItem();
        add.setOnAction(a);
        // set size for all labels
        lbl1.setMinSize(150, 50);
        lbl2.setMinSize(150, 50);
        lbl3.setMinSize(150, 50);
        lbl4.setMinSize(150, 50);
        lbl5.setMinSize(150, 50);
        lbl6.setMinSize(150, 50);
        // set font size fot all labels
        lbl1.setFont(new Font(20));
        lbl2.setFont(new Font(20));
        lbl3.setFont(new Font(20));
        lbl4.setFont(new Font(20));
        lbl5.setFont(new Font(20));
        lbl6.setFont(new Font(20));
        // set size for all texts
        txt1.setMinSize(200, 50);
        txt2.setMinSize(200, 50);
        txt3.setMinSize(200, 50);
        txt4.setMinSize(200, 50);
        txt5.setMinSize(200, 50);
        txt6.setMinSize(200, 50);
        // set font size fot all texts
        txt1.setFont(new Font(20));
        txt2.setFont(new Font(20));
        txt3.setFont(new Font(20));
        txt4.setFont(new Font(20));
        txt5.setFont(new Font(20));
        txt6.setFont(new Font(20));
        // set size and font size to add button
        add.setFont(new Font(20));
        add.setMinSize(80, 50);
        //add all nodes to pane
        pane.add(lbl1, 0, 0);
        pane.add(txt1, 1, 0);
        pane.add(lbl2, 0, 1);
        pane.add(txt2, 1, 1);
        pane.add(lbl3, 0, 2);
        pane.add(txt3, 1, 2);
        pane.add(lbl4, 0, 3);
        pane.add(txt4, 1, 3);
        pane.add(lbl5, 0, 4);
        pane.add(txt5, 1, 4);
        pane.add(lbl6, 0, 5);
        pane.add(txt6, 1, 5);
        pane.add(add, 0, 6);
        // set properties to node
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        
        return new Scene(pane, 500, 500);
    }
    public void stage(){
        // set new stage 
        Stage st = new Stage();
        // add new scene
        st.setScene(scene());
        st.show();// show this stage if click button
        st.setTitle("Medicine information"); // set title
    }
    public void SrearchStage(){
        // 7 leable to show the name of search item
        Label lb0 = new Label("Enter Id");
        Label lb1 = new Label("Medicine Id");
        Label lb2 = new Label("Rack Number");
        Label lb3 = new Label("Cabinet Number");
        Label lb4 = new Label("supplier’s Name");
        Label lb5 = new Label("Unit Cost");
        Label lb6 = new Label("Sales Price");
        Button ser = new Button("Search");
        // add all (labels and texts) to pane
        GridPane pane = new GridPane();
        pane.add(lb0, 0, 0);
        pane.add(txt1, 1, 0);
        pane.add(lb1, 0, 1);
        pane.add(label1, 1, 1);
        pane.add(lb2, 0, 2);
        pane.add(label2, 1, 2);
        pane.add(lb3, 0, 3);
        pane.add(label3, 1, 3);
        pane.add(lb4, 0, 4);
        pane.add(label4, 1, 4);
        pane.add(lb5, 0, 5);
        pane.add(label5, 1, 5);
        pane.add(lb6, 0, 6);
        pane.add(label6, 1, 6);
        pane.add(ser, 0, 7, 2, 1);
        // set properties to pane
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        // new scene
        Scene scene = new Scene(pane, 500, 500);
         // set properties to lb0 ,txt1
        lb0.setMinSize(150, 50);
        txt1.setMinSize(200, 50);
        lb0.setFont(new Font(20));
        txt1.setFont(new Font(20));
         // set properties to labels
        lb1.setMinSize(150, 50);
        lb2.setMinSize(150, 50);
        lb3.setMinSize(150, 50);
        lb4.setMinSize(150, 50);
        lb5.setMinSize(150, 50);
        lb6.setMinSize(150, 50);
        lb1.setFont(new Font(20));
        lb2.setFont(new Font(20));
        lb3.setFont(new Font(20));
        lb4.setFont(new Font(20));
        lb5.setFont(new Font(20));
        lb6.setFont(new Font(20));
         // set properties to output labels
        label1.setMinSize(200, 50);
        label2.setMinSize(200, 50);
        label3.setMinSize(200, 50);
        label4.setMinSize(200, 50);
        label5.setMinSize(200, 50);
        label6.setMinSize(200, 50);
        label1.setFont(new Font(20));
        label2.setFont(new Font(20));
        label3.setFont(new Font(20));
        label4.setFont(new Font(20));
        label5.setFont(new Font(20));
        label6.setFont(new Font(20));
         // set properties to search button
        ser.setMinSize(150, 50);
        ser.setOnAction((event) -> {
            med = Operation.search(medicines, Integer.parseInt(txt1.getText()));
            show(med);
        });
        // add new stage
        Stage s = new Stage();
        //set scene
        s.setScene(scene);
        s.show();// show this stage
    }
    public void ubdateStage(){
    //add pane to set oll nodes to it
        GridPane pane = new GridPane();
        Label lbl1 = new Label("Medicine Id");
        Label lbl2 = new Label("Rack Number");
        Label lbl3 = new Label("Cabinet Number");
        Label lbl4 = new Label("supplier’s Name");
        Label lbl5 = new Label("Unit Cost");
        Label lbl6 = new Label("Sales Price");
        // add event
        Button ubdate = new Button("Ubdate");
        // set size for all labels
        lbl1.setMinSize(150, 50);
        lbl2.setMinSize(150, 50);
        lbl3.setMinSize(150, 50);
        lbl4.setMinSize(150, 50);
        lbl5.setMinSize(150, 50);
        lbl6.setMinSize(150, 50);
        // set font size fot all labels
        lbl1.setFont(new Font(20));
        lbl2.setFont(new Font(20));
        lbl3.setFont(new Font(20));
        lbl4.setFont(new Font(20));
        lbl5.setFont(new Font(20));
        lbl6.setFont(new Font(20));
        // set size for all texts
        txt1.setMinSize(200, 50);
        txt2.setMinSize(200, 50);
        txt3.setMinSize(200, 50);
        txt4.setMinSize(200, 50);
        txt5.setMinSize(200, 50);
        txt6.setMinSize(200, 50);
        // set font size fot all texts
        txt1.setFont(new Font(20));
        txt2.setFont(new Font(20));
        txt3.setFont(new Font(20));
        txt4.setFont(new Font(20));
        txt5.setFont(new Font(20));
        txt6.setFont(new Font(20));
        // set size and font size to add button
        ubdate.setFont(new Font(20));
        ubdate.setMinSize(80, 50);
        //add all nodes to pane
        pane.add(lbl1, 0, 0);
        pane.add(txt1, 1, 0);
        pane.add(lbl2, 0, 1);
        pane.add(txt2, 1, 1);
        pane.add(lbl3, 0, 2);
        pane.add(txt3, 1, 2);
        pane.add(lbl4, 0, 3);
        pane.add(txt4, 1, 3);
        pane.add(lbl5, 0, 4);
        pane.add(txt5, 1, 4);
        pane.add(lbl6, 0, 5);
        pane.add(txt6, 1, 5);
        pane.add(ubdate, 0, 6);
        // set properties to node
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);

        ubdate.setOnAction((event) -> {
            //receve all information of medicine to variables
           int id = Integer.parseInt(txt1.getText());
           //ubdate function 
           med = Operation.search(medicines, id);
           updateFunction(med);
           //save after ubdate in file
           ListOfMedicine list = new ListOfMedicine(medicines);
           Operation.AddListOfMedicine(list, pass);
        });
        // add scene
        Scene scene = new Scene(pane, 500, 500);
        // add new stage
        Stage s = new Stage();
        //set scene
        s.setScene(scene);
        s.show();// show this stage
    }
    public void purchases(){
        //add pane to set oll nodes to itr 
        GridPane p = new GridPane();
        Label tot1 = new Label("Total Costs");
        Label tot2 = new Label("Total sales");
        Label tot3 = new Label("Net Cost");
        Button exit = new Button("exit");
        //add all nodes to container
        p.add(tot1, 0, 0);
        p.add(tot2, 0, 1);
        p.add(tot3, 0, 2);
        p.add(total, 1, 0);
        p.add(sales, 1, 1);
        p.add(net, 1, 2);
        p.add(exit, 0, 3);
        // set properties to contaner
        p.setHgap(10);
        p.setVgap(10);
        p.setAlignment(Pos.CENTER);
        // set size and ont size to labels
        tot1.setMinSize(150, 50);
        tot2.setMinSize(150, 50);
        tot3.setMinSize(150, 50);
        tot1.setFont(new Font(20));
        tot2.setFont(new Font(20));
        tot3.setFont(new Font(20));
        // set size and ont size to labels
        total.setMinSize(150, 50);
        sales.setMinSize(150, 50);
        net.setMinSize(150, 50);
        total.setFont(new Font(20));
        sales.setFont(new Font(20));
        net.setFont(new Font(20));
        // calculate total , sales, net cost 
        int x[] = Operation.totalCost(medicines);
        total.setText(String.valueOf(x[0]));
        sales.setText(String.valueOf(x[1]));
        net.setText(String.valueOf(x[2]));
         // set size and ont size to exit button
        exit.setMinSize(100, 50);
        exit.setFont(new Font(20));
        // add new scene
        Scene sc = new Scene(p, 320, 250);
        Stage s = new Stage();
        s.setScene(sc);// add new scene to stage
        s.show();
        // event action of exit button
        exit.setOnAction((event) -> {
            s.close();
        });
    }
    class Add implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            stage(); // show add screen
        }
        
    }
    class AddItem implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           //receve all information of medicine to variables
           int id = Integer.parseInt(txt1.getText());
           int rack = Integer.parseInt(txt2.getText());
           int cabine = Integer.parseInt(txt3.getText());
           int Cost = Integer.parseInt(txt5.getText());
           String supplierName = txt4.getText();
           int sales = Integer.parseInt(txt6.getText());
           // this function used to add information to medicine object
           med = Operation.add(id, rack, cabine, supplierName , Cost, sales);
           medicines.add(med); // add object to list
           // save list of objects to json file
           ListOfMedicine list = new ListOfMedicine(medicines);
           Operation.AddListOfMedicine(list, pass);
        }
        
    }
    class Update implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            //show update stage
           ubdateStage();
        }
        
    }
    class Delete implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // call remove function to delete this object
            Operation.remove(medicines, Integer.parseInt(txt1.getText()));
            sh.setText("deleted");// if deleted set this name on label
            // save after delete
            ListOfMedicine list = new ListOfMedicine(medicines);
            Operation.AddListOfMedicine(list, pass);
        }
        
    }
    class Buy implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // call bey function and set output of function on label
          int x = Operation.buy(medicines, txt4.getText());
          sh.setText(String.valueOf(x));
          sh.setFont(new Font(20));
        }
        
    }
    class Create implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // shaow purchases stage after click of create button
          purchases();
        }
        
    }   
    public void show(Medicine medicine){
        // show all information about any medicine object on labels after call search function
        label1.setText(String.valueOf(medicine.getMedicineId()));
        label2.setText(String.valueOf(medicine.getRackNo()));
        label3.setText(String.valueOf(medicine.getCabinetNo()));
        label4.setText(medicine.getSupplierName());
        label5.setText(String.valueOf(medicine.getUnitCost()));
        label6.setText(String.valueOf(medicine.getSalesPrice()));
    }
    public void updateFunction(Medicine medicine){
        // save all information from texts to medicine object
           medicine.setCabinetNo(Integer.parseInt(txt3.getText()));
           medicine.setRackNo(Integer.parseInt(txt2.getText()));
           medicine.setSupplierName(txt4.getText());
           medicine.setUnitCost(Integer.parseInt(txt5.getText()));
           medicine.setSalesPrice(Integer.parseInt(txt6.getText()));
   }
    public Scene delete(){
        // container 
       HBox box = new HBox();
       // to tell user enter here
       Label lbl = new Label("Enter Id");
       Button bt = new Button("Delete");
       Button ret = new Button("Return");
       // add all to box pane and add properties to box
       box.getChildren().addAll(lbl, txt1, bt, sh, ret);
       box.setSpacing(10);
       box.setAlignment(Pos.CENTER);
       // add properties to labels and texts
       lbl.setMinSize(150, 50);
       bt.setMinSize(150, 50);
       txt1.setMinSize(150, 50);
       sh.setMinSize(150, 50);  
       // delete action 
       Delete d = new Delete();
       bt.setOnAction(d);
       ret.setOnAction((event) -> {
           // add scene to glopal stage
           stg.setScene(Mainscene());
       });
       return new Scene(box, 900, 100);
   }
    public Scene buyScene(){
        // container 
       HBox box = new HBox();
        // to tell user enter here
       Label lbl = new Label("Enter Id");
       Button bt = new Button("Cost");
       Button ret = new Button("Return");
         // add all to box pane and add properties to box
       box.getChildren().addAll(lbl, txt4, bt, sh, ret);
       box.setSpacing(10);
       box.setAlignment(Pos.CENTER);
        // add properties to labels and texts
       lbl.setMinSize(150, 50);
       bt.setMinSize(150, 50);
       txt4.setMinSize(150, 50);
       sh.setMinSize(150, 50);  
        // buy action 
       Buy b = new Buy();
       bt.setOnAction(b);
       ret.setOnAction((event) -> {
           // add scene to glopal stage
           stg.setScene(Mainscene());
       });
       return new Scene(box, 900, 100);
   }
} 
