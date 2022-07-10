package facade

import (
	"strings"
)

type VideoFile struct {
	Filename string
}

func NewVideoFile(filename string) VideoFile {
	return VideoFile{Filename: filename}
}

type CompressionCodec struct{}
type OggCompressionCodec struct {
	CompressionCodec
}
type MPEG4CompressionCodec struct {
	CompressionCodec
}

func CodeFactoryExtract(file VideoFile) string {
	return strings.Join([]string{
		"CodeFactory.extract",
		file.Filename,
	}, "")
}

func BitrateReaderRead(value string, source string) string {
	return strings.Join([]string{
		"BitrateReader.read: ",
		value,
		",",
		source,
	}, "")
}
func BitrateReaderBuffer(value string, source CompressionCodec) string {
	return strings.Join([]string{
		"BitrateReader.buffer: ",
		value,
	}, "")
}

type AudioMaker struct{}

func (a *AudioMaker) Fix(value string) string {
	return strings.Join([]string{"AudioMixer.Fix: ", value}, "")
}
