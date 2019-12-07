# SinnerSchrader

I have followed the Page Object Model(POM) approach with keyworddriven framework.


The advantage of POM is every page has its own class thereby we can adapt the changes easily.

I have created maven project and used TestNG to design thetestscripts 

“Test Base” class is a parent class of all classes. 

In “Test Base”class  I have  defined all basic initializations like browserinitialization, delete all cookies, implicitlyWait and maximizing window.   

Below are the different pages I have created:
 * BrokenImagesPage·       
 * LoginPage·       
 * HorizontalSliderPage·       
 * UserDetailsPage

“SinnerSchraderTest” is a TestNG class, By using “SinnerSchraderTest”class we can execute the project. 

In “GenericActions” class I have written all reusable keywords.

I used “config.properties” file to define common properties likebrowser name and URL.

I have used “pop.XML” to add dependencies for jar filesExecution:By using “SinnerSchraderTest” class we can execute the project. 

I have used “Extended Repot” for the reports and results will store in “Results” folded with screenshots.  
