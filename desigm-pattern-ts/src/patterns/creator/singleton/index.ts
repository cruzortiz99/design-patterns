export class SingleInstance {
  static instance: SingleInstance = new SingleInstance()
  public value?: string
  private constructor ( value?: string ) {
    this.value = value
  }
}