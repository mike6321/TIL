package com.example.enum_converter.controller;

import com.example.enum_converter.dto.MenuDto;
import com.example.enum_converter.entity.Menu;
import com.example.enum_converter.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuRepository menuRepository;

    @PostMapping
    @Transactional
    public void createMenu(@RequestBody MenuDto menuDto) {
        Menu menuEntity = Menu.of(menuDto);
        menuRepository.save(menuEntity);
    }

}
