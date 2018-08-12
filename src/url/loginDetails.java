package url;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class loginDetails {

	ArrayList <logins> loginList;
	
	
public void configureUsers(Scanner reader) throws IOException, InterruptedException
{
	//Scanner reader; 
	String str;
	
	
	while(true)
	{
	System.out.println("0) Add user \n1) Delete user \n2) Change active user \n3) View users \n4) Show active user \nb) Back to main menu");

	
	str = reader.nextLine();
	
	
	if(str.equals("0"))
	{
		addUser(reader);

	}

	else if(str.equals("1"))
	{
		deleteUser(reader);

	}
	
	else if(str.equals("2"))
	{
		selectUser(reader);

	}
	
	
	else if(str.equals("3"))
	{
		viewUser();

	}
	
	else if(str.equals("4"))
	{
		logins Log = getActive();
		System.out.println(Log.getUsrname() + " " + Log.getPasswd() + "\n");
	}
	else if(str.toLowerCase().equals("b"))
	{
		
		return;
	}
	
	
	
	
	//System.out.println("0) Add user \n1) Delete user \n2) Change active user \n3) View users \nx) exit");
	
	
	}
	
}







private void selectUser(Scanner scan) throws IOException {
	
	
	File f = new File("logins.txt");

	String line, active;
	
	line = "";
	
	
	if(!f.exists())
	{
		
		System.out.println("must add users");
		scan.close();
		return;
	}
	

	 System.out.println("Select a user to be active: (b to go back)");
	 //int count = 0;

	 
	 while(!(line.toLowerCase().equals("b")))
	 {
		 ArrayList<logins> logList = getList();
		 
		 if(logList.equals(null)) {
			 System.out.println("Bad file");
		 }
		 
		 for(int n = 0; n< logList.size(); n++)
		 {
			 
			 active = logList.get(n).getActive().equals("1") ? "active" : "";
		 System.out.println(n +") " + logList.get(n).getUsrname() +" " + logList.get(n).getPasswd() + " " + active);
		 
		 }
		 
		 line = scan.nextLine();
		 
		 
		 
		 try {
			 logList.get(Integer.parseInt(line));
			 
			 for (int j = 0; j < logList.size(); j++)
			 {
				 logList.get(j).setActive("0");
				 
				 
			 }
			 
			 logList.get(Integer.parseInt(line)).setActive("1");
			 writeFile(logList);
	}
		 
		 
	catch(Exception e)
	{
		System.out.println("Bad Choice...");
	}
		 
	
	 }
	 
		 
	
	return;
	
}





public void deleteUser(Scanner scan) throws IOException {
	
	
	File f = new File("logins.txt");

	String line, active;
	 
	line = "";
	
	
	if(!f.exists())
	{
		
		System.out.println("must add users");
		scan.close();
		return;
	}
	

	 System.out.println("Select a user to be deleted: (b to go back)");
	 //int count = 0;

	 
	 while(!(line.toLowerCase().equals("b")))
	 {
		 ArrayList<logins> logList = getList();
		 
		 if(logList.equals(null)) {
			 System.out.println("Bad file");
		 }
		 
		 for(int n = 0; n< logList.size(); n++)
		 {
			 
			 active = logList.get(n).getActive().equals("1") ? "active" : "";
		 System.out.println(n +") " + logList.get(n).getUsrname() +" " + logList.get(n).getPasswd() + " " + active);
		 
		 }
		 
		 line = scan.nextLine();
		 
		 
		 
		 try {
			 logList.remove(Integer.parseInt(line));
			 
			 writeFile(logList);
	}
		 
		 
	catch(Exception e)
	{
		System.out.println("Bad Choice...");
		
		return;
		
	}
		 
	
	 }
	 
		 
	
	return;
	
}


private void writeFile(ArrayList<logins> logList) throws IOException {
	// TODO Auto-generated method stub
		
		File f = new File("logins.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		
			  
			  for (int n = 0; n< logList.size(); n++)
			  {
			 bw.write(logList.get(n).getUsrname() + " " + logList.get(n).getPasswd() + " " + logList.get(n).getActive() + '\r');
			 bw.newLine();
			  }
			  
			  
	bw.close();
	fw.close();
	return;
		
		
	
}


public void addUser(Scanner scan) throws IOException
	{
		
			String user, password;
			
			
			
			System.out.println("Enter user name:");
			user = scan.nextLine();
			
			
			
			System.out.println("Enter password:");
			password = scan.nextLine();
			
			logins login = new logins(user, password, "1");

		
			 
			 ArrayList<logins> active = getList();
				
			 if(active != null)
			 {
				for(int n = 0; n < active.size(); n++)
				{
					active.get(n).setActive("0");
					
				}
			 }
				active.add(login); //sets last user name and password to active.
				writeFile(active);
			 

	
	return;
	}
		







public ArrayList<logins>  getList() throws IOException{
	
	
	File f = new File("logins.txt");
	FileReader fr;
	BufferedReader br ;
	String line;
	
	
	if(!f.exists())
	{
		
		
		return new ArrayList<logins>();
	}
	
	 fr = new FileReader(f);
	 br  = new BufferedReader(fr);
	 
	 
	 
	 line = br.readLine();
	 line = line.trim();
	// System.out.println(line);
	 
	 
	 
	 
	// Scanner scan = new Scanner(System.in);

	 
	 ArrayList<logins> logList = new ArrayList<logins>();
	 
	 
	 while(!(line == null) )
	 {
		 
		
		 String[] splited = line.split("\\s+");
		
		 
		 
		 logList.add(new logins(splited[0], splited[1], splited[2]));
		 
		 line = br.readLine();
		 line = br.readLine();
		 if(line == null)
		 {
			 break;
		 }
		 
		 
		 line = line.trim();
		 
		 
	 }
	 
	 
	 
	 br.close();
	 fr.close();
	 //scan.close();
	return logList;
	
}
	
	
	
	
public void viewUser() throws IOException {
	
ArrayList<logins> logList = getList();
System.out.println(    "Username" + "  Password");



String active;
try {
	
for(int n = 0; n< logList.size(); n++) {
	
	
	active = logList.get(n).getActive().equals("1") ? "active" : "inactive";
	System.out.println(n + ") " + logList.get(n).getUsrname() + " " + logList.get(n).getPasswd() + " " + active);
}
System.out.println('\n');
	return;
}
	


catch (Exception e)
{
	System.out.println("empty" + "\n");
	return;
}

}

public logins getActive() throws IOException
{
	
	ArrayList<logins> active;
	active = getList();
	
	
	for(int n = 0; n< active.size(); n++)
	{
		
		if (active.get(n).getActive().equals("1"))
		{
			
			return (new logins(active.get(n).getUsrname(), active.get(n).getPasswd(),active.get(n).getActive()));
		}
		
	}
	return null;
	
}
	
	
	
}
	






class logins
{

	 
	 private String usrname;
	 private String passwd;
	 private String active;
	 
	 public logins(String usrname, String passwd, String active) {
		
		this.usrname = usrname;
		this.passwd = passwd;
		this.active = active;
	}


	public String getUsrname() {
		return usrname;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	 
	 
	 
	 
}