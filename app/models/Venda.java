package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import com.avaje.ebean.Model;

import java.util.Date;

/**
 * Created by dumorango on 4/25/16.
 */
@Entity
public class Venda extends Model{

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    @Constraints.Required
    Comanda comanda;

    private Date data_hora_encerramento;

    public Date getData_hora_encerramento() {
        return data_hora_encerramento;
    }

    public void setData_hora_encerramento(Date data_hora_encerramento) {
        this.data_hora_encerramento = data_hora_encerramento;
    }
}
