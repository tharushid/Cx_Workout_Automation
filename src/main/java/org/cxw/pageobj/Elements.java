package org.cxw.pageobj;

import org.cxw.setup.SetUp;
import org.openqa.selenium.By;

public class Elements{
   
	
	/* 
	 Description: elements in Fill CX Projects details in CX Project page 
	*/
	
	By btnNewCXProject = By.xpath("//button[@class='btn create-btn btn-primary' and contains(text(),'Create New Project')]");
	By MenuItemCXProject = By.xpath("//a[@href='#/project' and contains(text(),'CX Projects')]");
	By btnSaveProject = By.xpath("//button[@class='btn btn-primary pull-right' and contains(text(),'Save')]");
	By txtSearch = By.xpath(".//input[@placeholder='Search Projects']");
	By projectEditBtn = By.xpath("//*[@class='icon-cx-workout-icons-cx-edit']");
	By selectedProject = By.xpath("");
	By projectDeleteBtn = By.xpath("//*[@class='icon-cx-workout-icons-cx-remove']");
	By projectDeleteYesBtn = By.xpath("//*[@class='btn btn-default btn-danger']");
	By switchProject = By.xpath("//*[@class='btn btn-primary']");
	// Project section.
	By collapseProject = By.xpath("//div[@class='collapse-btn pull-right' and @ng-click='tab[1] = !tab[1]']");
	By txtProjectName = By.xpath("//input[@id='projectName' and @name='name']");
	By drpdwnProjectLeader = By.xpath("//div[@id='projectLeader' and @name='projectLeader']");
	By selectProjectLeader = By.xpath("//span[@class='ng-binding ng-scope'][1]");
	By selectSpecificProjectLeader = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(),'Ann Brown')]");
	By txtProjectDescription = By.xpath("//input[@type='text' and @name='description']");
	By txtEndDate = By.xpath("//*[@id='endDate']");
	By drpdwnProjectTeam = By.xpath("//div[@id='projectTeam' and @name='projectTeam']");
	By selectProjectTeam = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(),'Lucas Graham')]");
	By drpdwnProjectSupport = By.xpath("//div[@id='projectSupport' and @name='projectSupport']");
	By selectProjectSupport = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(),'Jean Flower')]");
	By drpdwnSme = By.xpath("//div[@id='sme' and @name='sme']");
	By selectSme = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(),'Sean Carl')]");
	By btnChangeImage = By.xpath("//button[@class='btn btn-sm btn-primary ng-scope' and contains(text(),'Change File')]");

	/* 
	 Description: elements in Fill Map Section in CX Project page
	 */
	By expandMap = By.xpath("//div[@class='collapse-btn pull-right' and @ng-click='tab[2] = !tab[2]']");
	By collapseMap = By.xpath("//div[@class='collapse-btn pull-right' and @ng-click='tab[2] = !tab[2]']");
	By drpdwnSelectTemplate = By.xpath("//div[@id='stageTemplate' and @name='stageTemplate']");
	// Sender section.
	By expandSender = By.xpath("//div[@class='collapse-btn pull-right' and @ng-click='tab[3] = !tab[3]']");
	By collapseSender = By.xpath("//div[@class='collapse-btn pull-right' and @ng-click='tab[3] = !tab[3]']");
	By txtsenderName = By.xpath("//input[@id='senderName' and @placeholder='Name to appear as FROM name in inbox']");
	By txtreplyToEmail = By.xpath("//input[@id='replyToEmail' and @placeholder='Reply To Email address']");
	
	
	
	
	
	
	
	
	
	
}