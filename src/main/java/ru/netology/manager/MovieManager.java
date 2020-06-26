package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];

    private int defaultLength = 10;
    private int customLength;

    public MovieManager(int customLength) {
        this.customLength = customLength;
    }

    public MovieManager() {
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getLastMovies() {

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
