package url;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.nio.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class url {


// pictures must be stored at  c:\\users\root\desktop\laptops\"first two words of add title"\1.jpg 2.jpg 3.jpg 4.jpg 5.jpg
// will delete all ads on kijijji account, then post all ads stored in the xml file to kijiji under computers -> laptops
//


	private static String str = "";

	private static WebDriver cdriver;
	private static Random random = new Random();
	public static ArrayList<forsale> ads = new ArrayList<forsale>();
	public static ArrayList<forsale> postads;
	public static boolean adDeleted = false;
	public static int wait = 6;
	public boolean mintime = false;
	//sleeps for random time, + upto half a second, make it look random


	private static void sleeper (int base) throws InterruptedException
	{

		int r = random.nextInt(500) + 1;
		Thread.sleep(base + r);


	}



	static TimerTask task = new TimerTask()
	{

		@Override
		public void run() {
			if (str.equals(""))
			{
				System.out.println("Firefox is defaulted");
				try {
					bot("2");
				} catch (InterruptedException e) {

					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}		
	};


//checks if logged in, logs in, deletes ads, then post ads based on what is in the xml file

	public static void bot(String srt) throws InterruptedException, ParserConfigurationException, SAXException, IOException, URISyntaxException, AWTException
	{

		System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "\\" + "geckodriver.exe"));


		if (str.equals("1")) {
			cdriver = new ChromeDriver();
		}


		if (str.equals("2")) {
			cdriver = new FirefoxDriver();
		}
			
		else {
			System.exit(0);
		}



		//tester();

		cdriver.get("https://www.kijiji.ca/");
		sleeper(250);
		String Title = cdriver.getTitle();
		System.out.println(Title + " title");


		sleeper(4500);
		try {
			WebElement element = cdriver.findElement(By.xpath("//*[@id=\"MainContainer\"]/div[1]/div/header/div[3]/div[1]/div/div[2]/div/div[2]/a[2]"));
			element.click();


			cdriver.findElement(By.xpath("//*[@id=\"LoginEmailOrNickname\"]")).sendKeys("frederichenry070@gmail.com");
			cdriver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("qwerty");
			Thread.sleep(900);
			cdriver.findElement(By.xpath("//*[@id=\"SignInButton\"]")).click();

		}
		//<a href="/t-login.html" class="headerButtonAnonymousLink-2729586352" rel="nofollow" title="Sign In">Sign In</a>
		catch (Exception e)
		{

			System.out.println("already logged in");	
		}


		getads();

	}





//uploads pictures using keyboard input, nothing else works
	private static void tester(int i) throws ParserConfigurationException, SAXException, IOException, InterruptedException, URISyntaxException, AWTException {
		// TODO Auto-generated method stub
		Robot r = new Robot();
		//postads = xmldebuild();
		//cdriver.navigate().to("https://www.kijiji.ca/p-admarkt-post-ad.html?categoryId=773&adTitle=" + postads.get(0).getName());
		sleeper(2000);

		//postads = xmldebuild();


		String path = "C:\\Users\\root\\Desktop\\laptops\\";
		String fullpath;
		String title = postads.get(i).getName();
		String arr[] = title.split(" ");

		String firstWord = arr[0];   
		String secondWord = arr[1];


		//*[@id="ImageUploadButton"]

		try {
			File file = null;
			//file = new File(url.class.getClassLoader().getResource(path).toURI());
			r.delay(70);



			//sleeper(1000);

			//for(int x = 1; x <= 5; x++)
			//{		
				cdriver.findElement(By.xpath("//*[@id=\"ImageUploadButton\"]")).click();
				fullpath = "";
				title = "";	





//"1" "2" "3" "4" "5"

				title = firstWord.toLowerCase() + " " + secondWord.toLowerCase() + "\\\"1\" \"2\" \"3\" \"4\" \"5\""; // + (char) (x + '0') + ".jpg"; 
				fullpath = path.toLowerCase() + title;


				

				for (int j = 0; j < fullpath.length(); j++)
				{		
					keygenerator(fullpath.charAt(j));
					
				}


				System.out.println(fullpath);	
				Thread.sleep(1000);	
				r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
			
				r.keyRelease(KeyEvent.VK_ENTER);
				//System.out.println(path);	
				Thread.sleep(100);	
			
				r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
				
				r.keyRelease(KeyEvent.VK_ENTER);
				
			//}



		}

		catch (Exception e)
		{

			System.out.println(path);
			System.out.println("does not exist");
		}
		sleeper(45000);  //wait for images to upload


	}







//takes a lowercase char, then presses corresponding key.

	private static void keygenerator(char charAt) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		Robot r = new Robot();
		r.delay(100);

		switch (charAt) {

		case 'a': r.keyPress(KeyEvent.VK_A);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_A);
		break;

		case 'b':  r.keyPress(KeyEvent.VK_B);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_B);
		break; 

		case 'c':   r.keyPress(KeyEvent.VK_C);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_C);
		break;

		case 'd': r.keyPress(KeyEvent.VK_D);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_D);
		break;


		case 'e': r.keyPress(KeyEvent.VK_E);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_E);
		break;


		case 'f':   r.keyPress(KeyEvent.VK_F);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_F);
		break;

		case 'g':   r.keyPress(KeyEvent.VK_G);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_G);
		break;

		case 'h':   r.keyPress(KeyEvent.VK_H);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_H);
		break;

		case 'i':   r.keyPress(KeyEvent.VK_I);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_I);
		break;

		case 'j':   r.keyPress(KeyEvent.VK_J);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_J);
		break;

		case 'k':   r.keyPress(KeyEvent.VK_K);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_K);
		break;

		case 'l':   r.keyPress(KeyEvent.VK_L);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_L);
		break;

		case 'm':   r.keyPress(KeyEvent.VK_M);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_M);
		break;

		case 'n':   r.keyPress(KeyEvent.VK_N);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_N);
		break;

		case 'o':   r.keyPress(KeyEvent.VK_O);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_O);
		break;

		case 'p':   r.keyPress(KeyEvent.VK_P);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_P);
		break;

		case 'q':   r.keyPress(KeyEvent.VK_Q);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_Q);
		break;

		case 'r':   r.keyPress(KeyEvent.VK_R);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_R);
		break;

		case 's':   r.keyPress(KeyEvent.VK_S);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_S);
		break;

		case 't':   r.keyPress(KeyEvent.VK_T);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_T);
		break;

		case 'u':   r.keyPress(KeyEvent.VK_U);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_U);
		break;

		case 'v':   r.keyPress(KeyEvent.VK_V);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_V);
		break;

		case 'w':   r.keyPress(KeyEvent.VK_W);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_W);
		break;

		case 'x':   r.keyPress(KeyEvent.VK_X);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_X);
		break;

		case 'y':   r.keyPress(KeyEvent.VK_Y);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_Y);
		break;

		case 'z':   r.keyPress(KeyEvent.VK_Z);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_Z);
		break;

		case ' ':   r.keyPress(KeyEvent.VK_SPACE);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_SPACE);
		break; 

		case '\\':  r.keyPress(KeyEvent.VK_BACK_SLASH);    // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_BACK_SLASH);
		break;

		case ':':   r.keyPress(KeyEvent.VK_SHIFT);    // confirm by pressing Enter in the end
		r.keyPress(KeyEvent.VK_SEMICOLON);   // confirm by pressing Enter in the end
		r.keyRelease(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SHIFT); 
		break;

		case '.':	r.keyPress(KeyEvent.VK_PERIOD); 
		r.keyRelease(KeyEvent.VK_PERIOD); 
		break;	


		case '1':	r.keyPress(KeyEvent.VK_1); 
		r.keyRelease(KeyEvent.VK_1); 
		break;	

		case '2':	r.keyPress(KeyEvent.VK_2); 
		r.keyRelease(KeyEvent.VK_2); 
		break;	

		case '3':	r.keyPress(KeyEvent.VK_3); 
		r.keyRelease(KeyEvent.VK_3); 
		break;	

		case '4':	r.keyPress(KeyEvent.VK_4); 
		r.keyRelease(KeyEvent.VK_4); 
		break;	

		case '5':	r.keyPress(KeyEvent.VK_5); 
		r.keyRelease(KeyEvent.VK_5); 
		break;	

		case '6':	r.keyPress(KeyEvent.VK_6); 
		r.keyRelease(KeyEvent.VK_6); 
		break;	

		case '7':	r.keyPress(KeyEvent.VK_7); 
		r.keyRelease(KeyEvent.VK_7); 
		break;	

		case '8':	r.keyPress(KeyEvent.VK_8); 
		r.keyRelease(KeyEvent.VK_8); 
		break;	

		case '9':	r.keyPress(KeyEvent.VK_9); 
		r.keyRelease(KeyEvent.VK_9); 
		break;	

		case '0':	r.keyPress(KeyEvent.VK_0); 
		r.keyRelease(KeyEvent.VK_0); 
		break;
		
		case '"': r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_QUOTE);
		//Thread.sleep(100);
		r.keyRelease(KeyEvent.VK_QUOTE);
		r.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(80);
		break;	

	
		case '\n':
			r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
		
			r.keyRelease(KeyEvent.VK_ENTER);
			break;

		default : 
			System.out.println("bad keystoke input");
			break;


		}


	}


	
	
	//deletes ads until no ads left
	public static void getads() throws InterruptedException, ParserConfigurationException, SAXException, IOException, URISyntaxException, AWTException
	{
		int adsDeleted = 0;
		sleeper(500);
		cdriver.navigate().to("https://www.kijiji.ca/m-my-ads/active/1");

		try {
			while (true)
			{
				
				deleteads();
				adsDeleted++;
				cdriver.navigate().refresh();
				sleeper(2900);

			}

			//System.exit(0);
		}

		catch (Exception e){
			if (adsDeleted >= 1)
				adDeleted = true;

			System.out.println("no ads left");

		}


		postads();


	}







