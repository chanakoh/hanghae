package com.hhmarket.service;

import com.hhmarket.entity.Item;
import com.hhmarket.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("item을 찾을 수 없습니다."));
        item.setTitle(itemDetails.getTitle());
        item.setContent(itemDetails.getContent());
        item.setPrice(itemDetails.getPrice());
        item.setUsername(itemDetails.getUsername());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
