import patterns.structural.facade.third_party_libraries as tpl


class VideoConverter:
    def __init__(self) -> None:
        pass

    def convert(self, filename: str, format: str) -> tpl.VideoFile:
        file = tpl.VideoFile(filename)
        source_code = tpl.CodecFactory_extract(file)
        destination_code: tpl.CompressionCodec
        if format == "mp4":
            destination_code = tpl.MPEG4CompressionCodec()
        else:
            destination_code = tpl.OggCompressionCodec()
        buffer = tpl.BitrateReader_read(filename, source_code)
        result = tpl.BitrateReader_buffer(buffer, destination_code)
        return tpl.VideoFile(tpl.AudioMixer().fix(result))
