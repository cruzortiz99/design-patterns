package facade

type VideoConverter struct{}

func NewVideoConverter() VideoConverter {
	return VideoConverter{}
}

func (vc *VideoConverter) Convert(filename string, format string) VideoFile {
	file := NewVideoFile(filename)
	sourceCode := CodeFactoryExtract(file)
	var destinationCode CompressionCodec
	if format == "mp4" {
		destinationCode = NewMPEG4CompressionCodec().CompressionCodec
	} else {
		destinationCode = NewOggCompressionCodec().CompressionCodec
	}
	buffer := BitrateReaderRead(filename, sourceCode)
	result := BitrateReaderBuffer(buffer, destinationCode)
	audioMaker := NewAudioMaker()
	return NewVideoFile(audioMaker.Fix(result))
}
