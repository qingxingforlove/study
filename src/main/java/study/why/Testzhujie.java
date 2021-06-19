package study.why;

import java.lang.annotation.*;

@MyAnnotation(name = "HHH",schools={"xibei", "xinan"})
public class Testzhujie {

    @MyAnnotation(name = "abc", schools={"xibei", "xinan"})
    public void test(){
        System.out.println("测试注解");
    }
}


@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

    //注解参数name
    String name();
    int age() default 18;
    int id() default -1;//-1代表找不到

    String[] schools();
}

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}

