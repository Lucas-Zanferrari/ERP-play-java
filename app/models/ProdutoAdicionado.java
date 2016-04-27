package models;

import com.avaje.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by dumorango on 4/26/16.
 */

@Entity
public class ProdutoAdicionado extends Model {

    public ProdutoAdicionado() {

    }

    @ManyToOne(cascade = CascadeType.ALL)
    Comanda comanda;

    Integer quantidade;
    Integer id;



    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
}