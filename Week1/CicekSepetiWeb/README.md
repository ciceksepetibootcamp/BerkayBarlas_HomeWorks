# CicekSepetiWebUiTest
 
📌 **Selenium Java Test Automation Project** 📌
 
   The basic testing methodology was used.
   
   **TEST1**
   
  ➾ **productFilterTest**
  >User goes to www.çiçeksepeti.com
  >>Click on "chocolate" from the most searched words.
  >>>On the page that opens, it filters the price to a maximum of 50 TL.
  >>>>After the products are filtered it checks the url from the filter's tag.
  >>>>>If the filter is over 50 TL, it will give an error.

➾ **clearHistory**
  >User goes to www.çiçeksepeti.com
  >>Click on "chocolate" from the most searched words.
  >>>First, shoes are searched on the search bar.
  >>>>Then the shirt is searched.
  >>>>>Finally, the pants are searched.
  >>>>>>The user then clicks on the "Clear History" button when they clear the search bar and click.

  **TEST2**
  
  ➾ **singUp**
  >User goes to www.çiçeksepeti.com
  >>Hover over the Sign in button and click the sign up button.
  >>>Fills in the required information completely.
  >>>>Sees and validates the thank you message.
  
  ➾ **successfulLogin**
  >User goes to www.çiçeksepeti.com
  >>Hover over the Sign in button and click the sign in button.
  >>>Fills in the membership information completely and clicks the login button.
  >>>>My "account" using login is verified.


 🛠 **How to run**🛠
  
   >🔧 After downloading the project, you must first change the chromedriver path.
   >>🔧 After the path is given, go to the project as src>test>java>CiceksepetiWebui.
   >>>🔧Click the run button and you can sit back and watch
   >>>><img width="546" alt="Ekran Resmi 2021-11-26 01 35 27" src="https://user-images.githubusercontent.com/74761090/143505120-27d1038a-17f2-4850-848b-4e5b88df455b.png"> 
   
   
   ***PS*** :
   **User information is not real.**
  
