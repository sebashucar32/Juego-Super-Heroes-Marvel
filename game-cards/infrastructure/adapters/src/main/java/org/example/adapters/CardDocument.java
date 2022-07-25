package org.example.adapters;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class CardDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private String url;
    private double poder;

    public CardDocument() {

    }

    public CardDocument(String id, String name, String description, String url, double poder) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setUrl(url);
        this.setPoder(poder);
    }
}
