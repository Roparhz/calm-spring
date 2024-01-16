package com.project.calm.repositories;

import com.project.calm.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    boolean existsByNameContainingIgnoreCase(String name);

    List<Picture> findPictureByNameIgnoreCase(String name);
}
