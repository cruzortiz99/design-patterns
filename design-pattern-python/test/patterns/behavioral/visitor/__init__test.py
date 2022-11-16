import unittest
from patterns.behavioral.visitor import FileReaderVisitor, File
from patterns.behavioral.visitor import DOCFile, XLSFile
from patterns.behavioral.visitor import CSVFile, PDFFile


class FileReaderMock(FileReaderVisitor):
    def __init__(self) -> None:
        super().__init__()
        self.was_csv_called = False
        self.was_pdf_called = False
        self.was_doc_called = False
        self.was_xls_called = False

    def read_csv(self, file: File) -> str:
        self.was_csv_called = True
        return "csv"

    def read_doc(self, file: File) -> str:
        self.was_doc_called = True
        return "doc"

    def read_pdf(self, file: File) -> str:
        self.was_pdf_called = True
        return "pdf"

    def read_xls(self, file: File) -> str:
        self.was_xls_called = True
        return "xls"


class VisitorTest(unittest.TestCase):
    def test_should_run_read_doc_when_file_is_doc(self):
        mock_file = DOCFile()
        reader_file = FileReaderMock()
        mock_file.read_data(reader_file)
        self.assertTrue(reader_file.was_doc_called)

    def test_should_run_read_pdf_when_file_is_pdf(self):
        mock_file = PDFFile()
        reader_file = FileReaderMock()
        mock_file.read_data(reader_file)
        self.assertTrue(reader_file.was_pdf_called)

    def test_should_run_read_xls_when_file_is_xls(self):
        mock_file = XLSFile()
        reader_file = FileReaderMock()
        mock_file.read_data(reader_file)
        self.assertTrue(reader_file.was_xls_called)

    def test_should_run_read_csv_when_file_is_csv(self):
        mock_file = CSVFile()
        reader_file = FileReaderMock()
        mock_file.read_data(reader_file)
        self.assertTrue(reader_file.was_csv_called)
