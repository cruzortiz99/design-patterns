package design.pattern.java.patterns.structural.facade;

public class VideoConverter {
  public ThirdPartyLibraries.VideoFile convert(
      String filename, String format) {
    ThirdPartyLibraries.VideoFile file = new ThirdPartyLibraries.VideoFile(
        filename);
    String sourceCode = ThirdPartyLibraries.CodecFactory.extract(file);
    ThirdPartyLibraries.CompressionCodec destinationCode;
    if (format.matches("^mp4$")) {
      destinationCode = new ThirdPartyLibraries.MPEG4CompressionCodec();
    } else {
      destinationCode = new ThirdPartyLibraries.OggCompressionCodec();
    }
    String buffer = ThirdPartyLibraries.BitrateReader
        .read(filename, sourceCode);
    String result = ThirdPartyLibraries.BitrateReader
        .buffer(buffer, destinationCode);
    return new ThirdPartyLibraries.VideoFile(new ThirdPartyLibraries.AudioMixer().fix(result));
  }
}
