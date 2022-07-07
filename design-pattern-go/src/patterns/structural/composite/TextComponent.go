package composite

type TextComponent struct {
	message string
	UIComponent
}

func NewTextComponent(message string) TextComponent {
	return TextComponent{message: message}
}

func (c TextComponent) Render() string {
	return c.message
}
func (c *TextComponent) GetMessage() string {
	return c.message
}
