package service;

import dao.entities.FilmEntity;

import java.util.ArrayList;

public interface GenericFilmService extends GenericLabService<FilmEntity>{
    ArrayList<Integer> getIsos();
    int getShotsPerIso(Integer iso);
}
