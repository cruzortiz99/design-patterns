package design.pattern.java.patterns.creational.singleton;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DBConnectionTest {
  @Test
  public void itShouldCreateADBConnectionWhenCreateIsCalled() {
    String host = "test.com";
    int port = 8443;
    String username = "test";
    String password = "****";
    final DBConnection connection = DBConnection.create(
      host, port, username, password);
    Assertions.assertEquals(host, connection.getHost());    
    Assertions.assertEquals(port, connection.getPort());    
    Assertions.assertEquals(username, connection.getUsername());    
    Assertions.assertEquals(password, connection.getPassword());    
  }
  @Test
  public void itShouldCreateOnlyOneInstanceWhenCreateIsCalledMoreThanOnce() {
    String host = "test.com";
    int port = 8443;
    String username = "test";
    String password = "****";
    final DBConnection connection = DBConnection.create(
      host, port, username, password);
    Stream.generate(() -> Double.valueOf(Math.random() * 100).intValue())
      .limit(10)
      .peek((t) -> System.out.println(t))
      .map(
        (index) -> DBConnection.create(
          host, port, username.concat(index.toString()), password)
        )
      .forEach((testDBConnection) -> 
        Assertions.assertEquals(connection, testDBConnection)
      );
  }  
}
