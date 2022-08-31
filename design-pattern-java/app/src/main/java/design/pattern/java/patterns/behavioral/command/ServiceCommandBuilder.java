package design.pattern.java.patterns.behavioral.command;

public class ServiceCommandBuilder {
  public class ServiceCommand {
    private ServiceCommandBuilder command;

    private ServiceCommand(ServiceCommandBuilder command) {
      this.command = command;
    }

    public void Run() {
      this.command.service.apply(this.command.value);
    }
  }

  private String value;
  private Service service;

  public ServiceCommandBuilder(Service service) {
    this.service = service;
  }

  public ServiceCommand setArgs(String value) {
    this.value = value;
    return new ServiceCommand(this);
  }

}
