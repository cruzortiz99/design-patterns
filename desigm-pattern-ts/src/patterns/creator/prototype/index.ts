export interface Prototype<T extends Prototype<T>> {
  clone (): T
}

export class Cell implements Prototype<Cell> {
  name: string
  constructor ( name: string ) {
    this.name = name
  }
  clone (): Cell {
    return new Cell( this.name )
  }
}
export class CellWithSize extends Cell {
  size: number
  constructor ( name: string, size: number ) {
    super( name )
    this.size = size
  }
  clone (): CellWithSize {
    return new CellWithSize( this.name, this.size )
  }
}