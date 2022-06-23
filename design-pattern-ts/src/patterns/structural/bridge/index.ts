export interface SomeLibraryInterface {
  method1 (): string
  method2 (): string
  method3 (): string
}
export class SomeLibrary implements SomeLibraryInterface {
  method1 (): string {
    return "method 1"
  }
  method2 (): string {
    return "method 2"
  }
  method3 (): string {
    return "method 3"
  }
}
export interface BridgeLibrary {
  feature (): string
}
export class BridgeConcreteLibrary implements BridgeLibrary {
  library: SomeLibraryInterface
  constructor ( library: SomeLibraryInterface ) {
    this.library = library
  }
  feature (): string {
    return `${this.library.method1()} ${this.library.method2()}`
  }
}