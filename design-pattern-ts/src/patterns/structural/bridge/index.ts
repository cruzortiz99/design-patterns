export interface SomeLibraryInterface {
  writeString (): string
  integerGenerator (): number
  writeOtherString (): string
}
export class SomeLibrary implements SomeLibraryInterface {
  writeString(): string {
    return "String wrote"
  }
  integerGenerator(): number {
    return Math.random() * 100
  }
  writeOtherString(): string {
    return "Other string wrote"
  }
}
export class ServiceBridge {
  library: SomeLibraryInterface
  constructor ( library: SomeLibraryInterface ) {
    this.library = library
  }
  concreteFeature (): string {
    return `${this.library.writeString()}
    ${this.library.writeOtherString()}
    ${this.library.integerGenerator()}`
  }
}