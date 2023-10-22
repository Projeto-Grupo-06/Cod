package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        MenuItemService menuItemService = new MenuItemService(sessionFactory);

        // Adicionar um item ao cardápio
        MenuItem newItem = new MenuItem();
        newItem.setName("Hamburguer");
        newItem.setPrice(9.99);
        menuItemService.addItem(newItem);

        // Obter e imprimir todos os itens do cardápio
        System.out.println("Itens no cardápio:");
        List<MenuItem> menuItems = menuItemService.getAllItems();
        for (MenuItem item : menuItems) {
            System.out.println(item.getName() + " - R$" + item.getPrice());
        }

        // Atualizar um item
        MenuItem itemToUpdate = menuItemService.getItemById(1L);
        if (itemToUpdate != null) {
            itemToUpdate.setPrice(10.99);
            menuItemService.updateItem(itemToUpdate);
        }

        // Deletar um item
        menuItemService.deleteItem(1L);

        sessionFactory.close();
    }
}
