package salesforcemaintest;

import com.DriverFactory;
import com.DriverType;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.salesforcemain.JsButtonOrLinkPage;
import pages.salesforcemain.SalesforceHomePage;
import pages.salesforcemain.SalesforceLoginPage;

public class NewButtonOrLinkTest {
   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://login.salesforce.com/?locale=eu");

        SalesforceLoginPage slogin = new SalesforceLoginPage(driver);
        slogin.typeUsername("leccjsbtnalert.smoketest@de.org");
        slogin.typePassword("test1234");
        slogin.clickLogin();
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.switchToClassic();
    }

    @Before
    public void antes(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.clickOnSetUp();
        shome.clickOnCustomizeIcon();
    }

    @AfterClass
    public static void tearDown()throws Exception{
        if (driver != null) {
            Thread.sleep(4000);
            driver.quit();
        }
    }



    @Test()
    public void windowAlertTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("windowalert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("window.alert('This is a javascript button')");
        jsbtn.saveJavaScriptButton();
    }

   @Test
    public void alertTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("alert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("alert('this is a javascript button')");
        jsbtn.saveJavaScriptButton();
    }

    @Test
    public void objTypeAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("objtypealert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("alert('{$!ObjectType.test__c}')");
        jsbtn.saveJavaScriptButton();
    }



    @Test
    public void mergedFieldsAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Opportunities");
        shome.selectObjectOption("Opportunity","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("mergedfield");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("window.alert('This is {! Opportunity.Name} for Account: {! Opportunity.Account }, Opp Stage is: {!Opportunity.StageName }, Lead Source: {!Opportunity.LeadSource}');");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void ifElseTest(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contacts");
        shome.selectObjectOption("Contact","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("ifelseAlert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!REQUIRESCRIPT('/soap/ajax/27.0/connection.js')}if('{!Contact.Private__c}'=='0'){alert('Coverage Team can be added only to Private COI');} else {window.parent.location = '/apex/Modify_Coverage_Team?name={!Contact.Name}';window.location = '/apex/Modify_Coverage_Team?name={!Contact.Name}';}");
        jsbtn.saveJavaScriptButton();
    }




    @Test
    public void apexAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Accounts");
        shome.selectObjectOption("Account","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("apexAlert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!requireScript('/soap/ajax/29.0/connection.js')}{!requireScript('/soap/ajax/29.0/apex.js')}var acctName = '{!Account.Name}';var result = sforce.apex.execute('JSBtnCall','showMyAlert', {name: acctName});alert(result);");
        jsbtn.saveJavaScriptButton();
    }

    @Test
    public void multipleCallsAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Accounts");
        shome.selectObjectOption("Account","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("nultiplecalls");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!requireScript('/soap/ajax/29.0/connection.js')}{!requireScript('/soap/ajax/29.0/apex.js')}if('{!Account.CustomField__c}' == '0'){var acctId = '{!Account.Id}';var result = sforce.apex.execute('JSBtnCall','showSecondAlert', {acctId: acctId});alert(result);}else{window.alert('This is a test of merge field: {!Account.Name}');}");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void notSupportedObjectAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Products");
        shome.selectObjectOption("Product","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("notSupportedObj");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("alert('this is a javascript button insided a not supported object')");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void urlForAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Campaigns");
        shome.selectObjectOption("Campaign","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("urlfor");
        jsbtn.typeDescription("Description test");
        jsbtn.selectDisplayType("Js Button created by automated test");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!REQUIRESCRIPT('/soap/ajax/27.0/connection.js')} if({!Contact.Private__c}=='0'){ alert('Coverage Team can be added only to Private COI'); } else{ window.parent.location = '/apex/Modify_Coverage_Team?id={!Contact.Id}'; window.location = '/apex/Modify_Coverage_Team?id={!Contact.Id}';}");
        jsbtn.saveJavaScriptButton();
    }



    @Test
    public void taskAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Activities");
        shome.selectObjectOption("Activity","Task Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("taskAlert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("window.alert('Test Id: {!Task.Id}. Status: {!Task.Status}');");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void taskForEmailAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Activities");
        shome.selectObjectOption("Activity","Task Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("taskForEmailAlert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("alert('This is a Task Test')");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void urlHackAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Activities");
        shome.selectObjectOption("Activity","Task Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("urlHack");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("/00T/e?who_id={!Contact.Id}&tsk5=Executive+Meeting&tsk12=Completed&retURL={!Contact.Id}");
        jsbtn.saveJavaScriptButton();
    }




    @Test
    public void contracAlert(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contracts");
        shome.selectObjectOption("Contract","Buttons and Links");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("contractAlert");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("window.alert('This is a test for Contract object')");
        jsbtn.saveJavaScriptButton();
    }



    @Test
    public void contracPartialConversion(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contracts");
        shome.selectObjectOption("Contract","Buttons and Links");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("contracPartialConversion");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!REQUIRESCRIPT('/soap/ajax/13.0/connection.js')}var contractToUpdate = new sforce.SObject('Contract');contractToUpdate.Id = '{!Contract.Id}';contractToUpdate.Description = 'This was updated by JS button';var result = sforce.connection.update([contractToUpdate]);if(result[0].getBoolean('success')) {alert('Contract Updated Correctly');} else {window.alert('Error updating...');}");
        jsbtn.saveJavaScriptButton();
    }



    @Test
    public void contracManualMoreDetail(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contracts");
        shome.selectObjectOption("Contract","Buttons and Links");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("contracManualMoreDetail");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!REQUIRESCRIPT("+"/apex/dsfs__DocuSign_JavaScript"+")}"+"DocuSign_CreateEnvelope();");
        jsbtn.saveJavaScriptButton();
    }


    @Test
    public void openRedirectButton(){
        SalesforceHomePage shome = new SalesforceHomePage(driver);
        shome.selCustomizeOption("Contacts");
        shome.selectObjectOption("Contact","Buttons, Links, and Actions");
        shome.clickOnNewJsButton();
        JsButtonOrLinkPage jsbtn = new JsButtonOrLinkPage(driver);
        jsbtn.typeLabel("openRedirecJsButton");
        jsbtn.typeDescription("Js Button created by automated test");
        jsbtn.selectDisplayType("Detail Page Button");
        jsbtn.selectBehavior("Execute JavaScript");
        jsbtn.typeContentEditor("{!REQUIRESCRIPT("+"'/soap/ajax/33.0/connection.js'"+")}"+"\n " +
                "{!REQUIRESCRIPT("+"'/soap/ajax/33.0/apex.js'"+")}"+"\n" +
                "var contactObject = sforce.connection.query("+"'SELECT Name, FROM Contact, WHERE Id = '{!Contact.Id}''"+");"+"\n"+
                "records = contactObject.getArray("+"'records'"+");"+"\n" +
                "var record = records[0];\n" +
                "var objLead = new sforce.SObject("+"'Lead'"+");"+"\n" +
                "objLead.Name = record.Name; //Similarly you can map other values of Lead before inserting it."+"\n" +
                "var result = sforce.connection.create([objLead]);"+"\n" +
                "\n" +
                "if(result[0].success == "+"'true'"+")"+"\n" +
                "{"+"\n" +
                "window.open("+"'/objLead.Id'"+");"+"\n" +
                "}");
        jsbtn.saveJavaScriptButton();
    }


}
