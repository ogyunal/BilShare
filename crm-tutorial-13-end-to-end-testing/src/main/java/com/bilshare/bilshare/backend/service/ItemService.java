package com.bilshare.bilshare.backend.service;

import com.bilshare.bilshare.backend.entity.Item;
import com.bilshare.bilshare.backend.entity.Product;
import com.bilshare.bilshare.backend.repository.ProductRepository;
import com.bilshare.bilshare.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemService {
    private static final Logger LOGGER = Logger.getLogger(ItemService.class.getName());
    private ItemRepository itemRepository;
    private ProductRepository productRepository;

    public ItemService(ItemRepository itemRepository,
                       ProductRepository productRepository) {
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> findAll(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return itemRepository.findAll();
        } else  {
            return  itemRepository.search(filterText);
        }
    }

    public long count() {
        return itemRepository.count();
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }

    public void save(Item item) {
        if (item == null) {
            LOGGER.log(Level.SEVERE,
                "Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        itemRepository.save(item);
    }

    @PostConstruct
    public void populateTestData() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(
                Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
                    .map(Product::new)
                    .collect(Collectors.toList()));
        }

        if (itemRepository.count() == 0) {
            Random r = new Random(0);
            List<Product> companies = productRepository.findAll();
            itemRepository.saveAll(
                Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                    "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                    "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                    "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                    "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                    "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                    "Jaydan Jackson", "Bernard Nilsen")
                    .map(name -> {
                        String[] split = name.split(" ");
                        Item item = new Item();
                        item.setFirstName(split[0]);
                        item.setLastName(split[1]);
                        item.setProduct(companies.get(r.nextInt(companies.size())));
                        item.setStatus(Item.Status.values()[r.nextInt(Item.Status.values().length)]);
                        String email = (item.getFirstName() + "." + item.getLastName() + "@" + item.getProduct().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
                        item.setEmail(email);
                        return item;
                    }).collect(Collectors.toList()));
        }
    }
}
