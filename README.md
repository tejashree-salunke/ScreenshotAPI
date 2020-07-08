# ScreenshotAPI
Create an API to take a screenshot of whole page 

## devDependencies

		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.14.0</version>
		</dependency>
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>27.0.1-jre</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot -->
		<dependency>
			<groupId>ru.yandex.qatools.ashot</groupId>
			<artifactId>ashot</artifactId>
			<version>1.5.3</version>
		</dependency>
    
    ### downloads
    
    Add the chromedriver.exe from https://sites.google.com/a/chromium.org/chromedriver/downloads and place the chromedriver.exe under driver folder
    
    #### Steps 
    1. Build the project 
    2. use swagger to call API eg. http://localhost:3080/ScreenshotAPI/swagger-ui.html
    3. click on post method and enter the url and click on execute
    4. if resonse code is 200 then check image in the users folder with the name screenshot.png

