package factory_method

type User struct {
	id        int
	firstName string
	lastName  string
}

func MapStr(mapper func(value string, index int) string, list []string) []string {
	var newSlice []string
	// Fixed for
	for index, item := range list {
		newSlice = append(newSlice, mapper(item, index))
	}
	return newSlice
}
func MapMapStr(
	mapper func(value map[string]string, index int) string,
	list []map[string]string) []string {
	var newSlice []string
	for index, item := range list {
		newSlice = append(newSlice, mapper(item, index))
	}
	return newSlice
}
