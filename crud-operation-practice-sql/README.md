# CRUD Operation Practice Project

This project is a simple implementation of CRUD (Create, Read, Update, Delete) operations. The application allows users to perform basic database operations with minimal input requirements.

## Features

- **Create (Salve)**: Automatically saves an entry with a unique ID and the current date. No additional input is required from the user.
- **Read (See)**: Displays the saved entries.
- **Update**: Allows the user to update an existing entry by providing the ID and the new date in the format `YYYY-MM-DD`.
- **Delete**: Removes an entry from the database by specifying the ID.

## Usage

1. **Salve**: Select this option to save a new entry. The system will automatically generate an ID and record the current date.
2. **Delete**: Choose this option to remove an entry. You will need to provide the ID of the entry you wish to delete.
3. **Update**: Use this option to modify an existing entry. You must provide the ID and the new date in the specified format.
4. **See**: Select this option to view all saved entries.
5. **Exit**: This option allows you to exit the application.

## Notes

- The database handles the generation of the ID and the recording of the current date during the creation of an entry.
- The user is only prompted for additional information (ID and date) during update and delete operations.