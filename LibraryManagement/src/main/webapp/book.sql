CREATE TABLE `book` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




select * from book;
ALTER TABLE book
MODIFY COLUMN Id INT AUTO_INCREMENT PRIMARY KEY;
DELETE FROM book WHERE id =10;

INSERT INTO book (title, author) VALUES
('To Kill a Mockingbird', 'Harper Lee'),
('1984', 'George Orwell'),
('The Great Gatsby', 'F. Scott Fitzgerald'),
('The Catcher in the Rye', 'J.D. Salinger'),
('Moby-Dick', 'Herman Melville'),
('Pride and Prejudice', 'Jane Austen'),
('The Lord of the Rings', 'J.R.R. Tolkien'),
('Animal Farm', 'George Orwell'),
('Jane Eyre', 'Charlotte Bronte'),
('War and Peace', 'Leo Tolstoy'),
('The Hobbit', 'J.R.R. Tolkien'),
('The Brothers Karamazov', 'Fyodor Dostoevsky'),
('Crime and Punishment', 'Fyodor Dostoevsky'),
('Great Expectations', 'Charles Dickens'),
('Wuthering Heights', 'Emily Bronte'),
('The Odyssey', 'Homer'),
('The Iliad', 'Homer'),
('Brave New World', 'Aldous Huxley'),
('The Count of Monte Cristo', 'Alexandre Dumas'),
('Frankenstein', 'Mary Shelley'),
('Anna Karenina', 'Leo Tolstoy'),
('Madame Bovary', 'Gustave Flaubert'),
('The Divine Comedy', 'Dante Alighieri'),
('Les Misérables', 'Victor Hugo'),
('A Tale of Two Cities', 'Charles Dickens'),
('The Picture of Dorian Gray', 'Oscar Wilde'),
('Dracula', 'Bram Stoker'),
('The Scarlet Letter', 'Nathaniel Hawthorne'),
('Don Quixote', 'Miguel de Cervantes'),
('Ulysses', 'James Joyce'),
('One Hundred Years of Solitude', 'Gabriel Garcia Marquez'),
('The Sound and the Fury', 'William Faulkner'),
('Heart of Darkness', 'Joseph Conrad'),
('The Old Man and the Sea', 'Ernest Hemingway'),
('Fahrenheit 451', 'Ray Bradbury'),
('Slaughterhouse-Five', 'Kurt Vonnegut'),
('Catch-22', 'Joseph Heller'),
('To the Lighthouse', 'Virginia Woolf'),
('The Sun Also Rises', 'Ernest Hemingway'),
('East of Eden', 'John Steinbeck'),
('The Grapes of Wrath', 'John Steinbeck'),
('Gone with the Wind', 'Margaret Mitchell'),
('Lolita', 'Vladimir Nabokov'),
('The Metamorphosis', 'Franz Kafka'),
('The Stranger', 'Albert Camus'),
('Beloved', 'Toni Morrison'),
('The Trial', 'Franz Kafka'),
('The Wind-Up Bird Chronicle', 'Haruki Murakami'),
('The Alchemist', 'Paulo Coelho');
