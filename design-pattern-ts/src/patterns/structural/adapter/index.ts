export interface SomeService<P, R> {
  run ( arg: P ): R
}
export class ServicePrintString implements SomeService<string, string> {
  constructor(){}
  run ( arg: string ): string {
    return `from service: ${arg}`
  }
}
export class AdapterNumToString implements SomeService<number, string> {
  private service: SomeService<string, string>
  constructor ( service: SomeService<string, string> ) {
    this.service = service
  }
  run ( arg: number ): string {
    return this.service.run( `${arg}` )
  }
}