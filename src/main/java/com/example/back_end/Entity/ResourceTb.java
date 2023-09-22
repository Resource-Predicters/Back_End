package com.example.back_end.Entity;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class ResourceTb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id_pk")
    private int resourceIdPk;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (40)")
    private String resourceKorName;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (40)")
    private String resourceEngName;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (10)")
    private String resourceSymbol;

    @Builder
    public ResourceTb(String resourceKorName, String resourceEngName, String resourceSymbol) {
        this.resourceKorName = resourceKorName;
        this.resourceEngName = resourceEngName;
        this.resourceSymbol = resourceSymbol;
    }
}
