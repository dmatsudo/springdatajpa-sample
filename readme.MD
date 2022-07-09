# springdatajpa-sample
Sample springboot-jpa application. It has one dummy Customer entity and uses H2 as memory DB.

It extends CrudRepository SpringData interface and declares two custom methods.

In SpringDataJpaSampleApplication class it creates a *CommandLineRunner*(*) bean that tests some of the Repository methods.

**CommandLineRunner* is a simple Spring Boot interface with a run method. Spring Boot will automatically call the run method of all beans implementing this interface after the application context has been loaded
