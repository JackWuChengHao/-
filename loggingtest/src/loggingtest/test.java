package loggingtest;
import org.slf4j.Logger;   
import org.slf4j.LoggerFactory;

public class test {
	private static final Logger logger = LoggerFactory.getLogger(test.class);  
	
	public static void main(String[] args) {
		logger.error("hello{}","123");
	}
}
