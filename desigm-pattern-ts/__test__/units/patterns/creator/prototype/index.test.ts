import { Cell, CellWithSize } from "@patterns/creator/prototype/index"
describe( "Creators Pattern: Prototype", () => {
  it( "Should create a new cell of the same instance but not reference", () => {
    const cell = new Cell( "first" )
    const obtainedCell = cell.clone()
    expect( obtainedCell ).not.toBe( cell )
    expect( obtainedCell ).toBeInstanceOf( Cell )
  } )
  it( "Should create a new cell of the with the same values", () => {
    const cell = new Cell( "first" )
    const obtainedCell = cell.clone()
    expect( obtainedCell.name ).toBe( cell.name )
  } )
  it( "Should create a cell with size of the same instance but not reference",
    () => {
      const cell = new CellWithSize( "second", 10 )
      const obtainedCell = cell.clone()
      expect( obtainedCell ).not.toBe( cell )
      expect( obtainedCell ).toBeInstanceOf( CellWithSize )
    } )
  it( "Should create a new cell with size of the with the same values", () => {
    const cell = new CellWithSize( "second", 10 )
    const obtainedCell = cell.clone()
    expect( obtainedCell.name ).toBe( cell.name )
    expect( obtainedCell.size ).toBe( cell.size )
  } )
} )