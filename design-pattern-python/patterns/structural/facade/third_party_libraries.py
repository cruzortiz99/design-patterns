from isort import file


class VideoFile:
    def __init__(self, filename: str) -> None:
        self.filename = filename


class CompressionCodec:
    def __init__(self) -> None:
        pass


class OggCompressionCodec(CompressionCodec):
    def __init__(self) -> None:
        super().__init__()


class MPEG4CompressionCodec(CompressionCodec):
    def __init__(self) -> None:
        super().__init__()


def CodecFactory_extract(file: VideoFile) -> str:
    return file.filename


def BitrateReader_read(value: str, source: str) -> str:
    return f"BitrateReader.read: {value}, {source}"


def BitrateReader_buffer(value: str, compression: CompressionCodec) -> str:
    return f"BitrateReader.buffer: {value}"


class AudioMixer:
    def fix(self, value: str) -> str:
        return f"AudioMixer.fix: {value}"
