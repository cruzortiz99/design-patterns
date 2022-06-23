export interface SomeService<P, R> {
  run ( arg: P ): R
}
export class BasicService implements SomeService<string, string> {
  run ( arg: string ): string {
    return `from service: ${arg}`
  }
}
export class AdaptedService implements SomeService<string, string> {
  private service: SomeService<string, string>
  constructor ( service: SomeService<string, string> ) {
    this.service = service
  }
  run ( arg: string ): string {
    return this.service.run( `from adapter: ${arg}` )
  }
}