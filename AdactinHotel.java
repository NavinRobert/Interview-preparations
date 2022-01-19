package org.base;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class AdactinHotel {

	public static void main(String[] args) throws IOException, InterruptedException {
	BaseClass b = new BaseClass();
	b.getDriver();
	b.maximize();

	b.loadUrl("http://adactinhotelapp.com/");
	WebElement textUsername = b.locationId("username");
	String textuserfile = b.fileHandle("Sheet2",0,0);
	b.sendingText(textUsername, textuserfile);
	
	WebElement textPassword = b.locationId("password");
	String textpassfile = b.fileHandle("Sheet2",1,0);
	b.sendingText(textPassword, textpassfile);
	
	WebElement loginButton = b.locationId("login");
	b.click(loginButton);
	
	WebElement location = b.locationId("location");
	String locate = b.fileHandle("Sheet2",1,1);
	b.selectByValue(location, locate);
	
	WebElement hotel = b.locationId("hotels");
	String hot = b.fileHandle("Sheet2",1,2);
	b.sendingText(hotel, hot);
	
	WebElement roomtype = b.locationId("room_type");
	String room = b.fileHandle("Sheet2",1,3);
	b.sendingText(roomtype, room);
	
	WebElement submit = b.locationId("Submit");
	b.click(submit);
	
	WebElement radio = b.locationId("radiobutton_0");
	b.click(radio);
	
	WebElement conti = b.locationId("continue");
	b.click(conti);
	
	WebElement first = b.locationId("first_name");
	String fir = b.fileHandle("Sheet2",1,4);
	b.sendingText(first, fir);
	
	WebElement last = b.locationId("last_name");
	String lastname = b.fileHandle("Sheet2", 1, 5);
	b.sendingText(last, lastname);
	
	WebElement addr = b.locationId("address");
	String addres = b.fileHandle("Sheet2", 1, 6);
	b.sendingText(addr, addres);
	
	WebElement credit = b.locationId("cc_num");
	String card = b.fileHandle("Sheet2", 1, 7);
	b.sendingText(credit, card);
	
	WebElement cardtype = b.locationId("cc_type");
	String ctype = b.fileHandle("Sheet2", 1, 8);
	b.sendingText(cardtype, ctype);
	
	WebElement exdate = b.locationId("cc_exp_month");
	String expirydate = b.fileHandle("Sheet2", 1, 9);
	b.sendingText(exdate, expirydate);
	
	WebElement exyear = b.locationId("cc_exp_year");
	String expiryyear = b.fileHandle("Sheet2", 1, 10);
	b.sendingText(exyear, expiryyear);
	
	WebElement cvv = b.locationId("cc_cvv");
	String cvvyear = b.fileHandle("Sheet2", 1, 11);
	b.sendingText(cvv, cvvyear);
	
	WebElement book = b.locationId("book_now");
	b.click(book);
	Thread.sleep(8000);
	WebElement ord = b.locationId("order_no");
	String order = b.getAttri(ord);
	b.sendDataToExcel("Sheet2", 1, 12,order );

}
}