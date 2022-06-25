package factory_method

type User struct {
	Id        int
	FirstName string
	LastName  string
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
func MapUser(
	mapper func(value User, index int) string,
	users []User) []string {
	var newSlice []string
	for index, user := range users {
		mapper(user, index)
	}
	return newSlice
}
