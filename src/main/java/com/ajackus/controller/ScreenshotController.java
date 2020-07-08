package com.ajackus.controller;

/**
 * @author tejashree*/

import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import com.ajackus.model.ResponseFormat;

@RestController
public class ScreenshotController {

	final static Logger logger = Logger.getLogger(ScreenshotController.class);

	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshot(@RequestHeader String url) {
		logger.info("inside takeScreenshot method");
		ResponseFormat responseFormat = new ResponseFormat();
		try {
			if (!"".equalsIgnoreCase(url) && url != null) {
				// INITIALIZE WEBDRIVER 
				WebDriver driver;
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(url);
				// TAKE SCREENSHOT OF THE ENTIRE PAGE
				Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
						.takeScreenshot(driver);
				// FIND THE SYSTEMS USER PATH
				String home = System.getProperty("user.home");
				ImageIO.write(screenshot.getImage(), "PNG", new File(home + "/" + "screenshot.png"));
				// CLOSE DRIVER
				driver.quit();
				responseFormat.setStatus("Success");
				responseFormat.setStatusCode(200);
				responseFormat.setMessage("url is valid");
				return new ResponseEntity<ResponseFormat>(responseFormat, HttpStatus.OK);
			} else {
				logger.error("url is not valid");
				responseFormat.setStatus("Failed");
				responseFormat.setStatusCode(406);
				responseFormat.setMessage("url is not valid");
				return new ResponseEntity<ResponseFormat>(responseFormat, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			responseFormat.setStatus("Failed");
			responseFormat.setStatusCode(406);
			responseFormat.setMessage(e.getMessage());
			return new ResponseEntity<ResponseFormat>(responseFormat, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotGET() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotDelete() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.HEAD, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotHead() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.OPTIONS, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotOptions() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.PATCH, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotPath() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotPut() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/takeScreenshot", method = RequestMethod.TRACE, produces = "application/json")
	public ResponseEntity<ResponseFormat> takeScreenshotTrace() {
		ResponseFormat responseFormat = new ResponseFormat();
			responseFormat.setStatus("Failed");
			responseFormat.setMessage("Method not allowed");
			responseFormat.setStatusCode(405);
			logger.error("Method not allowed");
			return new ResponseEntity(responseFormat,HttpStatus.METHOD_NOT_ALLOWED);
	}
}