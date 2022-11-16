export interface File {
  getPath(): string
  readData(reader: FileReaderVisitor): string
}
export class XLSFile implements File{
  getPath(): string {
    return "xls"
  }
  readData(reader: FileReaderVisitor): string {
      return reader.readXLS(this)
  }
}
export class DOCFile implements File{
  readData(reader: FileReaderVisitor): string {
    return reader.readDOC(this)
  }
  getPath(): string {
    return "doc"
  }
}
export class PDFFile implements File{
  readData(reader: FileReaderVisitor): string {
    return reader.readPDF(this)
  }
  getPath(): string {
    return "pdf"
  }
}
export class CSVFile implements File{
  readData(reader: FileReaderVisitor): string {
    return reader.readCSV(this)
  }
  getPath(): string {
    return "csv"
  }
}

export interface FileReaderVisitor {
  readXLS(file: XLSFile): string
  readDOC(file: DOCFile): string
  readPDF(file: PDFFile): string
  readCSV(file: CSVFile): string
}