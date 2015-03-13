package br.unicesumar.restserver.Disciplina;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Disciplinas")
@Transactional
public class DisciplinaController {
    
    @Autowired
    private EntityManager em;

    @RequestMapping(method = RequestMethod.GET)
    public List<Disciplina> getDisciplina() {
        Query listar = em.createQuery("From Disciplina");
        return  listar.getResultList();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestBody Disciplina disciplina) {
        em.persist(disciplina);
    }        
    
    @RequestMapping(method = RequestMethod.PUT )
    public void alterarDisciplina(@RequestBody Disciplina disciplina) {
      em.remove(disciplina);
      em.persist(disciplina);
    }        
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void excluirDisciplina(@PathVariable Long id) {
        em.remove(id);
    }        
    
}
