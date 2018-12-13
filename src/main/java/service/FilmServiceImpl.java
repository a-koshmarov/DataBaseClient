package service;

import dao.GenericLabDAO;
import dao.GenericLabDAOImpl;
import dao.entities.FilmEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class FilmServiceImpl implements GenericFilmService{

    private GenericLabDAO<FilmEntity> dao;

    public FilmServiceImpl(SessionFactory sessionFactory, Class<FilmEntity> tClass) {
        this.dao = new GenericLabDAOImpl<FilmEntity>(sessionFactory, tClass);
    }

    @Override
    public ArrayList<Integer> getIsos(){
        ArrayList<Integer> isos = new ArrayList<>();
        for (FilmEntity entity : getAll()){
            if (!isos.contains(entity.getIso())){
                isos.add(entity.getIso());
            }
        }
        return isos;
    }

    @Override
    public int getShotsPerIso(Integer iso){
        int count = 0;
        for(FilmEntity entity : getAll()){
            if (entity.getIso().equals(iso)){
                count+=entity.getShots();
            }
        }
        return count;
    }

    @Override
    public List<FilmEntity> getAll() {
        return dao.getAll();
    }
}
