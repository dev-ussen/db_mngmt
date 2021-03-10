package com.company.ShipperControl;

import com.company.Employee.specialty.Director;
import com.company.database.IDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//class that controls action on shipper
public class ShipperControl {
    //Class that responsible for manipulation with shipper information
    private final IDB db;//to get connection to database
    private final Scanner scan;//scanner to input
    public ShipperControl(IDB db) {//giving value with constructor
        this.db = db;
        this.scan = new Scanner(System.in);
    }
    public boolean CreateRelation(String Name_company) { //method to create Realtion
        Connection con = null; //connection to database
        try {
            con = db.getConnection();//getting connection to database
            Shipper shipper = new Shipper(Name_company); //containing company name
            ArrayList<Shipper> media = new ArrayList<>(); //Arraylist to contain products of media Department
            ArrayList<Shipper> worker = new ArrayList<>();//Arraylist to contain products of worker Department
            ArrayList<Shipper> tech = new ArrayList<>();//Arraylist to contain products of technical Department
            ArrayList<Shipper> rel_al = new ArrayList<>();//Arraylist to contain products of department of release and analysis
            ArrayList<Shipper> admin = new ArrayList<>(); //Arraylist to contain products of administration
            double perc = 0;
            double ln_perc = 0;
            Director.Connection(Name_company);//to output that Director collaborates with company
            System.out.println("Choose department for products: ");
            System.out.println("1 - Media department;");
            System.out.println("2 - Worker Management;");
            System.out.println("3 - Technical Management;");
            System.out.println("4 - Department of release and analysis;");
            System.out.println("5 - Administration.");

            while (true) { //while choose is not 0  (loop to choose departments)
                int choose = scan.nextInt();//inputting choose (department 1-5)
                if (choose == 1) { //in case 1, user chooses products for media department
                    System.out.println("Please, enter what type of product you want to register for Media department? (0 to stop)");
                    while (true) { //while user will not enter 0   (loop to choose products)
                        String product = scan.next(); //will choose products
                        if ((product.equals("0"))) { //if user inputs 0, stops product selection
                            System.out.println("Select next department");
                            break;
                        } else { // if doesn't
                            System.out.println(" "); //chooses which quality user wants
                            System.out.println("Please, choose quality of video: ");
                            System.out.println("1 - 720p");
                            System.out.println("2 - 1080p");
                            System.out.println("3 - 4K");
                            System.out.println("4 - 8K");
                            String quality = " ";//saving quality to insert into database
                            int hd = scan.nextInt();//user inputs number of quality
                            if (hd == 1) {
                                perc = 0.1;//increasing price of collaboration to 10%
                                quality = "720p";
                            } else if (hd == 2) {
                                perc = 0.15;//increasing price of collaboration to 15%
                                quality = "1080p";
                            } else if (hd == 3) {
                                perc = 0.22;//increasing price of collaboration to 22%
                                quality = "4K";
                            } else if (hd == 4) {
                                perc = 0.3;//increasing price of collaboration to 30%
                                quality = "8K";
                            }               //saving product and its quality
                            Shipper shipper1 = new Shipper(Name_company, product, quality);
                            System.out.println("Please, choose dubbing (0 to quit)!"); //choosing dubbing
                            System.out.println("1 - kazakh");
                            System.out.println("2 - russian");
                            System.out.println("3 - english");
                            System.out.println("4 - germany");
                            System.out.println("5 - spanish");
                            int cnt = 0;
                            while (true) {
                                int ln = scan.nextInt();//while user doesn't input 0, will choose dubbing
                                // also saving chosen dubbing in object of Shipper
                                // (arraylist of dubbing there)
                                if (ln == 1)
                                    shipper1.setDubbing("kazakh");
                                if (ln == 2)
                                    shipper1.setDubbing("russian");
                                if (ln == 3)
                                    shipper1.setDubbing("english");
                                if (ln == 4)
                                    shipper1.setDubbing("germany");
                                if (ln == 5)
                                    shipper1.setDubbing("spanish");
                                if (ln == 0) {
                                    //in case stopping choosing parameters of product, user can choose next product of media
                                    System.out.println("0 - to stop product selection. Write name of product to continue.");
                                    break;
                                }
                                cnt++;// shows how many dubbing languages chosen
                            }
                            if (cnt == 2) //if 2
                                ln_perc = 0.045; //increasing price of collaboration to 4.5%
                            else if (cnt == 3) //if 3
                                ln_perc = 0.09; //increasing price of collaboration to 9%%
                            else if (cnt == 4) //if 4
                                ln_perc = 0.135;//increasing price of collaboration to 13.5%
                            else if (cnt == 5) //if 5
                                ln_perc = 0.18;//increasing price of collaboration to 18%
                            media.add(shipper1);//saving in array object of Shipper with data
                        }
                    }
                    System.out.println("============================");
                } else if (choose == 2) { //if user chooses worker department
                    System.out.println("Please, enter what type of product you want to register for Worker department? (0 to stop)");
                    while (true) { //choosing product until 0 is entered
                        String product = scan.next();
                        if ((product.equals("0"))) { //if user enters 0, then user can choose next product
                            System.out.println("Select next department");
                            break;
                        }
                        else {//and if user enters product then it's saved in object of Shipper
                            Shipper shipper2 = new Shipper(Name_company, product);
                            worker.add(shipper2);//and adding into array of worker
                        }
                    }
                    System.out.println("============================");
                } else if (choose == 3) {//if user chooses technical department
                    System.out.println("Please, enter what type of product you want to register for technical department? (0 to stop)");
                    while (true) { //choosing product until 0 is entered
                        String product = scan.next();
                        if ((product.equals("0"))) { //if user enters 0, then user can choose next product
                            System.out.println("Select next department");
                            break;
                        }
                        else {//and if user enters product then it's saved in object of Shipper
                            Shipper shipper3 = new Shipper(Name_company, product);
                            tech.add(shipper3);//and adding into array of tech
                        }
                    }
                    System.out.println("============================");
                } else if (choose == 4) {//if user chooses Department of release and analysis
                    System.out.println("Please, enter what type of product you want to register for Department of release and analysis? (0 to stop)");
                    while (true) { //choosing product until 0 is entered
                        String product = scan.next();
                        if ((product.equals("0"))) { //if user enters 0, then user can choose next product
                            System.out.println("Select next department");
                            break;
                        }
                        else {//and if user enters product then it's saved in object of Shipper
                            Shipper shipper4 = new Shipper(Name_company, product);
                            rel_al.add(shipper4);//and adding into array of rel_al
                        }
                    }
                    System.out.println("============================");
                } else if (choose == 5) { //if user chooses Administration
                    System.out.println("Please, enter what type of product you want to register for Administration? (0 to stop)");
                    while (true) { //choosing product until 0 is entered
                        String product = scan.next();
                        if ((product.equals("0"))) { //if user enters 0, then user can choose next product
                            System.out.println("Select next department");
                            break;
                        }
                        else {//and if user enters product then it's saved in object of Shipper
                            Shipper shipper5 = new Shipper(Name_company, product);
                            admin.add(shipper5);//and adding into array of admin
                        }
                    }
                    System.out.println("============================");
                }
                if (choose == 0) {// if user stops selection of department with 0
                    break;
                }
            }
            System.out.println("Please, enter the price for the products of <<" + Name_company + ">>");
            int price = scan.nextInt();//entering price
            int price1 = price;//to increase price by dubbing
            price += (int) (price * perc); //increasing to % depending on which quality is chosen
            price += (int) (price1 * ln_perc);//increasing to % depending on how many languages chosen
            shipper.setPrice(price);//saving total price
            ArrayList<Integer> heads = new ArrayList<>();//to save employee_ids of
            // all head specialties of departments
            String dep = "SELECT * FROM employee where specialty = 'Subhead';";
            //selecting information about employee which is Subhead
            Statement st = con.createStatement();//statement to execute query
            ResultSet rs = st.executeQuery(dep);//execution of query//selecting
            if (rs.next()) {//if there's field with such values, outputs information of this employee
                System.out.println("Subhead " + rs.getString("First_name") + " " +
                        rs.getString("Last_name") +
                        " controls a work of employees who responsible for media part.");
                Integer sub = rs.getInt("employee_id"); //saving IDs of employee
                heads.add(sub);//adding into array employee ids
            }
            String dep1 = "SELECT * FROM employee WHERE specialty = 'Head of department'; ";
            //selecting information about employee which is Head of department
            Statement st1 = con.createStatement();//statement to execute query
            ResultSet rs1 = st1.executeQuery(dep1);//execution of query//selecting
            if (rs1.next()) {//if there's field with such values, outputs information of this employee
                System.out.println("Head of department " + rs1.getString("First_name") + " " +
                        rs1.getString("Last_name") +
                        " controls work of employees who responsible for security systems and mechanical systems.");
                Integer head = rs1.getInt("employee_id");//saving IDs of employee
                heads.add(head);//adding into array employee ids
            }
            String dep2 = "SELECT * FROM employee WHERE specialty = 'Head engineer'";
            //selecting information about employee which is Head engineer
            Statement st2 = con.createStatement();//statement to execute query
            ResultSet rs2 = st2.executeQuery(dep2);//execution of query//selecting
            if (rs2.next()) {//if there's field with such values, outputs information of this employee
                System.out.println("Head engineer " + rs2.getString("First_name") + " " +
                        rs2.getString("Last_name") +
                        " controls engineers' work who oversees technical problems");
                Integer eng = rs2.getInt("employee_id");//saving IDs of employee
                heads.add(eng);//adding into array employee ids
            }
            String dep3 = "SELECT * FROM employee WHERE specialty = 'Bookkeeper'; ";
            //selecting information about employee which is Bookkeeper
            Statement st3 = con.createStatement();//statement to execute query
            ResultSet rs3 = st3.executeQuery(dep3);//execution of query//selecting
            if (rs3.next()) {//if there's field with such values, outputs information of this employee
                System.out.println("Bookkeeper " + rs3.getString("First_name") + " " +
                        rs3.getString("Last_name") +
                        " controls employees' work who deal with the financial case");
                Integer book = rs3.getInt("employee_id");//saving IDs of employee
                heads.add(book);//adding into array employee ids
            }
            //these employees are those who deal with shippers (they control work of employees in departments)

            System.out.println("\nTotal price of this collaboration: " + price +
                    "\nDo you want to finish creating a relation? (Y/N)");
            String ans = scan.next();//user inputs answer
            if (ans.equals("YES") || ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes")) {
                //if enters yes, then all information will be inserted into database
                String sql = "INSERT INTO Shipper (Name_company, price) VALUES (?, ?)";
                //inserting into shipper company's name and price for products
                PreparedStatement ps = con.prepareStatement(sql);//prepared statement ot insert values
                ps.setString(1, shipper.getName_company());//setting values to first '?'
                ps.setInt(2, price);//to second '?'
                ps.execute();//execution of query
                for (Integer h : heads) {//to insert employees' ids using foreach with arraylist of ids
                    String ins = "insert into Shipper_details (shipper_id, employee_id) Values (?, ?)";
                    //query to insert
                    PreparedStatement prep = con.prepareStatement(ins);//prepared statement to insert
                    String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                    PreparedStatement prep1 = con.prepareStatement(sel);//prepared statement to select id of concrete company
                    prep1.setString(1, Name_company);//setting company name to '?'
                    ResultSet rss = prep1.executeQuery();//resultset to select
                    while (rss.next()) {//while there's field with such values
                        //setting to first and second '?' into Shipper_details
                        prep.setInt(1, rss.getInt("shipper_id"));
                        prep.setInt(2, h);
                    }
                    prep.execute();//to execute query
                }
                for (Shipper s : media) {
                    //to insert products of media into database using foreach with
                    // arraylist of Shipper's object with media products
                    for (String d : s.getDubbing()) {//and to insert dubbing languages of each media product
                        //using arraylist of dubbings in each media product
                        //getDubbing() returns arraylist of dubbing
                        String prod = "INSERT INTO product (shipper_id, products, quality, dubbing) VALUES(?, ?, ?, ?)";
                        PreparedStatement pr = con.prepareStatement(prod);//prepared statement to insert with setting into 'product'
                        String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                        PreparedStatement prep1 = con.prepareStatement(sel);//prepared statement to set company name for selection
                        prep1.setString(1, Name_company);//setting company name to '?'
                        ResultSet rss = prep1.executeQuery();//resultset to select id of company
                        while (rss.next()) {//while there's fields with such values
                            pr.setInt(1, rss.getInt("shipper_id"));
                            //setting shipper_id to first '?'
                            pr.setString(2,s.getProducts());
                            //setting product to second '?'
                            pr.setString(3,s.getQuality());
                            //setting quality to third '?'
                            pr.setString(4,d);
                            //setting dubbing to fourth '?'
                        }
                        pr.execute();//execution of query (insert)
                    }
                }
                for (Shipper s : worker) {//to insert products of worker into database using foreach with
                    // arraylist of Shipper's object with worker's products
                    String prod = "INSERT INTO product (shipper_id, products) VALUES(?, ?)";
                    //query to insert product of worker department
                    PreparedStatement pr = con.prepareStatement(prod); //prepared statement to insert with setting
                    String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                    PreparedStatement prep1 = con.prepareStatement(sel);
                    //prepared statement to set company name to select its shipper_id
                    prep1.setString(1, Name_company);//setting to '?' company name
                    ResultSet rss = prep1.executeQuery();//reusltset to select id
                    while (rss.next()) {//while there are fields with such values
                        pr.setInt(1, rss.getInt("shipper_id"));
                        //setting to first '?' shipper_id
                        pr.setString(2,s.getProducts());
                        //setting to second '?' product
                    }
                    pr.execute();//exeuction of query (insert)
                }
                for (Shipper s : tech) {//to insert products of technial department into database using foreach with
                    //arraylist of Shipper's object with technical department's products
                    String prod = "INSERT INTO product (shipper_id, products) VALUES(?, ?)";
                    //query to insert product of technical department
                    PreparedStatement pr = con.prepareStatement(prod);
                    //prepared statement to insert with setting
                    String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                    PreparedStatement prep1 = con.prepareStatement(sel);
                    //prepared statement to set company name to select its shipper_id
                    prep1.setString(1, Name_company);//setting to '?' company name
                    ResultSet rss = prep1.executeQuery();//resultset to select id
                    while (rss.next()) {//while there are fields with such values
                        pr.setInt(1, rss.getInt("shipper_id"));
                        //setting to first '?' shipper_id
                        pr.setString(2,s.getProducts());
                        //setting to second '?' product
                    }
                    pr.execute();//execution of query (insert)
                }
                for (Shipper s : rel_al) { //to insert products of release and analysis department into database using foreach with
                    //arraylist of Shipper's object with rel_al department's products
                    String prod = "INSERT INTO product (shipper_id, products) VALUES(?, ?)";
                    //query to insert product of rel_al department
                    PreparedStatement pr = con.prepareStatement(prod);
                    //prepared statement to insert with setting
                    String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                    PreparedStatement prep1 = con.prepareStatement(sel);
                    //prepared statement to set company name to select its shipper_id
                    prep1.setString(1, Name_company);//setting to '?' company name
                    ResultSet rss = prep1.executeQuery();//resultset to select id
                    while (rss.next()) {//while there are fields with such values
                        pr.setInt(1, rss.getInt("shipper_id"));
                        //setting to first '?' shipper_id
                        pr.setString(2,s.getProducts());
                        //setting to second '?' product
                    }
                    pr.execute();//execution of query (insert)
                }
                for (Shipper s : admin) { //to insert products of administration department into database using foreach with
                    //arraylist of Shipper's object with administration department's products
                    String prod = "INSERT INTO product (shipper_id, products) VALUES(?, ?)";
                    //query to insert product of admin department
                    PreparedStatement pr = con.prepareStatement(prod);
                    //prepared statement to insert with setting
                    String sel = "select shipper_id from Shipper where Name_company = ? ORDER BY shipper_id DESC LIMIT 1;";
                    PreparedStatement prep1 = con.prepareStatement(sel);
                    //prepared statement to set company name to select its shipper_id
                    prep1.setString(1, Name_company);//setting to '?' company name
                    ResultSet rss = prep1.executeQuery();//resultset to select id
                    while (rss.next()) {//while there are fields with such values
                        pr.setInt(1, rss.getInt("shipper_id"));
                        //setting to first '?' shipper_id
                        pr.setString(2,s.getProducts());
                        //setting to second '?' product
                    }
                    pr.execute();//execution of query (insert)
                }
                return true;//and because of users answer(yes) method will return yes(relation created)
            }
            else if (ans.equals("NO") || ans.equals("n") || ans.equals("N") || ans.equals("no") || ans.equals("No")){
                return  false;//if user answers no, relation will not be created (false)
            }
            else {
                System.out.println("Wrong input!"); //and if user inserts wrong answer relation will not be created
                return false;
            }
        } catch (SQLException throwables) { //if there are errors(exceptions) method returns false
            throwables.printStackTrace();
            System.out.println(throwables);
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close(); //closing connection to database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void GetAllRelation() { //method to show all relations of company
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            ArrayList<Shipper> shippers = new ArrayList<>();
            //arraylist of shipper where will be contained shipper ids
            String id = "select shipper_id from shipper";
            //query to select shipper_id
            Statement st = con.createStatement();//statement to execute
            ResultSet rs = st.executeQuery(id);//execution of query /selecting ids
            while(rs.next()) {//while there are fields in table
                Shipper shipper = new Shipper(rs.getInt("shipper_id"));//saving id in object of Shipper
                shippers.add(shipper);//adding into arraylist
            }
            for (Shipper s: shippers ) {//foreach to work with arraylist that contains shippers with ids
                String sel = "select * from shipper where shipper_id = " + s.getId();
                //query to select from values of shipper that have givin id from arraylist (s.getID())
                Statement stt = con.createStatement();//statement to execute query
                ResultSet rss = stt.executeQuery(sel);//execution of query / selecting
                while (rss.next()) {//while there are field with values infromation about shipper will be outputted
                    System.out.println(rss.getInt("shipper_id") + ". " + rss.getString("name_company") +
                            ", price: " + rss.getInt("price") );
                }
                System.out.println("With products: ");
                String sql = "select * from product where shipper_id = " + s.getId();
                //query to select product of shipper that have id - s.getID()
                Statement stt1 = con.createStatement();//statement to execute query
                ResultSet rss1 = stt1.executeQuery(sql);//execution of query / selecting
                int cnt = 0;//it used to print some information one time
                while (rss1.next()) {//while there are fields with values
                    if ((rss1.getString("quality") == null && rss1.getString("dubbing") == null)) {
                        //if quality and dubbing are null means that it is not product of media
                        System.out.print("\n" + rss1.getInt("shipper_id") + ". " +
                                rss1.getString("products") + ", ");
                        //will output only needed information, without dubbing and quality
                    }
                    else { //if quality and dubbing are not null, it means that it's products of media
                        if (cnt == 0) { //condition to print one time values of shipper below
                            System.out.print(rss1.getInt("shipper_id") + ". " + rss1.getString("products") +
                                    ", with quality: " + rss1.getString("quality") + ", with dubbing: " );
                            cnt++;//increment so that condition will work one time
                        }
                        System.out.print( rss1.getString("dubbing") + ", "); //printing dubbing languages
                    }
                }
                System.out.println();//new line after every shipper
            }
        } catch (SQLException throwables) { //to catch exceptions so that program will continue his work
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();//closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}