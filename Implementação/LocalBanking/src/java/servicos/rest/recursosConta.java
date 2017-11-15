package servicos.rest;

import entidades.conta.Conta;
import entidades.conta.DAOConta;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/conta")
public class recursosConta {

    @POST
    @Path("/criar/{numero}/{agencia}/{titular}/{senha}")
    public void criar(@PathParam("numero") final int numero,@PathParam("agencia") final int agencia,
            @PathParam("titular") final String titular,@PathParam("senha") final String senha) {
        /* TO DO */
        DAOConta dao = new DAOConta();
        /* Pegar parametros do formulário */
        Conta conta = new Conta();
        conta.setAgencia(agencia);
        conta.setNumero(numero);
        conta.setSaldo(0);
        conta.setSenha(senha);
        conta.setTitular(titular);
        dao.criar(conta);
    }

    @GET
    @Path("/xml/{numero}")
    @Produces(MediaType.APPLICATION_XML)
    public Conta getConta(@PathParam("numero") final int numero) {
        /* TO DO */
        DAOConta dao = new DAOConta();
        Conta conta = dao.ler(numero);
        return conta;
    }

    @GET
    @Path("/json/{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Conta getContaJson(@PathParam("numero") final int numero) {
        /* TO DO */
        DAOConta dao = new DAOConta();
        Conta conta = dao.ler(numero);
        return conta;
    }

    @POST
    @Path("/atualizar/{numero}")
    public void atualizar(@PathParam("numero") final int numero) {
        /* TO DO */
    }

    @POST
    @Path("/deletar/{numero}")
    public void deletar(@PathParam("numero") final int numero) {
        /* TO DO */
    }

    @POST
    @Path("/agendar/{codPagamento}")
    public void agendar(@PathParam("codPagamento") final int codPagamento) {
        /* TO DO */
    }

    @POST
    @Path("/pagamento/{codPagamento}")
    public void pagamento(@PathParam("codPagamento") final int codPagamento) {
        /* TO DO */
    }

}
