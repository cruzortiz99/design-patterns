export interface Component {
  execute (): void
}
export class BaseDecorator implements Component {
  wrapped: Component
  constructor ( component: Component ) {
    this.wrapped = component
  }
  execute (): void {
    return this.wrapped.execute()
  }
}
export class ConcreteDecorator extends BaseDecorator {
  constructor ( component: Component ) {
    super( component )
  }
  extra (): void {
    console.log( "extra work" )
  }
  execute (): void {
    super.execute()
    this.extra()
  }
}