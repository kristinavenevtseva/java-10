package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

    MovieItem first = new MovieItem(1, "Номер один", "комедия", "imageUrl", true);
    MovieItem second = new MovieItem(2, "Тролли.Мировой тур", "мультфильм", "imageUrl", true);
    MovieItem third = new MovieItem(3, "Человек-невидимка", "ужасы", "imageUrl", false);
    MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик", "imageUrl", false);
    MovieItem fifth = new MovieItem(5, "Отель \"Белград\"", "комедия", "imageUrl", false);
    MovieItem sixth = new MovieItem(6, "Вперёд", "мультфильм", "imageUrl", false);
    MovieItem seventh = new MovieItem(7, "Бладшот", "боевик", "imageUrl", false);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }

    @Test
    void shouldSave() {

        MovieItem eighth = new MovieItem(8, "Ёлки", "комедия", "imageUrl", false);

        repository.save(eighth);

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        int idToRemove = 3;

        repository.removeById(idToRemove);

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {

        repository.removeAll();

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {

        int idToFind = 3;

        repository.findById(idToFind);

        MovieItem actual = repository.findById(idToFind);
        MovieItem expected = third;

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindIfNotExists() {

        int idToFind = 10;

        repository.findById(idToFind);

        MovieItem actual = repository.findById(idToFind);
        MovieItem expected = null;

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }


}