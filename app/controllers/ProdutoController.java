package controllers;

import models.Funcionario;
import models.Produto;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


/**
 * Created by dumorango on 4/11/16.
 */
public class ProdutoController extends Controller {

    public static Result index() {
        if(session().get("nome")==null){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Produto> form = Form.form(Produto.class);
        return ok(produto.render(form,""));
    }

    public static Result create(){
        Form<Produto> form = Form.form(Produto.class);
        form = form.bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(produto.render(form,""));
        } else {
            Produto produtoObj = form.get();
            produtoObj.save();
            return ok(index.render("Produto Cadastrado com Sucesso", null, null));
        }
    }

    public static Result list(){
        return ok(produtos.render(Produto.list(),null));
    }
}
