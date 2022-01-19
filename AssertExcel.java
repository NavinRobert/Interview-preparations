package org.base;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AssertExcel extends BaseClass{

		@BeforeClass
		public static void beforClass() {
			getDriver();
			loadUrl("http://adactinhotelapp.com/");
			maximize();
		}
		@AfterClass
		public static void afterClass() {
			//quiting();
		}
		
		@Before
		public void before() {
			
		}
		@After
		public void after() {
			
		}
		
		@Test
		public void testCase() throws IOException, InterruptedException {
		WebElement textUsername = locationId("username");
		String textuserfile = fileHandle("Sheet2",0,0);
		sendingText(textUsername, textuserfile);
			
		WebElement textPassword = locationId("password");
		String textpassfile = fileHandle("Sheet2",1,0);
		sendingText(textPassword, textpassfile);
		
		WebElement loginButton = locationId("login");
		click(loginButton);
		
		WebElement searchhotel = locationClassName("login_title");
		String text = gettext(searchhotel);
		assertEquals("Verifying search by hotel", "Search Hotel (Fields marked with Red asterix (*) are mandatory)",text);
		
		WebElement location = locationId("location");
		String locate = fileHandle("Sheet2",1,1);
		selectByValue(location, locate);
		
		WebElement hotel = locationId("hotels");
		String hot = fileHandle("Sheet2",1,2);
		sendingText(hotel, hot);
		
		WebElement roomtype = locationId("room_type");
		String room =fileHandle("Sheet2",1,3);
		sendingText(roomtype, room);
		
		WebElement submit = locationId("Submit");
		click(submit);
		
		WebElement radio = locationId("radiobutton_0");
		click(radio);
		
		WebElement selecthot = locationClassName("login_title");
		String sel = gettext(selecthot);
		assertEquals("Verifying search by hotel", "Select Hotel",sel);
		
		WebElement conti = locationId("continue");
		click(conti);
		
		WebElement bookhotel = xyzPath("//td[text()='Book A Hotel ']");
		String boho = gettext(bookhotel);
		assertEquals("Verifying search by hotel","Book A Hotel",boho);
		 
		WebElement first =locationId("first_name");
		String fir = fileHandle("Sheet2",1,4);
		sendingText(first, fir);
		
		WebElement last = locationId("last_name");
		String lastname = fileHandle("Sheet2", 1, 5);
		sendingText(last, lastname);
		
		WebElement addr = locationId("address");
		String addres = fileHandle("Sheet2", 1, 6);
		sendingText(addr, addres);
		
		WebElement credit = locationId("cc_num");
		String card = fileHandle("Sheet2", 1, 7);
		sendingText(credit, card);
		
		WebElement cardtype = locationId("cc_type");
		String ctype = fileHandle("Sheet2", 1, 8);
		sendingText(cardtype, ctype);
		
		WebElement exdate = locationId("cc_exp_month");
		String expirydate = fileHandle("Sheet2", 1, 9);
		sendingText(exdate, expirydate);
		
		WebElement exyear = locationId("cc_exp_year");
		String expiryyear = fileHandle("Sheet2", 1, 10);
		sendingText(exyear, expiryyear);
		
		WebElement cvv = locationId("cc_cvv");
		String cvvyear = fileHandle("Sheet2", 1, 11);
		sendingText(cvv, cvvyear);
		
		WebElement book1 = locationId("book_now");
		click(book1);
		Thread.sleep(8000);
		
		WebElement confirmation = locationClassName("login_title");
		String gettext = gettext(confirmation);
		assertEquals("Verifying the confirmation", "Booking Confirmation",gettext);
		
		WebElement ord = locationId("order_no");
		String order = getAttri(ord);
		sendDataToExcel("Sheet2", 1, 12,order);
		
		WebElement iter = locationId("my_itinerary");
		click(iter);
		
		Thread.sleep(6000);
		
		WebElement canc = xyzPath("//input[contains(@value,'Cancel')]");
		click(canc);
		
		alertaccept();
		
		WebElement cancelled = locationClassName("login_title");
		String can = gettext(cancelled);
		assertEquals("Verifying", "Booked Itinerary", can);
		
		
		WebElement printtoexcel = locationClassName("reg_error");
		String texttoex = gettext(printtoexcel);
		sendDataToExcel("Sheet2", 1, 13, texttoex);
		System.out.println("done.......");

		
	}

}