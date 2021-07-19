# TshNewsletterApp E2e tests
Technologies:
Selenium Webdriver with Java 15

Setup(with Maven tool):
1.)Open project

2.)Go to pom.xml file and download required dependencies

![image](https://user-images.githubusercontent.com/26879282/126209778-c3d44937-f7f5-4625-adac-b494793be1ab.png)

3.)Download correct version of Selenium Chromedriver(matching current Chrome Browser version) and provide correct path in the resources/config.properties file

![image](https://user-images.githubusercontent.com/26879282/126209656-08222a94-861f-4aad-afab-b2884809ab2b.png)

4.)Sign in to your Mailtrap.io account and go to your user dashboard

![image](https://user-images.githubusercontent.com/26879282/126209455-849e59af-3cd2-4fe6-b7d1-4da0933a5204.png)

5.)Copy your credentials to the resources/config.properties file

![image](https://user-images.githubusercontent.com/26879282/126210076-010b7f42-8ff8-4c41-8de9-ad0996a07756.png)

6.)Tests are available in test/java/Test/MainPageTest

![image](https://user-images.githubusercontent.com/26879282/126216335-99041965-b124-404e-89b0-b63beaa2696b.png)
