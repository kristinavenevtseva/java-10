package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;
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
    void shouldRemoveById() {
        int idToRemove = 3;

        MovieItem[] returned = new MovieItem[]{first, second, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.findAll();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, second, first};

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
}
