package pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.entities;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name= "getAllEndConsumers", query= "SELECT e FROM EndConsumer e ORDER BY e.username DESC"),
})
public class EndConsumer extends User {

    @OneToMany(mappedBy = "endConsumer", cascade = CascadeType.REMOVE)
    public List<Order> orders;

    public EndConsumer(String username, String name, String password, String address, int phoneNumber) {
        super(username, name, password, address, phoneNumber);
        orders = new LinkedList<>();
    }

    public EndConsumer() {
        orders = new LinkedList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            //this.orders.add(order); -> Verificar
            orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            //this.orders.remove(order); -> Verificar
            orders.remove(order);
        }
    }

    /*
    - Atualizações de entrega: dados sobre a entrega em tempo real, incluindo horários
    estimados de entrega, localização da embalagem e notificações quando a embalagem está em
    entrega;
    - Informação de qualidade: dados relacionados com as condições ambientais durante o
    transporte e a qualidade geral do produto, que oferecem garantias aos consumidores sobre a
    integridade do produto;
    - Alertas de segurança: dados de segurança, como deteção de abertura e alertas de acesso
    não autorizado, para garantir ao consumidor final que o produto não foi aberto ou acedido
    indevidamente antes da sua entrega;
    - Consumo do cliente final: dados relativos ao consumo de determinado produto embalado
    (por exemplo, níveis de tinta em tinteiros de impressoras), para decidir acerca da realização de
    nova encomenda.
     */

}