//deletes the first ad on the page
	private static void deleteads() throws InterruptedException {

		sleeper(1500);
		
		
		try {
		String path = "/html/body/div[3]/div[4]/div/div/div/div[3]/ul/li[1]/div[2]/div/ul/li[2]/button";
		//String path = "//*[@id="MainContainer"]/div[4]/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button";
		cdriver.findElement(By.xpath(path)).click();
		sleeper(600);
		}
		
		catch (Exception e)
		{
			String path = "/html/body/div[3]/div[4]/div/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button";
			//String path = "//*[@id="MainContainer"]/div[4]/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button";
			cdriver.findElement(By.xpath(path)).click();
			sleeper(600);
			
			
		}
		
		return;
///html/body/div[3]/div[4]/div/div/div/div[3]/ul/li[1]/div[2]/div/ul/li[2]/button
///html/body/div[3]/div[4]/div/div/div/div[3]/ul/li[2]/div[2]/div/ul/li[2]/button
		
		
		
		///html/body/div[3]/div[4]/div/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button
		///html/body/div[3]/div[4]/div/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button
       //delete multiple ads generate xpath
		///html/body/div[3]/div[4]/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button

		//String buttonLocator = "//*[@id=\"MainContainer\"]/div[4]/div/div/div[3]/ul/li" + "[" + n + "]" + "/div[2]/div/ul/li[2]/button";
		//  second add  //*[@id="MainContainer"]/div[4]/div/div/div[3]/ul/li[2]/div[2]/div/ul/li[2]/button


		//theoreitcally do multiple ads at once
		//int n = 1;
		//deletePath(n);

	}

	
