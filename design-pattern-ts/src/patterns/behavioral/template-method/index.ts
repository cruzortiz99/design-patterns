export class DataReaderTemplate<T> {
  private dataProducer: () => T[]
  constructor(producer: () => T[]) {
    this.dataProducer = producer
  }
  map<NT>(mapper: (data: T, key: number) => NT): DataReaderTemplate<NT> {
    return new DataReaderTemplate<NT>(() => 
      this.dataProducer().map(mapper)
    )
  }
  filter(predicate: (data: T, key: number) => boolean): DataReaderTemplate<T> {
    return new DataReaderTemplate<T>(() =>
    this.dataProducer().filter(predicate)
    )
  }
  reduce<NT>(
    reducer: (acc: NT, current: T, key: number) => NT, initial: NT):
     DataReaderTemplate<NT> {
    return new DataReaderTemplate(
      () => [this.dataProducer().reduce(reducer, initial)])
  }
  get() {
    return this.dataProducer()
  }
}