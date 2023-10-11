package com.project.calm.dto;


import com.project.calm.entities.Picture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PictureDTO {
    private String name;
    private String url;

    public PictureDTO(){}

    public PictureDTO(String name, String url){
        this.name = name;
        this.url = url;
    }

    public Picture toPicture(){
        Picture picture =new Picture();
        picture.setName(this.getName());
        picture.setUrl(this.getUrl());
        return picture;
    }
}
