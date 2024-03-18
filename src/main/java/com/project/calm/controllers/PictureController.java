package com.project.calm.controllers;

import com.project.calm.dto.PictureDTO;
import com.project.calm.entities.Picture;
import com.project.calm.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/api/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/all")
    public List<Picture> getAllPictures() { return pictureService.findAll(); }

    @GetMapping("/name")
    public List<Picture> getByName(@RequestParam String name) { return pictureService.findByName(name); }

    @PostMapping("/add")
    public Picture addPicture(@RequestBody PictureDTO pictureDTO) throws InstanceAlreadyExistsException {
        return pictureService.save(pictureDTO.toPicture());
    }

    @PutMapping("/update/{id}")
    public Picture updatePicture(@RequestBody PictureDTO pictureDTO, @PathVariable Integer id) {
        return pictureService.update(pictureDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePicture(@PathVariable Integer id) { pictureService.deleteById(id); }


}
