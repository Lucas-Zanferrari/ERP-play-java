package controllers;

import models.Produto;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.novo_produto;
import views.html.produtos;

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
        Form<Produto> produtoForm = Form.form(Produto.class);
        return ok(index.render("", "", novo_produto.render(produtoForm,"")));
    }

    public static Result create(){
        Form<Produto> produtoForm = Form.form(Produto.class);
        produtoForm = produtoForm.bindFromRequest();
        if (produtoForm.hasErrors()) {
            return badRequest(novo_produto.render(produtoForm,""));
        } else {
            Produto produtoObj = produtoForm.get();
            produtoObj.save();
            return ok(index.render("", "", novo_produto.render(produtoForm,"Produto cadastrado com sucesso.")));
        }
    }

    public static Result list(){
        return ok(index.render("", "produto", produtos.render(Produto.list(),null)));
    }
}
