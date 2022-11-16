package visitor

import (
	"design_patterns_training/patterns/behavioral/visitor"
	"testing"
)

type FileReaderMock struct {
	wasXLSCalled bool
	wasDOCCalled bool
	wasCSVCalled bool
	wasPDFCalled bool
}

func (fR *FileReaderMock) ReadCSV(file *visitor.CSVFile) string {
	fR.wasCSVCalled = true
	return "csv"
}
func (fR *FileReaderMock) ReadDOC(file *visitor.DOCFile) string {
	fR.wasDOCCalled = true
	return "doc"
}
func (fR *FileReaderMock) ReadPDF(file *visitor.PDFFile) string {
	fR.wasPDFCalled = true
	return "pdf"
}
func (fR *FileReaderMock) ReadXLS(file *visitor.XLSFile) string {
	fR.wasXLSCalled = true
	return "xls"
}

func TestShouldRunTheReadDocWhenFIleIsDoc(t *testing.T) {
	var fileMock = visitor.DOCFile{}
	var readerFile = FileReaderMock{}
	fileMock.ReadData(&readerFile)
	if !readerFile.wasDOCCalled {
		t.Fatal("ReadDOC should be called")
	}
}
func TestShouldRunTheReadXLSWhenFIleIsXLS(t *testing.T) {
	var fileMock = visitor.XLSFile{}
	var readerFile = FileReaderMock{}
	fileMock.ReadData(&readerFile)
	if !readerFile.wasXLSCalled {
		t.Fatal("ReadDOC should be called")
	}
}
func TestShouldRunTheReadPDFWhenFIleIsPDF(t *testing.T) {
	var fileMock = visitor.PDFFile{}
	var readerFile = FileReaderMock{}
	fileMock.ReadData(&readerFile)
	if !readerFile.wasPDFCalled {
		t.Fatal("ReadDOC should be called")
	}
}
func TestShouldRunTheReadCSVWhenFIleIsCSV(t *testing.T) {
	var fileMock = visitor.CSVFile{}
	var readerFile = FileReaderMock{}
	fileMock.ReadData(&readerFile)
	if !readerFile.wasCSVCalled {
		t.Fatal("ReadDOC should be called")
	}
}
