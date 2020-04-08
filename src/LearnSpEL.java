/** 
 * 
 */

/**
 * @author prakash
 *
 */

import java.beans.Expression;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.EvaluationContext;

public class LearnSpEL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext(
                "src/spelConfig.xml");
 
	    Company compobj = (Company) context.getBean("companyBean");
	    
	    System.out.println("Product Name: "+compobj.getPrname());
	    System.out.println("Product Price: "+compobj.getPrprice());
	    
	    // Evaluate a literal string expression
	    parseExpressions("'Hello World'");
	    
	    // Evaluate an expression that calls the concat method on the string literal.
	    parseExpressions("'Hello World'.concat('!')");
	    
	    // Evaluate an expression that calls a JavaBean property
	    parseExpressionsToByteArray("'Hello World'.bytes");
	    
	    // Evaluate an expression that calls nested properties using standard dot notation.
	    parseExpressionsToInteger("'Hello World'.bytes.length");
	    
	    // Evaluate an expression that calls the String's constructor.
	    parseExpressionsThatUseStringConstructor("new String('hello world').toUpperCase()");
	    
	    //Evaluate an Expression against a specific object instance (called the root object)
	    parseExpressionAgainstAnObjectInstance();
	    
	}
	
	private static void parseExpressionAgainstAnObjectInstance() {
		// Create and set a Calendar
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(1856, 7, 9);
		
		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", calendar.getTime(), "Serbian");
		
		ExpressionParser parser = new SpelExpressionParser();
		org.springframework.expression.Expression exp = parser.parseExpression("name");
		
		try {
			EvaluationContext context = new StandardEvaluationContext(tesla);
			System.out.println((String) exp.getValue(context));
			
			exp = parser.parseExpression("birthDate");
			Date date = (Date) exp.getValue(context);
			System.out.println(date.toString());
			
			exp = parser.parseExpression("nationality");
			System.out.println((String) exp.getValue(context));
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	private static void parseExpressionsToInteger(String inputExpression) {
		try
		{
			ExpressionParser parser = new SpelExpressionParser();
			SpelExpression exp = (SpelExpression) parser.parseExpression(inputExpression);
			System.out.println((Integer) exp.getValue());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void parseExpressionsToByteArray(String inputExpression) {
		try
		{
			ExpressionParser parser = new SpelExpressionParser();
			SpelExpression exp = (SpelExpression) parser.parseExpression(inputExpression);
			System.out.println(((byte[]) exp.getValue()).length);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void parseExpressionsThatUseStringConstructor(String inputExpression) {
		try
		{
			ExpressionParser parser = new SpelExpressionParser();
			SpelExpression exp = (SpelExpression) parser.parseExpression(inputExpression);
			System.out.println(exp.getValue(String.class));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	private static void parseExpressions(String inputExpression) {
		try
		{
			ExpressionParser parser = new SpelExpressionParser();
			SpelExpression exp = (SpelExpression) parser.parseExpression(inputExpression);
			System.out.println((String) exp.getValue());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
