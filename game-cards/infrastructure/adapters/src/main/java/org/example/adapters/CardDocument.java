package org.example.adapters;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document
@Getter
@Setter
public class CardDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private String url;
    private int poder;

    public CardDocument() {

    }

    public CardDocument(String id, String name, String description, String url, int poder) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setUrl(url);
        this.setPoder(poder);
    }
}
