package design.pattern.kotlin.patterns.structural.facade

class ThirdPartyLibraries {
    class VideoFile(val filename: String)
    open class CompressionCodec
    class OggCompressionCodec : CompressionCodec()
    class MPEG4CompressionCodec : CompressionCodec()
    object CodecFactory {
        fun extract(file: VideoFile): String {
            return "CodecFactory.extract: " + file.filename
        }
    }

    object BitrateReader {
        fun read(value: String, source: String): String {
            return "BitReader.read: $value,$source"
        }

        fun buffer(value: String, compression: CompressionCodec?): String {
            return "BitReader.buffer: $value"
        }
    }

    class AudioMixer {
        fun fix(value: String): String {
            return "AudioMixer.fix: $value"
        }
    }
}