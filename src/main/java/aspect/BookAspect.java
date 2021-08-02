package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
//    @Aspect
//    @Configuration
//    public class UserAccessAspect {
//
//        private Logger logger = LoggerFactory.getLogger(this.getClass());
//        logger.info(" Check for user access ");

    Integer count = 0;

    @AfterReturning("execution(public void saveBook(..))")
    public void decrementRemainBookAdvice() {
        System.out.println();
        System.out.println("Change data in table book");
        System.out.println();
    }

    @AfterReturning("execution(public String controller.HomeController.*(..))")
    //@AfterReturning("execution(public String getHome())")
    public void countAccess() {
        System.out.println();
        System.out.println("Total viewer: " + ++count);
        System.out.println();
    }

}
