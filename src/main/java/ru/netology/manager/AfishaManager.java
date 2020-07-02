package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    private int defaultLength = 10;
    private int customLength;

    public AfishaManager(AfishaRepository repository) {

        this.repository = repository;
    }

    public void save(MovieItem item) {

        repository.save(item);
    }

    public void removeById(int id) {

        repository.removeById(id);
    }

    public void removeAll() {

        repository.removeAll();
    }

    public MovieItem[] findAll() {
        MovieItem[] items = repository.findAll();
        MovieItem[] result = new MovieItem[items.length];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1 - i;
            result[i] = items[index];
        }
        return result;
    }

    public MovieItem findById(int id) {
        repository.findById(id);
        return null;
    }

    public MovieItem[] getLastMovies() {
        MovieItem[] items = repository.findAll();

        int posterLength = 0;

        if (customLength == 0) {
            posterLength = defaultLength;
        } else {
            posterLength = customLength;
        }
        if (items.length < posterLength) {
            posterLength = items.length;
        }

        MovieItem[] result = new MovieItem[posterLength];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1 - i;
            result[i] = items[index];
        }
        return result;
    }
}




