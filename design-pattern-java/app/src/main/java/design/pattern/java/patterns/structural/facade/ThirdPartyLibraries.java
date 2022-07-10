package design.pattern.java.patterns.structural.facade;

public class ThirdPartyLibraries {
  public static class VideoFile {
    public final String filename;

    public VideoFile(String filename) {
      this.filename = filename;
    }
  }

  public static class CompressionCodec {
  }

  public static class OggCompressionCodec extends CompressionCodec {
  }

  public static class MPEG4CompressionCodec extends CompressionCodec {
  }

  public static class CodecFactory {
    public static String extract(VideoFile file) {
      return "CodecFactory.extract: ".concat(file.filename);
    }
  }

  public static class BitrateReader {
    static String read(String value, String source) {
      return "BitReader.read: ".concat(value).concat(",").concat(source);
    }

    static String buffer(String value, CompressionCodec compression) {
      return "BitReader.buffer: ".concat(value);
    }
  }

  public static class AudioMixer {
    public String fix(String value) {
      return "AudioMixer.fix: ".concat(value);
    }
  }

}
