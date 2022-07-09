export interface ServiceInterface {
  run(value: string): string;
}
export class ServicePrintString implements ServiceInterface{
  run(value: string): string {
    return "Print: ".concat(value)
  }
}

export class LoggerDecorator implements ServiceInterface {
  private service: ServiceInterface
  constructor(service: ServiceInterface) {
    this.service = service
  }
  run(value: string): string {
    this.log(value)
    return this.service.run(value) 
  }
  log(value: string) {
    console.log("Logging: ".concat(value))
  }
}