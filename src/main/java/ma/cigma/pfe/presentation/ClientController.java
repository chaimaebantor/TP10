package ma.cigma.pfe.presentation;

import ma.cigma.pfe.dao.IClientDao;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.service.ClientServiceImpl;
import ma.cigma.pfe.service.IClientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("idCtrl")
public class ClientController {
    @Autowired
    IClientservice service;




     public void getservice(IClientservice service) {

        this.service = service;
    }

    public void save(Client c)
    {
        System.out.println("presentation layer ");
      service.save(c);
    }

    public void modify(Client c)
    {
        service.modify(c);
    }

    public void removeById(long id){
        service.removeById(id);
    }

    public Client getById(long id){
        return service.getById(id);
    }



    public IClientservice getService() {

        return service;
    }
}
