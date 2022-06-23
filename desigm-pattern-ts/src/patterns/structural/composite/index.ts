export interface Component {
  execute (): void
}
export class Leaf implements Component {
  execute (): void {
    console.log( "some execution" )
  }
}
export class Composite implements Component {
  private children: Component[]
  constructor ( component: Component ) {
    this.children = [component]
  }
  execute (): void {
    this.children.forEach( component => component.execute() )
  }
  add ( component: Component ): Composite {
    this.children.push( component )
    return this
  }
  remove ( index: number ): Composite {
    this.children = this.children.filter( ( _, key ) => key !== index )
    return this
  }
  getChildren (): Component[] {
    return [...this.children]
  }

}