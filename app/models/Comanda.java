package models;

import com.avaje.ebean.Model;
import java.util.Date;
import java.util.ArrayList;
/**
 * Created by lucaszanferrari on 9/04/2016.
 */
public class Comanda extends Model {
    private int id;
    private ArrayList<Produto> produtos;
    private ArrayList<Funcionario> funcionarios;
    private int cpf_cliente;
    private int qtd_produtos;
    private int preco_total;
    private Date data_hora_abertura;
    private Date data_hora_encerramento;
}