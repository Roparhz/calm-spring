package com.project.calm.entities;


import com.project.calm.dto.PictureDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Picture")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column (name = "url")
    private String url;


    public Picture(){}


    public void update(PictureDTO pictureDTO){
        this.name = pictureDTO.getName();
        this.url = pictureDTO.getUrl();
    }
}
