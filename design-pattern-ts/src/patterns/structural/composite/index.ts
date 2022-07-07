export interface UIComponent {
  render (): string
}
export class TextComponent implements UIComponent {
  private message: string
  constructor(message: string) {
    this.message = message
  }
  render(): string {
    return this.message
  }
}
export class ContainerComposite implements UIComponent {
  private children: UIComponent[]
  constructor ( component: UIComponent ) {
    this.children = [component]
  }
  render (): string {
    return this.children.map((comp) => comp.render())
      .reduce((acc, current) => `${acc}${current}`,"")
  }
  add ( component: UIComponent ): ContainerComposite {
    this.children.push( component )
    return this
  }
  remove ( component: UIComponent ) {
    this.children = this.children.filter( ( child ) => component !== child )
  }
}