//posts ads for each element in xml file, ignores inactive ads
	private static void postads() throws InterruptedException, ParserConfigurationException, SAXException, IOException, URISyntaxException, AWTException {
		

		postads = xmldebuild(0);
		Collections.shuffle(postads);   //randomizes the order
		for(int i = 0; i < postads.size(); i++)
		{
			
			if(postads.get(i).getActive() != 0)
			{
			////*[@id="AdTitleForm"] //*[@id="AdTitleForm"]
			///html/body/div[3]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/button
				keygenerator('\n');
				
			cdriver.navigate().to("https://www.kijiji.ca/p-admarkt-post-ad.html?categoryId=773&adTitle=" + postads.get(i).getName());
			sleeper(3500);



			//*[@id="PriceAmount"]
			
for (int n = 0; n<4; n++)
{
           try {
        	
			cdriver.findElement(By.xpath("//*[@id=\"PriceAmount\"]")).sendKeys(postads.get(i).getPrice());
			sleeper(300);
			break;
           }
           catch (Exception e)
           {
        	   sleeper(300);
        	   if (n>= 4)
        	   {//System.exit(0);
        	   }
           }
}

for (int n = 0; n<4; n++)
{
           try {
        	
        	   cdriver.findElement(By.xpath("//*[@id=\"pstad-descrptn\"]")).sendKeys(postads.get(i).getDesc());
       			sleeper(300);
			break;
           }
           catch (Exception e)
           {
        	   sleeper(300);
        	   if (n>= 4)
        	   {//System.exit(0);
        	   }
           }
}
			//cdriver.findElement(By.xpath("//*[@id=\"pstad-descrptn\"]")).sendKeys(postads.get(i).getDesc());
			sleeper(300);
			
			//*[@id="pstad-descrptn"]
			
			//*[@id="PostalCode"]
	
			try {
				
				
				cdriver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys(postads.get(i).getZip());
				sleeper(600);
				cdriver.findElement(By.xpath("//*[@id=\"downshift-1-item-0\"]")).click();
			
			
			
			
			}
			
			catch(Exception e)
			{
				try {
					
					cdriver.findElement(By.xpath("//*[@id=\"PostalCode\"]")).sendKeys(postads.get(i).getZip());
					sleeper(600);
				}
				
				
				catch(Exception e1)
				{
					
					System.out.println("Incorrect postal code configuration, or postal code already entered");
					//throw new Exception();
				}				
			}
			
			
			
			
			
			
			// watch 
			cdriver.findElement(By.xpath("//*[@id=\"MainForm\"]/div[3]/ul/li[6]/div/label[1]/label")).click();
			sleeper(600);





			cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]")).click();
			sleeper(500);

			switch (postads.get(i).getBrand().toLowerCase()) {



			case "acer": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[2]")).click();
			break;

			case "apple": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[3]")).click();
			break;

			case "asus": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[4]")).click();
			break;

			case "compac": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[5]")).click();
			break;

			case "dell": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[6]")).click();
			break;

			case "gateway": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[7]")).click();
			break;

			case "hp": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[8]")).click();
			break;

			case "lenovo": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[9]")).click();
			break;

			case "samsung": cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[10]")).click();
			break;

			case "sony" : cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[11]")).click();
			break;

			case "toshiba" : cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[12]")).click();
			//dropdown12.selectByVisibleText("Toshiba");
			break;

			default: cdriver.findElement(By.xpath("//*[@id=\"laptopbrand_s\"]/option[13]")).click();
			//dropdown13.selectByVisibleText("Other");
			break;

			//drop downs
			}


			cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]")).click();
			sleeper(500);

			switch (postads.get(i).getSize()) {



			case "14": cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]/option[2]")).click();
			break;
			case "15": cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]/option[3]")).click();
			break;
			case "16":	cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]/option[4]")).click();
			break;
			case "17":	cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]/option[5]")).click();
			break;

			default:   cdriver.findElement(By.xpath("//*[@id=\"laptopscreensize_s\"]/option[3]")).click();
			break;
			}
			sleeper(400);



			//images
			tester(i);
			sleeper(40000);


			if (adDeleted)   //if ads were deleted, then must wait to post
				sleeper(60000 * wait);  //6 ish mins of waiting to post

			//post add
			
			cdriver.findElement(By.xpath("//*[@id=\"MainForm\"]/div[8]/button[1]")).click();
			
			//  postal code cdriver.findElement(By.xpath("//*[@id=\"downshift-1-item-0\"]")).click();
			
			////*[@id="MainForm"]/div[8]/button[1]
			////*[@id="PostAdPreview"]
			////*[@id="MainForm"]/div[8]/button[1]
		}	
		}
	}


	
	//generates xpath for ad n
	private static String deletePath(int n) {

		if (n == 1)
			return "//*[@id=\"MainContainer\"]/div[4]/div/div/div[3]/ul/li/div[2]/div/ul/li[2]/button";


		else

			return "//*[@id=\"MainContainer\"]/div[4]/div/div/div[3]/ul/li" + "[" + (n) + "]" + "/div[2]/div/ul/li[2]/button";

	}


	public static void main (String args[]) throws InterruptedException, ParserConfigurationException, TransformerException, SAXException, IOException, URISyntaxException, AWTException
	{

		Scanner reader = new Scanner(System.in);
		
		

		System.out.println("0) Delete ads \n1) Create another ad \n2) Create all ads \n3) View ads \n4) Post \n5) Toggle active ads");
		str = reader.nextLine();
		
		while(!str.equals("4"))
			
		{	
		if(str.equals("2"))
		{
			xmlbuilder();

		}

		else if(str.equals("3"))
		{
			xmldebuild(1);

		}
		
		else if(str.equals("1"))
		{
			insertadd();

		}
		
		else if(str.equals("0"))
		{
			try {
			xmldelete();
			}
			
			catch (Exception e)
			{
				System.out.println("Bad Choice!!!!");
			}
		}
		
		
		else if(str.equals("5"))
		{
			
			try {
				changeactive();
				}
				
				catch (Exception e)
				{
					System.out.println("Bad Choice!!!!");
				}
		}
		
		System.out.println("0) Delete ads \n1) Create another ad \n2) Create all ads \n3) View ads \n4) Post \n5) Toggle active ads");
		str = reader.nextLine();
		
		}

	/*	Timer timer = new Timer();
		timer.schedule(task, 2000);


		System.out.println("\n\n1) Chrome \n2) Firefox \n");
		str = reader.nextLine(); // Scans the next token of the input as an int.




		while( !(str.equals("1") || str.equals("2") ||  str.equals("3") || str.equals("4") || str.equals("5"))) 
		{
			System.out.println("bad choice");
			str = reader.nextLine();		

		}

		timer.cancel();

		//once finished */
		reader.close();

		System.out.println("Running");
		try {


			System.out.println("Working Directory = " +
					System.getProperty("user.dir"));

			/*	

	    URL myURL = new URL("https://www.kijiji.ca/");
	    URLConnection myURLConnection = myURL.openConnection();
	    //myURLConnection.connect();
	            BufferedReader in = new BufferedReader(
	            new InputStreamReader(myURL.openStream()));

	            String inputLine;
	            while ((inputLine = in.readLine()) != null)
	                System.out.println(inputLine);
	            in.close();
			 */
		} 

		catch (Exception e)
		{
			System.out.println("not found");
		}

str = "2";
		bot ("2");


		//cdriver.quit();

	}


	private static void changeactive() throws SAXException, IOException, ParserConfigurationException, TransformerException
	{
		
		
		ArrayList<forsale> getads = new ArrayList<forsale>();
		String input = "";
		System.out.println("Select an ad to toggle, \"b\" to exit");
		
		while(!input.toLowerCase().equals("b"))
		{
			
		try {File fXmlFile = new File("laptops.xml"); }

		catch(Exception e)
		{
			System.out.println("\nmust create ads first");
			System.exit(0);
		}

		File fXmlFile = new File("laptops.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);


		doc.getDocumentElement().normalize();


		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("Laptop");
		
		
		
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			
			
			Node nNode = nList.item(temp);
			
			
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				
				
				
				
				NodeList childs = eElement.getChildNodes();
		
				
				if (Integer.parseInt(childs.item(5).getTextContent()) != 0)
						{
					System.out.println(temp + ") " + eElement.getAttribute("identity") + " is active: " );
						}
				
				
				else if (Integer.parseInt(childs.item(5).getTextContent()) == 0)
				{
					System.out.println(temp + ") " + eElement.getAttribute("identity") + " is inactive: " );
				}
			
			
			
		}
	
		}
		
		
		Scanner reader = new Scanner(System.in);
		 input = reader.nextLine();
		
		if(!input.toLowerCase().equals("b")) {
		
		int test = Integer.parseInt(input);
		
		//Node parent = nList.item(test).getParentNode();
		
		//parent.removeChild(nList.item(test));
		
		
		postads = xmldebuild(0);
		
		if (postads.get(test).getActive() != 0)
		postads.get(test).setActive(0);
		
		
		else 
			if (postads.get(test).getActive() == 0)
				postads.get(test).setActive(1);
		
		
		ads = postads;
		xmlwriter();
		
		}
	
		}
		
	}
	
	private static void xmldelete() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
		
		ArrayList<forsale> getads = new ArrayList<forsale>();
		String input = "";
		System.out.println("Please select an ad to delete, \"b\" to exit");
		
		while(!input.toLowerCase().equals("b"))
		{
		
		try {File fXmlFile = new File("laptops.xml"); }

		catch(Exception e)
		{
			System.out.println("\nmust create ads first");
			System.exit(0);
		}

		File fXmlFile = new File("laptops.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);


		doc.getDocumentElement().normalize();


		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("Laptop");
		
		
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			
			
			Node nNode = nList.item(temp);
			
			
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				
				
				
			System.out.println(temp + ") " + eElement.getAttribute("identity"));
			
			
			
		}
	}
		
		
		
		Scanner reader = new Scanner(System.in);
		input = reader.nextLine();
		
		
		if(!input.toLowerCase().equals("b"))
		{
		int test = Integer.parseInt(input);
		
		Node parent = nList.item(test).getParentNode();
		
		parent.removeChild(nList.item(test));
		
		
		postads = xmldebuild(0);
		postads.remove(test);
		ads = postads;
		xmlwriter();
		
		}
	}
	}
	


	
	
	


	//populates getads with instances of 'forsale' objects in xml file
	private static ArrayList<forsale> xmldebuild(int n) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		ArrayList<forsale> getads = new ArrayList<forsale>();

		try {File fXmlFile = new File("laptops.xml"); }

		catch(Exception e)
		{
			System.out.println("\nmust create ads first");
			System.exit(0);
		}

		File fXmlFile = new File("laptops.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);


		doc.getDocumentElement().normalize();

		if(n == 1)
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("Laptop");



		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			
			if(n == 1)
			System.out.println("\nCurrent Element :" + nNode.getNodeName());



			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				
				if(n == 1)
				System.out.println("Laptop identity: " + eElement.getAttribute("identity"));




				String price = eElement.getElementsByTagName("price").item(0).getTextContent();
				
				if(n == 1)
				System.out.println("Laptop price : " + eElement.getElementsByTagName("price").item(0).getTextContent());

				//String brand = eElement.getElementsByTagName("brand").item(0).getTextContent();
				//System.out.println("Brand : " + eElement.getElementsByTagName("brand").item(0).getTextContent());

				String size = eElement.getElementsByTagName("size").item(0).getTextContent();
				
				if(n == 1)
				System.out.println("Size : " + eElement.getElementsByTagName("size").item(0).getTextContent());



				String name = eElement.getElementsByTagName("name").item(0).getTextContent();
				
				if(n == 1)
				System.out.println("Laptop name : " + eElement.getElementsByTagName("name").item(0).getTextContent());


				String desc = eElement.getElementsByTagName("description").item(0).getTextContent();
				
				if(n == 1)
				System.out.println("Laptop description : " + eElement.getElementsByTagName("description").item(0).getTextContent());

				String zip = eElement.getElementsByTagName("zip").item(0).getTextContent();
				
				if(n == 1)
				System.out.println("Postal Code : " + eElement.getElementsByTagName("zip").item(0).getTextContent());

				
				
				
				String active = "1";
				try {
				 active = eElement.getElementsByTagName("active").item(0).getTextContent();
				
				
				
				if(n == 1)
				System.out.println("Active : " + eElement.getElementsByTagName("active").item(0).getTextContent());

				}
				
				
				catch (Exception e )
				{
					active = "1";
				}
				
				
				forsale add = new forsale(name, desc, price, zip, size, Integer.parseInt(active));
				
				
				
				getads.add(add);
				if(n == 1)
				System.out.println("------------------------------------------------------------------------------\n\n");
			}



		}
		if(n == 1)
		System.out.println("\n\n------------------------------------------------------");
		return getads;
	}


	
	//creates + overwrites xml file with new data, simply reads data from user to create a list of forsale objects
	private static void xmlbuilder() throws ParserConfigurationException, TransformerException {
		String name = "";
		String desc = "";
		String price = "";
		String zip = "";
		String temp = "";
		String size = "";
		int count = 1;

		while(true)
		{
			name = "";
			desc = "";
			price = "";
			zip = "";
			temp = "";
			size = "";
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Ad title..... \n");

			name = reader.nextLine();

			System.out.println("Description..... \nmust end in OBO\n");

			while (reader.hasNext())
			{
				temp = reader.nextLine();
				desc = desc + temp + '\n';

				if (desc.contains("OBO"))
					break;

			}

			System.out.println("Price..... \n");

			price = reader.nextLine();

			System.out.println("Postal Code..... \n");
			zip = reader.nextLine();


			System.out.println("Screen size.... 14 / 15 / 16 / 17\n");
			size  = reader.nextLine();



			forsale fors = new forsale(name, desc, price, zip, size, 1);
			fors.print();

			ads.add(fors);

			System.out.println("\nWould you like to make another add? y/n \n");

			if (reader.nextLine().toLowerCase().equals("n") )
			{

				break;
			}


			System.out.println( "Creating add #" + (count + 1) + '\n' );
			count++;

		}



		xmlwriter();


	}


	//writes xml file based on contents of list of  forsale object ads
	private static void xmlwriter() throws ParserConfigurationException, TransformerException {


		DocumentBuilderFactory docRoot= DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docRoot.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("ads");
		doc.appendChild(rootElement);




		for (int n = 0; n < ads.size(); n++)
		{


			Element id = doc.createElement("Laptop");
			rootElement.appendChild(id);

			Attr attr = doc.createAttribute("identity");
			attr.setValue(ads.get(n).getPics());
			id.setAttributeNode(attr);





			Element price = doc.createElement("price");
			price.appendChild(doc.createTextNode(ads.get(n).getPrice()));
			id.appendChild(price);


			Element size = doc.createElement("size");
			size.appendChild(doc.createTextNode(ads.get(n).getSize()));
			id.appendChild(size);

			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(ads.get(n).getName()));
			id.appendChild(name);

			Element desc = doc.createElement("description");
			desc.appendChild(doc.createTextNode(ads.get(n).getDesc()));
			id.appendChild(desc);

			Element zip = doc.createElement("zip");
			zip.appendChild(doc.createTextNode(ads.get(n).getZip()));
			id.appendChild(zip);

			Element active = doc.createElement("active");
			active.appendChild(doc.createTextNode(String.valueOf(ads.get(n).getActive())));
			id.appendChild(active);


		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(("laptops.xml")));

		transformer.transform(source, result);

	}

	
	public static void insertadd() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		
		String name = "";
		String desc = "";
		String price = "";
		String zip = "";
		String temp = "";
		String size = "";
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Ad title..... \n");

		name = reader.nextLine();

		System.out.println("Description..... \nmust end in OBO\n");

		while (reader.hasNext())
		{
			temp = reader.nextLine();
			desc = desc + temp + '\n';

			if (desc.contains("OBO"))
				break;

		}

		System.out.println("Price..... \n");

		price = reader.nextLine();

		System.out.println("Postal Code..... \n");
		zip = reader.nextLine();


		System.out.println("Screen size.... 14 / 15 / 16 / 17\n");
		size  = reader.nextLine();



		forsale fors = new forsale(name, desc, price, zip, size, 1);
		
		
		postads = xmldebuild(0);
		postads.add(fors);
		
		ads = postads;
		xmlwriter();
		
	}

}
