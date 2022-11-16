from abc import abstractmethod, ABC


class File(ABC):
    @abstractmethod
    def get_path(self) -> str:
        raise Exception("method not implemented")

    @abstractmethod
    def read_data(self, reader: 'FileReaderVisitor') -> str:
        raise Exception("method not implemented")


class XLSFile(File):
    def get_path(self) -> str:
        return "xls"

    def read_data(self, reader: 'FileReaderVisitor') -> str:
        return reader.read_xls(self)


class DOCFile(File):
    def get_path(self) -> str:
        return "doc"

    def read_data(self, reader: 'FileReaderVisitor') -> str:
        return reader.read_doc(self)


class PDFFile(File):
    def get_path(self) -> str:
        return "pdf"

    def read_data(self, reader: 'FileReaderVisitor') -> str:
        return reader.read_pdf(self)


class CSVFile(File):
    def get_path(self) -> str:
        return "csv"

    def read_data(self, reader: 'FileReaderVisitor') -> str:
        return reader.read_csv(self)


class FileReaderVisitor(ABC):
    @abstractmethod
    def read_xls(self, file: File) -> str:
        raise Exception("method not implemented")

    @abstractmethod
    def read_doc(self, file: File) -> str:
        raise Exception("method not implemented")

    @abstractmethod
    def read_pdf(self, file: File) -> str:
        raise Exception("method not implemented")

    @abstractmethod
    def read_csv(self, file: File) -> str:
        raise Exception("method not implemented")
