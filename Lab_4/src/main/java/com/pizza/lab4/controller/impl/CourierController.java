package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.dao.impl.CourierDao;
import com.pizza.lab4.model.entity.Courier;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourierController implements AbstractController<Courier>{
    private final CourierDao courierDao = new CourierDao();

    @Override
    public ArrayList<Courier> findAll() throws SQLException {
        return courierDao.findAll();
    }
    @Override
    public Courier findOne(Integer id) throws SQLException {
        return courierDao.findOne(id);
    }

    @Override
    public void create(Courier entity) throws SQLException {
        courierDao.create(entity);
    }

    @Override
    public void update(Integer id, Courier entity) throws SQLException {
        courierDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        courierDao.delete(id);
    }
}

/*


public class ArtistController implements AbstractController<Artist> {
  private final ArtistDao artistDao = new ArtistDao();

  @Override
  public ArrayList<Artist> findAll() throws SQLException {
    return artistDao.findAll();
  }

  @Override
  public Artist findOne(Integer id) throws SQLException {
    return artistDao.findOne(id);
  }

  @Override
  public void create(Artist entity) throws SQLException {
    artistDao.create(entity);
  }

  @Override
  public void update(Integer id, Artist entity) throws SQLException {
    artistDao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    artistDao.delete(id);
  }
}
 */