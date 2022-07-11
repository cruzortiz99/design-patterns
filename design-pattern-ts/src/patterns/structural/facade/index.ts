import {
	AudioMixer,
	Bitrate,
	CodecFactory,
	CompressionCode,
	MPEG4CompressionCodec,
	OggCompressionCodec,
	VideoFile,
} from "./third-party-library"
export class VideoConverter {
	convert(filename: string, format: string): VideoFile {
		const file = new VideoFile(filename)
		const sourceCode = CodecFactory.extract(file)
		let destination: CompressionCode
		if (format === "mp4") {
			destination = new MPEG4CompressionCodec()
		} else {
			destination = new OggCompressionCodec()
		}
		const buffer = Bitrate.read(filename, sourceCode)
		const result = Bitrate.buffer(buffer, destination)
		return new VideoFile(new AudioMixer().fix(result))
	}
}
