package visitor

type File interface {
	GetPath() string
	ReadData(reader *FileReaderVisitor) string
}
type XLSFile struct{}

func (file *XLSFile) GetPath() string {
	return "xls"
}
func (file *XLSFile) ReadData(reader FileReaderVisitor) string {
	return reader.ReadXLS(file)
}

type DOCFile struct{}

func (file *DOCFile) GetPath() string {
	return "doc"
}
func (file *DOCFile) ReadData(reader FileReaderVisitor) string {
	return reader.ReadDOC(file)
}

type PDFFile struct{}

func (file *PDFFile) GetPath() string {
	return "pdf"
}
func (file *PDFFile) ReadData(reader FileReaderVisitor) string {
	return reader.ReadPDF(file)
}

type CSVFile struct{}

func (file *CSVFile) GetPath() string {
	return "csv"
}
func (file *CSVFile) ReadData(reader FileReaderVisitor) string {
	return reader.ReadCSV(file)
}

type FileReaderVisitor interface {
	ReadXLS(file *XLSFile) string
	ReadDOC(file *DOCFile) string
	ReadPDF(file *PDFFile) string
	ReadCSV(file *CSVFile) string
}
