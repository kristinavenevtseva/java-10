package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieItem first = new MovieItem(1, "Номер один", "комедия", "imageUrl", true);
    MovieItem second = new MovieItem(2, "Тролли.Мировой тур", "мультфильм", "imageUrl", true);
    MovieItem third = new MovieItem(3, "Человек-невидимка", "ужасы", "imageUrl", false);
    MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик", "imageUrl", false);
    MovieItem fifth = new MovieItem(5, "Отель \"Белград\"", "комедия", "imageUrl", false);
    MovieItem sixth = new MovieItem(6, "Вперёд", "мультфильм", "imageUrl", false);
    MovieItem seventh = new MovieItem(7, "Бладшот", "боевик", "imageUrl", false);

    @Test
    public void shouldGetLastDefaultMovies() {
        MovieManager manager = new MovieManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.getLastMovies();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastOverDefaultMovies() {
        MovieManager manager = new MovieManager(20);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.getLastMovies();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastUnderDefaultMovies() {
        MovieManager manager = new MovieManager(3);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.getLastMovies();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth};
        assertArrayEquals(expected, actual);
    }
}
