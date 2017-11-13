/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.conta;

import java.util.List;

/**
 *
 * @author david
 * @param <E>
 */
public interface DAOGenerico<E> {

    public boolean criar(E e);

    public E ler(int id);

    public List<E> lerTodos();

    public E lerPorNome(String nome);

    public boolean atualizar(E e);

    public boolean deletar(E e);
}
