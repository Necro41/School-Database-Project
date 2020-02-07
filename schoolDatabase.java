import java.sql.*;
import java.util.Scanner;

public class schoolDatabase {

public static void main(String[]args){
	
   //scanner objects
   Scanner s = new Scanner(System.in);
   Scanner b = new Scanner(System.in);
   Scanner a = new Scanner(System.in);
   Scanner action = new Scanner(System.in);
	Connection conn = null;
	
   //connection
   try {
    	conn =
       DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_eherna41?serverTimezone=UTC&" +
                                   "user=db_Spr19_eherna41&password=eherna41");

   //object to create statements
	Statement stmt = conn.createStatement();
   
   int sel;
   String act = "";
   String act2 = "";
   
   while (!act.equals("E"))
   {
      //menu to select table and choose action
      System.out.println("Please Select The Desired Table Number");
      System.out.println("Enter 1 for the Teacher table");
      System.out.println("Enter 2 for the Student table");
      System.out.println("Enter 3 for the Course table");
      System.out.println("Enter 4 for the Loans table");
      System.out.print("Enter Selection: ");
      sel = b.nextInt();
      System.out.println();
      System.out.println("Choose an action:");
      
      System.out.print("[I]nsert, [S]elect or enter E to exit: ");
      act = action.nextLine();
      System.out.println();
      //end of menu selection
      
      //if condition for insertion into the Teacher table
      if (sel == 1 && (act.equals("I") || act.equals("Insert") || act.equals("insert") || act.equals("i")))
      {
            System.out.print("Enter the professor's ID: ");
            int profID = s.nextInt();
         
            System.out.print("Enter the professor's first name: ");
            String profFirstName = a.nextLine();
            
            System.out.print("Enter the professor's last name: ");
            String profLastName = a.nextLine();
            
            System.out.print("Enter the course ID the professor is teaching: ");
            int courseID = s.nextInt();
   
            String sq1 = "INSERT INTO Teacher VALUES (" + profID+", '" + profFirstName + "', '" + profLastName +"', " + courseID + ")";
            stmt.executeUpdate(sq1);
         
            System.out.println();
            
            System.out.println("The data has been inserted.");            
            System.out.println();
      }
      //if condition for insertion into the Student table
      if (sel == 2 && (act.equals("I") || act.equals("Insert") || act.equals("insert") || act.equals("i")))
      {
            System.out.print("Enter the student's ID: ");
            int studentID = s.nextInt();
         
            System.out.print("Enter the student's first name: ");
            String studentFirstName = a.nextLine();
            
            System.out.print("Enter the student's last name: ");
            String studentLastName = a.nextLine();
            
            System.out.print("If the student is taking a course enter the course ID otherwise enter 0: ");
            int courseID = s.nextInt();
            
            System.out.print("Enter the student's debt ID or enter 0 if no debt: ");
            int debtID = s.nextInt();
            
            System.out.print("Enter the student's registration status (NR = Not Registered, CR = Currently Registered): ");
            String regStatus = a.nextLine();
            
            System.out.print("Enter the student's class standing (i.e. sophomore): ");
            String classStanding = a.nextLine();
            
   
            String sq1 = "INSERT INTO Student VALUES (" + studentID+", '" + studentFirstName + "', '" + studentFirstName + "'," + courseID + "," + debtID + ",'"+ regStatus + "', '" + classStanding + "')";
            stmt.executeUpdate(sq1);
         
            System.out.println();
            
            System.out.println("The data has been inserted.");
            System.out.println();
      }
      //if condition for insertion into the Course table
      if (sel == 3 && (act.equals("I") || act.equals("Insert") || act.equals("insert") || act.equals("i")))
      {
            System.out.print("Enter the course ID: ");
            int courseID = s.nextInt();
         
            System.out.print("Enter the course name: ");
            String courseName = a.nextLine();
   
            String sq1 = "INSERT INTO Course VALUES (" + courseID+", '" + courseName +"')";
            stmt.executeUpdate(sq1);
         
            System.out.println();
            
            System.out.println("The data has been inserted.");
            System.out.println();
      }
      //if condition for insertion into the Loans table.
      if (sel == 4 && (act.equals("I") || act.equals("Insert") || act.equals("insert") || act.equals("i")))
      {
            System.out.print("Enter the debt ID: ");
            int debtID = s.nextInt();
         
            System.out.print("Enter amount owed: ");
            double amountOwed = s.nextDouble();
   
            String sq1 = "INSERT INTO Loans VALUES (" + debtID+", '" + amountOwed +"')";
            stmt.executeUpdate(sq1);
         
            System.out.println();
            
            System.out.println("The data has been inserted.");
            System.out.println();
      }
      
      //if condition for the select feature of the Teacher table
      if (sel == 1 && (act.equals("S") || act.equals("Select") || act.equals("select") || act.equals("s")))
      {
         //create string and result set to initialize select
         String sq1 = "SELECT * FROM Teacher";
         ResultSet rs = stmt.executeQuery(sq1);
         
         //while loop to execute select
         while(rs.next())
         {
            //retrieval by column name
            String profFirstName = rs.getString("profFirstName");
            String profLastName = rs.getString("profLastName");
            int profID = rs.getInt("profID");
            int courseID = rs.getInt("courseID");
            //the actual display
            System.out.print(" | Professor's ID: " + profID);
            System.out.print(" | Professor's Full Name: " + profFirstName + " " + profLastName);
            System.out.print(" | Course Taught:  " + courseID);
         }
      rs.close();
      System.out.println();
      }
      //if condition for the select feature of the Student table
      if (sel == 2 && (act.equals("S") || act.equals("Select") || act.equals("select") || act.equals("s")))
      {
         //create string and result set to initialize select
         String sq1 = "SELECT * FROM Student";
         ResultSet rs = stmt.executeQuery(sq1);
         
         //while loop to execute select
         while(rs.next())
         {
            //retrieval by column name
            int studentID = rs.getInt("studentID");
            String studentFirstName = rs.getString("studentFirstName");
            String studentLastName = rs.getString("studentLastName");
            int courseID = rs.getInt("courseID");
            int debtID = rs.getInt("debtID");
            String regStatus = rs.getString("regStatus");
            String classStanding = rs.getString("classStanding");
            //the actual display
            System.out.print(" |Student ID: " + studentID);
            System.out.print(" | Student Full Name: " + studentFirstName + " " + studentLastName);
            System.out.print(" | Course Currently Taking: " + courseID);
            System.out.print(" | Debt ID: " + debtID);     
            System.out.print(" | Registration Status: " + regStatus);
            System.out.println(" | Class Standing: " + classStanding);
         }
      rs.close();
      System.out.println();
      }
      //if condition for the select feature of the Course table
      if (sel == 3 && (act.equals("S") || act.equals("Select") || act.equals("select") || act.equals("s")))
      {
         //create string and result set to initialize select
         String sq1 = "SELECT * FROM Course";
         ResultSet rs = stmt.executeQuery(sq1);
         
         //while loop to execute select
         while(rs.next())
         {
            //retrieval by column name
            int courseID = rs.getInt("courseID");
            String courseName = rs.getString("courseName");
            //the actual display
            System.out.print(" | Course ID: " + courseID);
            System.out.println(" | Course Name: " + courseName);
         }
      rs.close();
      System.out.println();
      }
      //if condition for the select feature of the Loans table
      if (sel == 4 && (act.equals("S") || act.equals("Select") || act.equals("select") || act.equals("s")))
      {
         //action if user wants to join two tables
         System.out.print("Press Y if you would like to join the Student table and the Loans table to see which students have debt or press N to continue: ");
         act2 = action.nextLine();
         
         //if condition for joining
         if(act2.equals("Y"))
         {
            String sq1 = "SELECT StudentID, studentFirstName, studentLastName, s.debtID, amountOwed FROM Student s, Loans l WHERE s.debtID = l.debtID AND l.amountOwed > 0";
            ResultSet rs = stmt.executeQuery(sq1);
            
            while(rs.next())
            { 
               //retrieval by column name
               int studentID = rs.getInt("studentID");
               String studentFirstName = rs.getString("studentFirstName");
               String studentLastName = rs.getString("studentLastName");
               int debtID = rs.getInt("debtID");
               double amountOwed = rs.getDouble("amountOwed");
               //the actual display
               System.out.print(" | Student ID: " + studentID);
               System.out.print(" | Student Full Name: " + studentFirstName + " " + studentLastName);
               System.out.print(" | Debt ID: " + debtID);
               System.out.println(" | Amount Owed: " + amountOwed);
            }
         rs.close();
         System.out.println();
         }
         else
         {
            //create string and result set to initialize select
            String sq1 = "SELECT * FROM Loans";
            ResultSet rs = stmt.executeQuery(sq1);
            
            //while loop to execute select
            while(rs.next())
            {
               //retrieval by column name
               int debtID = rs.getInt("debtID");
               double amountOwed = rs.getDouble("amountOwed");
               //the actual display
               System.out.print(" |Debt ID: " + debtID);
               System.out.println(" | Amount Owed: " + amountOwed);
            }
         rs.close();
         System.out.println();
         }
      }
      
      System.out.println();
      if(!act.equals("E"))
      {
         System.out.print("Enter E if you would like to stop or C to continue: ");
         act = action.nextLine();
      }
      System.out.println();
      }
      
      System.out.println("Thank you for using my database program!");
      } 
      
       catch (SQLException ex) {
       // handle any errors
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
       System.out.println("VendorError: " + ex.getErrorCode());
	   }  
} 
}       