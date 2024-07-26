/*package dao.dual;

import model.Tree;
import dao.*;
import java.util.List;

public class DualTreeDao implements TreeDao<Integer> {
    private final TreeDao<Integer> mysqlTreeDao;
    private final TreeDao<Integer> mongoTreeDao;

    public DualTreeDao(TreeDao<Integer> mysqlTreeDao, TreeDao<Integer> mongoTreeDao) {
        this.mysqlTreeDao = mysqlTreeDao;
        this.mongoTreeDao = mongoTreeDao;
    }

    @Override
    public void create(Tree tree) {
        mysqlTreeDao.create(tree);
        mongoTreeDao.create(tree);
    }

    @Override
    public Tree read(Integer id) {
        return mongoTreeDao.read(id); // Leer desde MongoDB
    }

    @Override
    public void update(Tree tree) {
        mysqlTreeDao.update(tree);
        mongoTreeDao.update(tree);
    }

    @Override
    public void deleteById(Integer id) {
        mysqlTreeDao.deleteById(id);
        mongoTreeDao.deleteById(id);
    }

    @Override
    public List<Tree> findAll() {
        return mongoTreeDao.findAll(); // Leer desde MongoDB
    }

    @Override
    public List<Tree> getAllTrees() {
        return mongoTreeDao.getAllTrees(); // Leer desde MongoDB
    }

    @Override
    public int getTotalStockForTrees() {
        return mongoTreeDao.getTotalStockForTrees(); // Leer desde MongoDB
    }

    @Override
    public double getTotalValueForTrees() {
        return mongoTreeDao.getTotalValueForTrees(); // Leer desde MongoDB
    }
}
*/