package utils

import (
	"bufio"
	"os"
	"time"

	"github.com/nu7hatch/gouuid"
)

// NewUUID Generate a new UUID
// This function outputs a version 4 (Random) UUID as per https://en.wikipedia.org/wiki/Universally_unique_identifier#Version_4_.28random.29
func NewUUID() (string, error) {

	uuid, err := uuid.NewV4()

	if err != nil {

		return "", err
	}

	return uuid.String(), nil
}

// ReadLocalUUID Read a local UUID value
// Input a file path that contains the UUID string, only on one line with no line break
func ReadLocalUUID(path string) (string, error) {

	f, err := os.Open(path)

	if err != nil {

		return "", err
	}

	defer f.Close()

	reader := bufio.NewReader(f)

	line, _, err := reader.ReadLine()

	if err != nil {

		return "", err
	}

	return string(line), nil
}

// FileExists Checks if a path exists (Directory or File)
// Returns true if exists, false if not
func FileExists(path string) (bool, error) {

	if _, err := os.Stat(path); os.IsNotExist(err) {

		return false, nil
	}

	return true, nil
}

// WriteString Write a string to a file
// Input the path to file and input string to be written
// Set truncate to true if you would like to truncate the file before writing or false if appending is desired
func WriteString(path, input string, truncate bool) error {

	flags := os.O_RDWR | os.O_CREATE

	if truncate {

		flags |= os.O_TRUNC
	}

	os.OpenFile(path, flags, 0666)

	file, err := os.Create(path)

	if err != nil {

		return err
	}

	defer file.Close()

	_, err = file.Write([]byte(input))

	if err != nil {

		return err
	}

	err = file.Sync()

	if err != nil {

		return err
	}

	return nil
}

// TimeFormatISO convert an instance of time.time into an ISO8601 formatted timestamp
func TimeFormatISO(input time.Time) string {

	return input.Format("2006-01-02T15:04:05Z")
}