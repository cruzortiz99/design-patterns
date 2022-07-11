export class VideoFile {
  filename: string
  constructor(filename: string) {
    this.filename = filename
  }
}
export class CompressionCode {}

export class MPEG4CompressionCodec extends CompressionCode {}
export class OggCompressionCodec extends CompressionCode {}

export class CodecFactory {
  static extract = (file: VideoFile): string => file.filename
}
export class Bitrate {
  static read = (value: string, source: string): string => 
    "BitrateReader.read: ".concat(value).concat(", ").concat(source)
  
  static buffer = (value: string, compression: CompressionCode) =>
    "BitrateReader.buffer: ".concat(value)
}
export class AudioMixer {
  fix(value: string): string {
    return "AudioMixer.fix: ".concat(value)
  }
}