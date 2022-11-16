import { 
  CSVFile, 
  DOCFile, 
  FileReaderVisitor, 
  PDFFile, 
  XLSFile } from "@patterns/behavioral/visitor"

describe("Visitor Pattern", () => {
  class FileReaderMock implements FileReaderVisitor {
    wasXLSCalled: boolean
    wasDOCCalled: boolean
    wasPDFCalled: boolean
    wasCSVCalled: boolean
    constructor() {
      this.wasXLSCalled = false
      this.wasDOCCalled = false
      this.wasPDFCalled = false
      this.wasCSVCalled = false
    }
    readXLS(file: XLSFile): string {
      this.wasXLSCalled = true
      return "xls"
    }
    readDOC(file: DOCFile): string {
      this.wasDOCCalled = true
      return "doc"
    }
    readPDF(file: PDFFile): string {
      this.wasPDFCalled = true
      return "pdf"
    }
    readCSV(file: CSVFile): string {
      this.wasCSVCalled = true
      return "csv"
    }
  }
  test("Should run the readDoc when file is Doc", () => {
    const mockFile = new DOCFile()
    const readerFile = new FileReaderMock()
    mockFile.readData(readerFile)
    expect(readerFile.wasDOCCalled).toBeTruthy()

  })
  test("Should run the readXLS when file is XLS", () => {
    const mockFile = new XLSFile()
    const readerFile = new FileReaderMock()
    mockFile.readData(readerFile)
    expect(readerFile.wasXLSCalled).toBeTruthy()
  })
  test("Should run the readPDF when file is PDF", () => {
    const mockFile = new PDFFile()
    const readerFile = new FileReaderMock()
    mockFile.readData(readerFile)
    expect(readerFile.wasPDFCalled).toBeTruthy()
  })
  test("Should run the readCSV when file is CSV", () => {
    const mockFile = new CSVFile()
    const readerFile = new FileReaderMock()
    mockFile.readData(readerFile)
    expect(readerFile.wasCSVCalled).toBeTruthy()
  })
})