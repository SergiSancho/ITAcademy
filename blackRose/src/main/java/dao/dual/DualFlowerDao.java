/*package dao.dual;

import model.Flower;
import dao.*;
import java.util.List;

public class DualFlowerDao implements FlowerDao<Integer> {
    private final FlowerDao<Integer> mysqlFlowerDao;
    private final FlowerDao<Integer> mongoFlowerDao;

    public DualFlowerDao(FlowerDao<Integer> mysqlFlowerDao, FlowerDao<Integer> mongoFlowerDao) {
        this.mysqlFlowerDao = mysqlFlowerDao;
        this.mongoFlowerDao = mongoFlowerDao;
    }

    @Override
    public void create(Flower flower) {
        mysqlFlowerDao.create(flower);
        mongoFlowerDao.create(flower);
    }

    @Override
    public Flower read(Integer id) {
        return mongoFlowerDao.read(id); // Leer desde MongoDB
    }

    @Override
    public void update(Flower flower) {
        mysqlFlowerDao.update(flower);
        mongoFlowerDao.update(flower);
    }

    @Override
    public void deleteById(Integer id) {
        mysqlFlowerDao.deleteById(id);
        mongoFlowerDao.deleteById(id);
    }

    @Override
    public List<Flower> findAll() {
        return mongoFlowerDao.findAll(); // Leer desde MongoDB
    }

    @Override
    public List<Flower> getAllFlowers() {
        return mongoFlowerDao.getAllFlowers(); // Leer desde MongoDB
    }

    @Override
    public int getTotalStockForFlowers() {
        return mongoFlowerDao.getTotalStockForFlowers(); // Leer desde MongoDB
    }

    @Override
    public double getTotalValueForFlowers() {
        return mongoFlowerDao.getTotalValueForFlowers(); // Leer desde MongoDB
    }
}
*/