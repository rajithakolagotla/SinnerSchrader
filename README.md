# SinnerSchrader

I have created (followed) the Page Object Model(POM) approach with keyworddriven frameworkThe concept (advantage) of POM is (every page has its own class thereby we can adapt the changes easily) for each and every page we have to createa separate java class
I have created maven project and used TestNG to design thetestscripts “Test Base” class is a parent class of all classes, In “Test Base”class  
I have  defined all basic initializations like browserinitialization, delete all cookies, implicitlyWait and maximizing window   
Below are the different pagesI have created:·       
  BrokenImagesPage·       
  LoginPage·       
  HorizontalSliderPage·       
  UserDetailsPage
 “SinnerSchraderTest” is a TestNG class, By using “SinnerSchraderTest”class we can execute the project 
 In “GenericActions” class I have written all reusable keywords
 I used “config.properties” file to define common properties likebrowser name and URL
 I have used “pop.XML” to add dependencies for jar filesExecution:By using “SinnerSchraderTest” class we can execute the project 
 I have used “Extended Repot” for the reports and results willstore in “Results” folded with screenshots  
