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
