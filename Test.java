package review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import review.iface.CustomerReview;
import review.impl.CustomerReviewImpl;

public class Test {

    /**
     * @param args
     */
	
    public static void main(String[] args) {
    	//1.	Provide a way to get a product’s total number of customer reviews whose ratings are within a given range (inclusive).
    	// Create service --> dao to access database with SQL COUNT function by rating condition
    	// for example : SELECT COUNT(rate) FROM customer_review WHERE rate = 5 and product_id=101;

    	
    	//3.	Ensure the new functionality can be used elsewhere in the application (i.e.  a bean containing the new functionality is defined within the customerreview-spring.xml).
        ApplicationContext context=new ClassPathXmlApplicationContext("review/customerreview-spring.xml");
        
        
        
    	//2.	Add the following additional checks before creating a customer review:
		//a.	Your service should read a list of curse words. This list should not be defined in Java class. 
		//b.	Check if Customer’s comment contains any of these curse words. If it does, throw an exception with a message.
		//c.	Check if the rating is not < 0.  If it is < 0, throw an exception with a message.

        
        ReviewManager reviewManager=(ReviewManager)context.getBean("review");
    
        CustomerReviewImpl review=new CustomerReviewImpl();
        review.setReview("shit! This is a test review!");
        review.setRate(-5);
        
        reviewManager.setCustomerReview(review);
        
		//If all the rules are passed, go ahead and create the customer review.
        CustomerReview cr = reviewManager.getCustomerReview();
        if(cr.getExceptions().size()==0) {
        	//create this cutomer review
        }else {
        	//return error messages
        	cr.getExceptions().forEach(x->System.out.println(x.getMessage()));
        }
    }
}