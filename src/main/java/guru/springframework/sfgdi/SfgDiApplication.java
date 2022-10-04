package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfuguration;
import guru.springframework.sfgdi.config.SfgConstructorConfig;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//on using @Components scan while spring starts it utilizes java REFLECTION(w/c is very slow) utils to inspect/scan classes.//but here we only have few classes--NoProblem.
//@ComponentScan(basePackages = {"guru.springframework.sfgdi","com.springframework.pets"})//also works like this//@ComponentScan({"guru.springframework.sfgdi","com.springframework.pets"})
//nowwedontneed@ComponentScan,b/c theFactoryBeanisinjectedatruntimewhen dogpetserviceOrOtherruns anditllfetchtheclass/objthatsuitsthem...
//sincescaningandassigningisdonebyPetServiceFactorywedontneedComponentScan
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		//////////////////////////////////////
		PetController petController = (PetController) ctx.getBean("petController"/*, PetController.class*/);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());
		///////////////////////////////////
		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
		System.out.println("-----I18----");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController)ctx.getBean("myController");

		System.out.println("Primary (bean)---");
		System.out.println(myController.sayHello());

		System.out.println("Property-----DI---");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("Setter-----DI---");
		SetterInjectedController setterInjectedController = (SetterInjectedController)ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("Constructor-----DI---");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("----Bean Scopes -----------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = (FakeDataSource)ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("-------Config Props Bean--------");
		SfgConfuguration sfgConfuguration = ctx.getBean(SfgConfuguration.class);
		System.out.println(sfgConfuguration.getUsername());
		System.out.println(sfgConfuguration.getPassword());
		System.out.println(sfgConfuguration.getJdbcurl());

		System.out.println("-------Constructor Binding--------");
		SfgConstructorConfig sfgConstructorConfig = (SfgConstructorConfig) ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcurl());

	}
	public void hello () {
		System.out.println("helloassignment");
	}

}
