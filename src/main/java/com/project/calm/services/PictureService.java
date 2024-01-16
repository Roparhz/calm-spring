package com.project.calm.services;

import com.project.calm.dto.PictureDTO;
import com.project.calm.entities.Picture;
import com.project.calm.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> findAll(){ return pictureRepository.findAll();}
    public List<Picture> findByName(String name){ return pictureRepository.findPictureByNameIgnoreCase(name);}
    public Picture save(Picture picture) throws InstanceAlreadyExistsException{
        if(pictureRepository.existsByNameContainingIgnoreCase(picture.getName())){
            throw new InstanceAlreadyExistsException("Le nom de l'image existe déjà !");
        }
        return pictureRepository.save(picture);
    }

    public Picture update(PictureDTO pictureDTO, Integer id) throws IllegalArgumentException, NoSuchElementException {
        Optional<Picture> pictureOptional = pictureRepository.findById(id);
        if(pictureOptional.isPresent()){
            Picture picture = pictureOptional.get();
            picture.update(pictureDTO);
            return pictureRepository.save(picture);
        }
        return null;
    }

    public Optional<Picture> deleteById(int id) throws IllegalArgumentException{
        Optional<Picture> optionalPicture = pictureRepository.findById(id);
        pictureRepository.deleteById(id);
        return optionalPicture;
    }
}
