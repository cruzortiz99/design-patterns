package design.pattern.java.patterns.creational.singleton;

public class DBConnection {

  private static DBConnection instance;
  private String host;
  private Number port;
  private String username;
  private String password;

  
  private DBConnection(String host,Number port, String username, String password) {
    super();
    this.host = host;
    this.port = port;
    this.username = username;
    this.password = password;
  }
  public static DBConnection create(String host, Number port, String username, String password) {
    if (instance == null) {
      DBConnection.instance = new DBConnection(host, port, username, password);
      return DBConnection.instance;
    }
    return DBConnection.instance;
  } 
  
  public String getHost() {
    return this.host;
  }
  public Number getPort() {
    return this.port;
  }
  public String getUsername() {
    return this.username;
  }
  public String getPassword() {
    return this.password;
  }
}
