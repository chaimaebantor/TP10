package ma.cigma.pfe.service;

import ma.cigma.pfe.dao.ClientDaoImpl;
import ma.cigma.pfe.dao.IClientDao;
import ma.cigma.pfe.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl  implements IClientservice{
    @Autowired
      IClientDao dao;



    public IClientDao getDao() {
        return dao;
    }

    @Override
    public boolean save(Client c) {
        System.out.println("service layer");
        return dao.save(c);
    }

    @Override
    public Client modify(Client c) {
        return dao.update(c);
    }

    @Override
    public void removeById(long id) {
        dao.deleteById(id);
    }

    @Override
    public Client getById(long id) {
        return dao.findById(id);
    }



}
