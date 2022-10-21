package design.pattern.kotlin.patterns.structural.facade

class VideoConverter {
    fun convert(
        filename: String, format: String
    ): ThirdPartyLibraries.VideoFile {
        val file = ThirdPartyLibraries.VideoFile(
            filename
        )
        val sourceCode = ThirdPartyLibraries.CodecFactory.extract(file)
        val destinationCode: ThirdPartyLibraries.CompressionCodec =
            if (format.matches(Regex("^mp4$"))) {
            ThirdPartyLibraries.MPEG4CompressionCodec()
        } else {
            ThirdPartyLibraries.OggCompressionCodec()
        }
        val buffer = ThirdPartyLibraries.BitrateReader
            .read(filename, sourceCode)
        val result = ThirdPartyLibraries.BitrateReader
            .buffer(buffer, destinationCode)
        return ThirdPartyLibraries.VideoFile(ThirdPartyLibraries.AudioMixer().fix(result))
    }
}